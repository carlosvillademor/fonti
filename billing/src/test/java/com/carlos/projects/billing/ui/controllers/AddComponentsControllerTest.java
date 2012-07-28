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

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.web.servlet.ModelAndView;

import com.carlos.projects.billing.dao.DocumentDAO;
import com.carlos.projects.billing.domain.Document;
import com.carlos.projects.billing.domain.DocumentComponent;
import com.carlos.projects.billing.domain.DocumentComponentBuilder;

/**
 * Unit tests for @link{AddComponentsController}
 *
 * @author: Carlos Fernandez
 * @date: 29 Jul 2010
 */
public class AddComponentsControllerTest {

    @Mock
    private HttpServletRequest request;
    @Mock
    private DocumentDAO documentDAO;
    private HttpServletResponse response;
    private AddComponentsController controller;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        controller = new AddComponentsController(documentDAO);
        response = null;
    }

    @Test
    public void shouldAddFamilyNameToModel() throws Exception {
        //Given
        String familyName = "familyName";
        when(request.getParameter("familyName")).thenReturn(familyName);
        //When
        ModelAndView modelAndView = controller.handleRequestInternal(request, response);
        //Then
        assertThat("Family name value is wrong", (String) modelAndView.getModelMap().get("familyName"), is(familyName));
    }

    @Test
    public void shouldAddDocumentToModel() throws Exception {
        //Given
        Document expectedDocument = givenExpectedComponentsAdded();
        Map<String, String[]> parameters = givenRequestParameters();
        when(request.getParameterMap()).thenReturn(parameters);
        //When
        ModelAndView modelAndView = controller.handleRequestInternal(request, response);
        //Then
        assertThat("Model does not contain document with components added", (Document) modelAndView
                .getModelMap().get("document"), is(expectedDocument));
    }

    @Test
	public void shouldUseExistingDocumentIfRequestHasAValidaDocumentId() throws Exception {
		//Given
    	Document document = new Document();
    	document.setId(1L);
        Map<String, String[]> parameters = givenRequestParameters();
        String[] documentId = {"1"};
        parameters.put("documentId", documentId);
        when(request.getParameterMap()).thenReturn(parameters);
		when(documentDAO.getById(Document.class, 1L)).thenReturn(document);
		//When
        ModelAndView modelAndView = controller.handleRequestInternal(request, response);
		//Then
        assertThat("A new document has been created when document with id 1 should have been used", 
        		((Document) modelAndView.getModelMap().get("document")).getId(), is(1L));
        ArgumentCaptor<Document> documentCaptor = ArgumentCaptor.forClass(Document.class);
        Mockito.verify(documentDAO).saveOrUpdate(documentCaptor.capture());
        assertThat("The document saved does not have the same id than came on the request", 
        		documentCaptor.getValue().getId(), is(1L));
	}
    
    private Map<String, String[]> givenRequestParameters() {
        Map<String, String[]> parameters = new HashMap<String, String[]>();
        String[] component1Code = {"code1"};
        parameters.put("componentCodecode1", component1Code);
        String[] component1Quantity = {"1.0"};
        parameters.put("code1Quantity", component1Quantity);
        String[] component1Discount = {"25.0"};
        parameters.put("code1Discount", component1Discount);
        String[] component1Price = {"100.00"};
        parameters.put("code1Price", component1Price);
        String[] component1Description = {"description1"};
        parameters.put("code1Description", component1Description);
        String[] component2Code = {"code1"};
        parameters.put("componentCodecode2", component2Code);
        String[] component2Quantity = {"2.0"};
        parameters.put("code2Quantity", component2Quantity);
        String[] component2Discount = {"50.0"};
        parameters.put("code2Discount", component2Discount);
        String[] component2Price = {"200.0"};
        parameters.put("code2Price", component2Price);
        String[] component2Description = {"description2"};
        parameters.put("code2Description", component2Description);
        return parameters;
    }

    private Document givenExpectedComponentsAdded() {
        Document expectedDocument = new Document();
        DocumentComponent documentComponent1 = createDocumentComponent("code1", "1.0", "25.0", "100.0", "description1");
        DocumentComponent documentComponent2 = createDocumentComponent("code2", "2.0", "50.0", "200.0", "description2");
        expectedDocument.setDocumentComponents(documentComponent1, documentComponent2);
        return expectedDocument;
    }

    private DocumentComponent createDocumentComponent(String code, String quantity, String discount, String price, String description) {
        return new DocumentComponentBuilder()
                .withCode(code)
                .withQuantity(Double.valueOf(quantity))
                .withDiscountApplied(Double.valueOf(discount))
                .withPrice(Double.valueOf(price))
                .withDescription(description)
                .build();

    }

}