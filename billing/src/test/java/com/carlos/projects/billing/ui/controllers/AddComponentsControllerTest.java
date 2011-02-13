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

import com.carlos.projects.billing.domain.DocumentComponent;
import com.carlos.projects.billing.domain.DocumentComponentBuilder;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

/**
 * @author: Carlos Fernandez
 * @date: 29 Jul 2010
 * <p/>
 * Unit tests for @link{AddComponentsController}
 */
public class AddComponentsControllerTest {

    @Mock
    private HttpServletRequest request;
    private HttpServletResponse response;
    private AddComponentsController controller;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        controller = new AddComponentsController();
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
    public void shouldAddComponentsToModel() throws Exception {
        //Given
        Map<String, DocumentComponent> expectedComponentsAdded = new HashMap<String, DocumentComponent>();
        String code1 = "code1";
        String quantity1 = "1.0";
        String discounted1 = "25.0";
        String price1 = "100.0";
        String description1 = "description1";
        DocumentComponent documentComponent1 = new DocumentComponentBuilder()
                .withCode(code1)
                .withQuantity(Double.valueOf(quantity1))
                .withDiscountApplied(Double.valueOf(discounted1))
                .withPrice(Double.valueOf(price1))
                .withDescription(description1)
                .build();
        expectedComponentsAdded.put(code1, documentComponent1);
        String code2 = "code2";
        String quantity2 = "2.0";
        String discounted2 = "50.0";
        String price2 = "200.0";
        String description2 = "description2";
        DocumentComponent documentComponent2 = new DocumentComponentBuilder()
                .withCode(code2)
                .withQuantity(Double.valueOf(quantity2))
                .withDiscountApplied(Double.valueOf(discounted2))
                .withPrice(Double.valueOf(price2))
                .withDescription(description2)
                .build();
        expectedComponentsAdded.put(code2, documentComponent2);

        Map<String, String[]> parameters = new HashMap<String, String[]>();
        when(request.getParameterMap()).thenReturn(parameters);
        String[] component1Code = {code1};
        parameters.put("componentCodecode1", component1Code);
        String[] component1Quantity = {quantity1};
        parameters.put("code1Quantity", component1Quantity);
        String[] component1Discount = {discounted1};
        parameters.put("code1Discount", component1Discount);
        String[] component1Price = {price1};
        parameters.put("code1Price", component1Price);
        String[] component1Description = {description1};
        parameters.put("code1Description", component1Description);
        String[] component2Code = {code1};
        parameters.put("componentCodecode2", component2Code);
        String[] component2Quantity = {quantity2};
        parameters.put("code2Quantity", component2Quantity);
        String[] component2Discount = {discounted2};
        parameters.put("code2Discount", component2Discount);
        String[] component2Price = {price2};
        parameters.put("code2Price", component2Price);
        String[] component2Description = {description2};
        parameters.put("code2Description", component2Description);

        //When
        ModelAndView modelAndView = controller.handleRequestInternal(request, response);

        //Then
        assertThat("Model does not contain components added", (Map<String, DocumentComponent>) modelAndView
                .getModelMap().get("componentsAdded"), is(expectedComponentsAdded));
    }

}