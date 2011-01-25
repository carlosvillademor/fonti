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
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Carlos Fernandez
 * @date: 29 Jul 2010
 * <p/>
 * Unit tests for @link{AddComponentsController}
 */
public class AddComponentsControllerTest {

    @Mock
    private HttpServletRequest request;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldAddComponentsToDocument() throws Exception {
        //Given
        HttpServletResponse response = null;
        AddComponentsController addController = new AddComponentsController();
        Map<String, DocumentComponent> documentComponents = new HashMap<String, DocumentComponent>();
        documentComponents.put("s", null);

        //When
        ModelAndView modelAndView = addController.handleRequestInternal(request, response);

        //Then
//        assertThat("The list of components in the document is wrong",
//                (Map<String, DocumentComponent>) modelAndView.getModel().get("documentComponents"),
//                is(documentComponents));
    }

}