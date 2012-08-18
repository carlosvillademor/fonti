/**
 * Fonti is a web application for billing and budgeting
 * Copyright (C) 2009  Carlos Fernandez
 *
 * This file is part of Fonti.
 *
 * Fonti is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Fonti is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.carlos.projects.billing;

import com.carlos.projects.billing.dao.ComponentDAO;
import com.carlos.projects.billing.dao.FamilyDAO;
import com.carlos.projects.billing.domain.Component;
import com.carlos.projects.billing.domain.Family;
import com.carlos.projects.billing.exceptions.ImportException;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;

/**
 * Implementation of the Importer interface that imports from an Excel file
 * to a MySQL database
 *
 * @author Carlos Fernandez
 * @date 6 Oct 2009
 */
public class ExcelToMySQLImporter implements Importer {

    private Log log = LogFactory.getLog(ExcelToMySQLImporter.class);

    private FamilyDAO familyDAO;

    private ComponentDAO componentDAO;

    private Properties messages;

    private static final int FAMILY_CODE = 4;
    private static final int FAMILY_DESCRIPTION = 9;
    private static final int COMPONENT_CODE = 2;
    private static final int COMPONENT_DESCRIPTION = 3;
    private static final int COMPONENT_DISCOUNT_1 = 6;
    private static final int COMPONENT_DISCOUNT_2 = 7;
    private static final int COMPONENT_PRICE = 8;

    public ExcelToMySQLImporter(FamilyDAO familyDAO, ComponentDAO componentDAO) {
        this.familyDAO = familyDAO;
        this.componentDAO = componentDAO;
    }

    public void setMessages(Properties messages) {
        this.messages = messages;
    }

    public Long importData(MultipartFile excelFile) throws ImportException {
        XSSFWorkbook workbook;
        File componentsFile;
        try {
            componentsFile = new File("components-" + new Date().getTime() + ".xlsx");
            excelFile.transferTo(componentsFile);
            workbook = new XSSFWorkbook(componentsFile.getAbsolutePath());
        } catch (IOException e) {
            throw new ImportException(messages.getProperty("import.error"), e);
        }
        workbook.setMissingCellPolicy(Row.CREATE_NULL_AS_BLANK);
        Iterator<Row> rowIterator = workbook.getSheetAt(workbook.getActiveSheetIndex()).iterator();
        Long numberOfImportedItems = 0L;
        log.info("Starting reading from file " + excelFile.getOriginalFilename() + " to import components to database");
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            String familyCode = row.getCell(FAMILY_CODE).getStringCellValue().trim();
            //The first row of the excel file is the one with the titles
            if (row.getRowNum() != 0 && StringUtils.isNotBlank(familyCode)) {
                Family family = familyDAO.getById(Family.class, familyCode);
                boolean saveFamily = false;
                if (family == null) {
                    family = createFamilyFromRow(row);
                    saveFamily = true;
                }
                String componentCode = row.getCell(COMPONENT_CODE).getStringCellValue().trim();
                Component component = componentDAO.getById(Component.class, componentCode);
                boolean addComponent = false;
                if (component == null) {
                    addComponent = true;
                    component = createComponent(row, family);
                    numberOfImportedItems += 1L;
                }
                if (saveFamily) {
                    if (addComponent) {
                        family.addComponent(component);
                    }
                    familyDAO.save(family);
                    log.info("Family " + family + " saved into the database");
                } else {
                    componentDAO.save(component);
                    log.info("Component " + component + " saved into the database");
                }
            }
        }
        closeAndDeleteTemporaryFiles(componentsFile);
        log.info("Components import to database finished");
        return numberOfImportedItems;
    }

    private void closeAndDeleteTemporaryFiles(File componentsFile) {
        if ((componentsFile != null) && (!componentsFile.delete())) {
            componentsFile.deleteOnExit();
        }
    }

    private Family createFamilyFromRow(Row row) {
        Family family = new Family();
        family.setCode(StringUtils.trim(row.getCell(FAMILY_CODE).getStringCellValue()));
        family.setDescription(StringUtils.trim(row.getCell(FAMILY_DESCRIPTION).getStringCellValue()));
        return family;
    }

    private Component createComponent(Row row, Family family) {
        Component component = new Component();
        component.setCode(StringUtils.trim(row.getCell(COMPONENT_CODE).getStringCellValue()));
        component.setDescription(StringUtils.trim(row.getCell(COMPONENT_DESCRIPTION).getStringCellValue()));
        component.setDiscount1(row.getCell(COMPONENT_DISCOUNT_1).getNumericCellValue());
        component.setDiscount2(row.getCell(COMPONENT_DISCOUNT_2).getNumericCellValue());
        component.setPrice(row.getCell(COMPONENT_PRICE).getNumericCellValue());
        component.setFamily(family);
        return component;
    }

}