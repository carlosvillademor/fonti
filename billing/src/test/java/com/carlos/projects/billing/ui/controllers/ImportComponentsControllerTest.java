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

import com.carlos.projects.billing.Importer;
import com.carlos.projects.billing.dao.ComponentDAO;
import com.carlos.projects.billing.domain.Component;
import com.carlos.projects.billing.domain.FileUpload;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Unit tests for {@link ImportComponentsController}}
 *
 * @author Carlos Fernandez
 * @date 6 Oct 2009
 */
public class ImportComponentsControllerTest {

    @Mock private Importer importer;

    @Mock private FileUpload command;

    @Mock private MultipartFile file;

    @Mock private ComponentDAO componentDAO;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldImportDataAndPutNumberOfImportedItemsInTheModelWhenOnSubmit()
            throws Exception {
        //given
        ImportComponentsController controller = new ImportComponentsController(importer, componentDAO);
	    List<Component> components = createComponents();
        Map<String, Object> expectedModel = mockExpectedModel(components);
        when(command.getFile()).thenReturn(file);
        when(importer.importData(file)).thenReturn(2L);
        when(componentDAO.findAll("Component")).thenReturn(components);

        //when
        ModelAndView mav = controller.onSubmit(command);

        //then
        assertThat(mav.getViewName(), is("showComponents"));
        assertThat(mav.getModel(), is(expectedModel));
    }

    private Map<String, Object> mockExpectedModel(List<Component> components) {
	    Map<String, Object> expectedModel = new HashMap<String, Object>();
	    expectedModel.put("numberOfComponentsImported", 2L);
	    expectedModel.put("importedComponents", components);
	    expectedModel.put("file", file);
	    return expectedModel;
    }
    
    private List<Component> createComponents() {
        List<Component> components = new ArrayList<Component>();

        Component component1 = new Component();
        component1.setCode("KITAZUL162212");
        component1.setDescription("KIT AZUL BATERIA 16-2-21/2 BAHISA");
        component1.setDiscount1(33.00);
        component1.setDiscount2(0.00);
        component1.setPrice(383.2065);

        Component component2 = new Component();
        component2.setCode("000636");
        component2.setDescription("LATIGUILLO FLEX.RIVER MH 2 300");
        component2.setDiscount1(40.00);
        component2.setDiscount2(0.00);
        component2.setPrice(38.2740);

        components.add(component1);
        components.add(component2);

        return components;
    }

}