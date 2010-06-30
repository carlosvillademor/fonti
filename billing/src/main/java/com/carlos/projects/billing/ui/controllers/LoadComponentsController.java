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
import com.carlos.projects.billing.domain.Family;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.ParameterizableViewController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Controller to load the components for a given family code
 *
 * @author Carlos Fernandez
 * @date 25 May 2010
 */
public class LoadComponentsController extends ParameterizableViewController {

	private final FamilyDAO familyDao;

    public LoadComponentsController(FamilyDAO familyDao) {
        this.familyDao = familyDao;
    }

    /* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.AbstractController#handleRequest(
	 * javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
    @Override
	public ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Family family = familyDao.getById(Family.class, request.getParameter("familyCode"));
		Map<String, Object> model = new HashMap<String, Object>();
        model.put("familyName", family.getDescription());
		model.put("components", family.getComponents());
		return new ModelAndView(getViewName(), model);
	}

}