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

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

/**
 * @author: Carlos Fernandez
 *
 * @date: 29 Jul 2010
 *
 * Unit tests for @link{AddComponentsController}
 */
public class AddComponentsControllerTest {

    @Mock private HttpServletRequest request;
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

}