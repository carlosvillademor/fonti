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

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.servlet.ModelAndView;

import com.carlos.projects.billing.dao.DocumentDAO;
import com.carlos.projects.billing.domain.Document;

/**
 * @author Carlos Fernandez
 * @date 11-05-2012
 */

@RunWith(MockitoJUnitRunner.class)
public class DocumentsControllerTest {

	private static final String DOCUMENTS_VIEW_NAME = "documents";
	private DocumentsController controller;

	@Mock
	private DocumentDAO documentDAO;
	@Mock
	private HttpServletRequest request;
	@Mock
	private HttpServletResponse response;

	@Before
	public void setUp() {
		controller = new DocumentsController(documentDAO);
	}

	@Test
	public void shouldRenderTheCorrectView() throws Exception {
		// Given
		controller.setViewName(DOCUMENTS_VIEW_NAME);
		// When
		ModelAndView modelAndView = controller.handleRequestInternal(request,
				response);
		// Then
		assertThat("The view name is wrong", modelAndView.getViewName(),
				is(DOCUMENTS_VIEW_NAME));
	}

	@Test
	public void shouldListAllTheDocuments() throws Exception {
		// Given
		controller.setViewName(DOCUMENTS_VIEW_NAME);
		List<Document> documents = new ArrayList<Document>();
		documents.add(new Document());
		when(documentDAO.findAll("Document")).thenReturn(documents);
		// When
		ModelAndView modelAndView = controller.handleRequestInternal(request,
				response);
		// Then
		assertThat("Not all the documents are listed",
				(List<Document>) modelAndView.getModel().get("documents"),
				is(documents));
	}

}