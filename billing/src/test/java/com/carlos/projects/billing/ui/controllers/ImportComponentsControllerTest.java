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

import com.carlos.projects.billing.ExcelToMySQLImporter;
import com.carlos.projects.billing.Importer;
import com.carlos.projects.billing.domain.FileUpload;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Carlos Fernandez
 * 
 * @date 6 Oct 2009
 * 
 * Unit tests for {@link ImportComponentsController}}
 */
public class ImportComponentsControllerTest {

	@SuppressWarnings("unchecked")
	@Test
	public void shouldImportDataAndPutNumberOfImportedItemsInTheModelWhenOnSubmit() 
			throws Exception{
		//given
		Importer importer = mock(ExcelToMySQLImporter.class);
		FileUpload command = mock(FileUpload.class);
		MultipartFile file = mock(MultipartFile.class);
		command.setFile(file);
		ImportComponentsController controller = new ImportComponentsController();
		controller.setImporter(importer);
		Map<String, Object> expectedModel = new HashMap<String, Object>();
		expectedModel.put("componentsImported", 3L);
		when(command.getFile()).thenReturn(file);
		when(importer.importData(file)).thenReturn(3L);
		
		//when
		ModelAndView mav = controller.onSubmit(command);
		
		//then
		assertThat(mav.getViewName(), is("showComponents"));
        assertThat((Map<String, Object>)mav.getModel(), is(expectedModel));
	}
}
