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

import com.carlos.projects.billing.ui.helpers.NewBudgetViewHelper;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

/**
 * Unit tests for {@link com.carlos.projects.billing.ui.controllers.NewBudgetController}
 *
 * @author Carlos Fernandez
 * @date 29-Apr-2010
 */

@RunWith(MockitoJUnitRunner.class)
public class NewBudgetControllerTest {

    NewBudgetController controller;
    NewBudgetViewHelper newBudgetViewHelper;
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;

    @Before
    public void setUp() {
        newBudgetViewHelper = new NewBudgetViewHelper();
        controller = new NewBudgetController(newBudgetViewHelper);
        when(request.getMethod()).thenReturn("GET");
    }

    @Test
    public void shouldForwardToNewBudgetPage() throws Exception {
        //given
        controller.setViewName("newBudget");

        //when
        ModelAndView modelAndView = controller.handleRequest(request, response);

        //then
        assertThat(modelAndView.getViewName(), is("newBudget"));
        assertThat((NewBudgetViewHelper) modelAndView.getModel().get("newBudgetViewHelper"), is(newBudgetViewHelper));
    }

    @Test
    public void shouldAddDocumentIdToModelIfItIsPresentOnRequest() throws Exception {
        //given
        Long documentId = 123L;
        when(request.getParameter("documentId")).thenReturn(documentId.toString());

        //when
        ModelAndView modelAndView = controller.handleRequest(request, response);

        //then
        assertThat("Document id is not correct", (Long) modelAndView.getModel().get("documentId"), is(documentId));
    }

    @Test
    public void shouldNotAddDocumentIdToModelIfItIsPresentOnRequestButIsNotNumeric() throws Exception {
        //given
        String documentId = "123a";
        when(request.getParameter("documentId")).thenReturn(documentId);

        //when
        ModelAndView modelAndView = controller.handleRequest(request, response);

        //then
        assertThat("Document id is not correct", modelAndView.getModel().get("documentId"), is(nullValue()));
    }

}