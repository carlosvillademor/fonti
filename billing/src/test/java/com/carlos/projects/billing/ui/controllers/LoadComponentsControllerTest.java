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

import com.carlos.projects.billing.dao.FamilyDAO;
import com.carlos.projects.billing.domain.Component;
import com.carlos.projects.billing.domain.Family;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Unit tests for {@link com.carlos.projects.billing.ui.controllers.LoadComponentsController}
 *
 * @author Carlos Fernandez
 * @date 25 May 2010
 */

@RunWith(MockitoJUnitRunner.class)
public class LoadComponentsControllerTest {

    LoadComponentsController controller;
    String familyCode;

    @Mock
    FamilyDAO familyDao;
    @Mock
    Family family;
    @Mock
    HttpServletRequest request;
    @Mock
    HttpServletResponse response;

    @Before
    public void setup() {
        controller = new LoadComponentsController(familyDao);
        controller.setViewName("loadComponents");
        when(request.getMethod()).thenReturn("POST");
        familyCode = "familyCode";
        when(request.getParameter("familyCode")).thenReturn(familyCode);
        when(familyDao.getById(Family.class, familyCode)).thenReturn(family);
    }

    @SuppressWarnings({"unchecked"})
    @Test
    public void shouldLoadComponentsAndFamilyNameForAGivenFamilyCode() throws Exception {
        // Given
        Set<Component> components = mockComponents();
        String familyName = "Family name";
        when(family.getComponents()).thenReturn(components);
        when(family.getDescription()).thenReturn(familyName);

        // When
        ModelAndView modelAndView = controller.handleRequest(request, response);

        // Then
        verify(familyDao).getById(Family.class, familyCode);
        verify(family).getComponents();
        verify(request).getParameter("familyCode");
        assertThat((Set<Component>) modelAndView.getModel().get("components"), is(components));
        assertThat((String) modelAndView.getModel().get("familyName"), is(familyName));
        assertThat(modelAndView.getViewName(), is(controller.getViewName()));
    }

    @Test
    public void shouldAddDocumentIdToModelIfItIsPresentOnRequest() throws Exception {
        //Given
        Long documentId = 123L;
        when(request.getParameter("documentId")).thenReturn(documentId.toString());

        //When
        ModelAndView modelAndView = controller.handleRequest(request, response);

        //Then
        assertThat("The document id is wrong", (Long) modelAndView.getModel().get("documentId"), is(documentId));
    }

    @Test
    public void shouldNotAddDocumentIdToModelIfItIsPresentOnRequestButItIsNotNumeric() throws Exception {
        //Given
        String documentId = "123a";
        when(request.getParameter("documentId")).thenReturn(documentId);

        //When
        ModelAndView modelAndView = controller.handleRequest(request, response);

        //Then
        assertThat("The document id is wrong", modelAndView.getModel().get("documentId"), is(nullValue()));
    }

    private Set<Component> mockComponents() {
        Set<Component> components = new HashSet<Component>();
        Component component1 = new Component();
        components.add(component1);
        Component component2 = new Component();
        components.add(component2);
        return components;
    }

}