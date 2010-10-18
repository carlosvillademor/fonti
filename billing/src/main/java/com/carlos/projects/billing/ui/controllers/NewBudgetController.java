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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.ParameterizableViewController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Controller to show the families and components to create a new budget document
 *
 * @author Carlos Fernandez
 * @date 29-Apr-2010
 */
public class NewBudgetController extends ParameterizableViewController {

    private NewBudgetViewHelper newBudgetViewHelper;

    public NewBudgetController() {
    }

    public NewBudgetController(NewBudgetViewHelper newBudgetViewHelper) {
        this.newBudgetViewHelper = newBudgetViewHelper;
    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("newBudgetViewHelper", newBudgetViewHelper);
        return new ModelAndView(getViewName(), model);
    }

    public void setNewBudgetViewHelper(NewBudgetViewHelper newBudgetViewHelper) {
        this.newBudgetViewHelper = newBudgetViewHelper;
    }

}