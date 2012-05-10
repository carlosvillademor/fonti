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
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

/**
 * Unit tests for {@link com.carlos.projects.billing.ui.controllers.DocumentController}
 *
 * @author Carlos Fernandez
 * @date 10-Apr-2012
 */

@RunWith(MockitoJUnitRunner.class)
public class DocumentControllerTest {

    public static final String DOCUMENT_VIEW_NAME = "document";
    private DocumentController documentController;
    private Long documentId;
    @Mock
    private HttpServletResponse response;
    @Mock
    private HttpServletRequest request;
    @Mock
    private DocumentDAO documentDAO;

    @Before
    public void startUp() {
        documentController = new DocumentController(documentDAO);
        documentId = 1L;
        when(request.getParameter("documentId")).thenReturn(documentId.toString());
    }

    @Test
    public void shouldRenderTheCorrectView() throws Exception {
        //Given
        documentController.setViewName(DOCUMENT_VIEW_NAME);
        //When
        ModelAndView modelAndView = documentController.handleRequestInternal(request, response);
        //Then
        assertThat("The view name is wrong", modelAndView.getViewName(), is(DOCUMENT_VIEW_NAME));
    }

    @Test
    public void shouldHaveTheDocumentInTheModel() throws Exception {
        //Given
        Document expectedDocument = new Document();
        expectedDocument.setId(documentId);
        when(documentDAO.getById(Document.class, 1L)).thenReturn(expectedDocument);
        //When
        ModelAndView modelAndView = documentController.handleRequestInternal(request, response);
        //Then
        assertThat("The document is not present on the model", (Document) modelAndView.getModelMap().get("document"), is(expectedDocument));
    }

}
