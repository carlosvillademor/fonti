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
package com.carlos.projects.billing.ui.controllers;

import com.carlos.projects.billing.dao.DocumentDAO;
import com.carlos.projects.billing.domain.Document;
import com.carlos.projects.billing.domain.DocumentComponent;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.ParameterizableViewController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Controller to add selected components to a document
 *
 * @author: Carlos Fernandez
 * @date: 30 Jul 2010
 */
public class AddComponentsController extends ParameterizableViewController {

    private static final int COMPONENT_CODE = 13;
    private DocumentDAO documentDAO;

    public AddComponentsController() {
        super();
    }

    public AddComponentsController(DocumentDAO documentDAO) {
        this.documentDAO = documentDAO;
    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = super.handleRequestInternal(request, response);
        modelAndView.getModelMap().addAttribute("familyName", request.getParameter("familyName"));
        modelAndView.getModelMap().addAttribute("document", getDocumentWithComponentsAdded(request.getParameterMap()));
        return modelAndView;
    }

    private Document getDocumentWithComponentsAdded(Map<String, String[]> parameterMap) {
    	Document document;
    	String[] documentId = parameterMap.get("documentId");
		if(documentId != null && (!StringUtils.isEmpty(documentId[0]) && (StringUtils.isNumeric(documentId[0])))){
    		document = documentDAO.getById(Document.class, Long.parseLong(documentId[0]));
    	} else {
    		document = new Document();
    	}
        Set<DocumentComponent> documentComponentsAdded = new HashSet<DocumentComponent>();
        for (String key : parameterMap.keySet()) {
            if (key.startsWith("componentCode")) {
                documentComponentsAdded.add(createDocumentComponent(getComponentCode(key), parameterMap, document));
            }
        }
        document.setDocumentComponents(documentComponentsAdded);
        documentDAO.saveOrUpdate(document);
        return document;
    }

    private String getComponentCode(String key) {
        return key.substring(COMPONENT_CODE);
    }

    private DocumentComponent createDocumentComponent(String componentCode, Map<String, String[]> parameterMap, Document document) {
        DocumentComponent component = new DocumentComponent();
        component.setDescription(parameterMap.get(componentCode + "Description")[0]);
        component.setCode(componentCode);
        component.setDiscountApplied(Double.valueOf(parameterMap.get(componentCode + "Discount")[0]));
        component.setPrice(Double.valueOf(parameterMap.get(componentCode + "Price")[0]));
        component.setQuantity(Double.valueOf(parameterMap.get(componentCode + "Quantity")[0]));
        component.setDocument(document);
        return component;
    }

}