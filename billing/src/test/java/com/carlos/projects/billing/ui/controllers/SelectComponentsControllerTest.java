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

import com.carlos.projects.billing.domain.Component;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author: Carlos Fernandez
 *
 * @date: 02 Aug 2010
 *
 * Unit tests for @link{SelectComponentsController}
 */
public class SelectComponentsControllerTest {

    @Test
    public void shouldForwardToNewDocumentPageWithComponentsInModel() throws Exception {
        //Given
        SelectComponentsController controller = new SelectComponentsController();
        controller.setViewName("selectComponents");
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setMethod("POST");
        request.setParameter("selectComponent1", "componentId1");
        request.setParameter("selectComponent2", "componentId2");
        MockHttpServletResponse response = new MockHttpServletResponse();
        List<Component> expectedComponents = new ArrayList<Component>();
        Component component1 = new Component();
        component1.setCode("compoonentId1");
        expectedComponents.add(component1);
        Component component2 = new Component();
        expectedComponents.add(component2);
        component1.setCode("compoonentId2");

        //When
        ModelAndView modelAndView = controller.handleRequest(request, response);

        //Then
        assertThat(modelAndView.getViewName(), is("selectComponents"));
        assertThat((List<Component>) modelAndView.getModelMap().get("components"),
                is(expectedComponents));
    }

}