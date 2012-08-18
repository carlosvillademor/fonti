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

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

/**
 * Unit tests for {@link com.carlos.projects.billing.ui.controllers.NewDocumentController}
 *
 * @author Carlos Fernandez
 * @date 22-Apr-2010
 */
public class NewDocumentControllerTest {

    @Test
    public void shouldForwardToNewDocumentPage() throws Exception {
        //given
        NewDocumentController controller = new NewDocumentController();
        controller.setViewName("newDocument");
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setMethod("GET");
        MockHttpServletResponse response = new MockHttpServletResponse();

        //when
        ModelAndView modelAndView = controller.handleRequest(request, response);

        //then
        assertThat(modelAndView.getViewName(), is("newDocument"));
    }

}