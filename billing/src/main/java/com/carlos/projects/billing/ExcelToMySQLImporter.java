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

import com.carlos.projects.billing.dao.FamilyDAO;
import com.carlos.projects.billing.domain.Family;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Carlos Fernandez
 * 
 * @date 6 Oct 2009
 * 
 * Implementation of the Importer interface that imports from an Excel file 
 * to a MySQL database
 */
public class ExcelToMySQLImporter implements Importer {

    private FamilyDAO familyDAO;

    private Properties messages;

    public ExcelToMySQLImporter(FamilyDAO familyDAO) {
        this.familyDAO = familyDAO;
    }

    /* (non-Javadoc)
      * @see com.carlos.projects.billing.Importer#importData()
      */
	public long importData(MultipartFile excelFile) {
        File componentsFile = new File("components.xls");
        InputStream input;
        Workbook workbook;
        try {
            excelFile.transferTo(componentsFile);
            input = new FileInputStream(componentsFile);
            workbook = WorkbookFactory.create(input);
        } catch (IOException e) {
            throw new RuntimeException(messages.getProperty("import.error"), e);
        } catch (InvalidFormatException e) {
            throw new RuntimeException(messages.getProperty("import.error"), e);
        }
        Sheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(0);
        String familyDescription = row.getCell(9).getStringCellValue();
        String familyCode = row.getCell(4).getStringCellValue();
        Family family = new Family();
        family.setCode(familyCode);
        family.setDescription(familyDescription);
        return (long) (sheet.getLastRowNum());
	}
	
}