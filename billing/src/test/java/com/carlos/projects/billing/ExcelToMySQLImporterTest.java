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
package com.carlos.projects.billing;

import com.carlos.projects.billing.domain.Family;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * @author Carlos Fernandez
 * 
 * @date 6 Oct 2009
 * 
 * Unit tests for {@link ExcelToMySQLImporter}
 */
public class ExcelToMySQLImporterTest {
	
	@Test
	public void shouldImportCorrectNumberOfComponentsFromFile() throws URISyntaxException, IOException {
		//given
		ExcelToMySQLImporter importer = new ExcelToMySQLImporter();
		MultipartFile file = new MockMultipartFile("data.xls", getClass().getResourceAsStream("/data.xls"));

		//when
		long importedComponents = importer.importData(file);

        //then
        assertThat(importedComponents, is(1L));
    }

    @Test
    public void shouldStoreFamilyInDatabase() throws URISyntaxException, IOException {
        //given
        ExcelToMySQLImporter importer = new ExcelToMySQLImporter();
        MultipartFile file = new MockMultipartFile("data.xls", getClass().getResourceAsStream("/data.xls"));
        Family family = new Family();
        family.setCode("36");
        family.setDescription("CONTADORES");

        //when
        long importedComponents = importer.importData(file);

        //then
    }

}