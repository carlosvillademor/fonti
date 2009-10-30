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

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.carlos.projects.billing.Importer;
import com.carlos.projects.billing.domain.FileUpload;

/**
 * @author Carlos Fernandez
 *
 * @date 19 Jul 2009
 * 
 * Controller to import the document with the list of components
 *
 */
public class ImportComponentsController extends SimpleFormController {

	private Importer importer;

	public ImportComponentsController() {
		super();
	}

	/**
	 * @return the importer
	 */
	public Importer getImporter() {
		return importer;
	}

	/**
	 * @param importer the importer to set
	 */
	public void setImporter(Importer importer) {
		this.importer = importer;
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.SimpleFormController#onSubmit(java.lang.Object)
	 */
	@Override
	protected ModelAndView onSubmit(Object command)
			throws Exception {
		FileUpload bean = (FileUpload) command;
		MultipartFile file = bean.getFile();

		long imported = importer.importData(file);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("imported", imported);
		return new ModelAndView("showComponents", model);
	}

}