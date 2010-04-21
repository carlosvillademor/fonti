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

import com.carlos.projects.billing.dao.ComponentDAO;
import com.carlos.projects.billing.dao.FamilyDAO;
import com.carlos.projects.billing.domain.Component;
import com.carlos.projects.billing.domain.Family;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashSet;
import java.util.Set;

/**
 * Unit tests for {@link ExcelToMySQLImporter}
 *
 * @author Carlos Fernandez
 * @date 6 Oct 2009
 */
public class ExcelToMySQLImporterTest {

    @Mock
    private FamilyDAO familyDAO;

    @Mock
    private ComponentDAO componentDAO;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldImportZeroComponentsFromEmptyFile() throws Exception {
        //given
        ExcelToMySQLImporter importer = new ExcelToMySQLImporter(familyDAO, componentDAO);
        MultipartFile file = new MockMultipartFile("emptyData.xlsx", getClass().getResourceAsStream("/emptyData.xlsx"));

        //when
        Long importedComponents = importer.importData(file);

        //then
        assertThat("The number of components imported is not 0", importedComponents, is(0L));
        verifyZeroInteractions(familyDAO);
        verifyZeroInteractions(componentDAO);
    }

    @Test
    public void shouldImportNComponentsAndNFamiliesFromFileWithNComponentsAndNFamiliesAllOfThemWithFamilyCodeValue() throws Exception {
        //given
        ExcelToMySQLImporter importer = new ExcelToMySQLImporter(familyDAO, componentDAO);
        MultipartFile file = new MockMultipartFile("data.xlsx", getClass().getResourceAsStream("/data.xlsx"));

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

        Family family1 = new Family();
        family1.setCode("36");
        family1.setDescription("CONTADORES");
        Set<Component> components1 = new HashSet<Component>();
        components1.add(component1);
        family1.setComponents(components1);

        Family family2 = new Family();
        family2.setCode("33");
        family2.setDescription("ACCES. FONTANERIA");
        Set<Component> components2 = new HashSet<Component>();
        components2.add(component2);
        family2.setComponents(components2);

        //when
        Long importedComponents = importer.importData(file);

        //then
        assertThat("The number of components imported is not 2", importedComponents, is(2L));
        verify(componentDAO, times(1)).save(component1);
        verify(componentDAO, times(1)).save(component2);
        verify(componentDAO, atMost(2)).save((Component) anyObject());
        verify(familyDAO, times(1)).save(family1);
        verify(familyDAO, times(1)).save(family2);
        verify(familyDAO, atMost(2)).save((Family) anyObject());
    }

    @Test
    public void shouldImportNComponentsAndNFamiliesFromFileWithNComponentsAndNFamiliesWithFamilyCodeValueAndSomeOtherComponentsAndFamiliesWithNoFamilyCodeValue()
            throws Exception {
        //given
        ExcelToMySQLImporter importer = new ExcelToMySQLImporter(familyDAO, componentDAO);
        MultipartFile file = new MockMultipartFile("dataWithMissingFamilyCodes.xlsx",
                getClass().getResourceAsStream("/dataWithMissingFamilyCodes.xlsx"));

        Component component1 = new Component();
        component1.setCode("KITAZUL162212");
        component1.setDescription("KIT AZUL BATERIA 16-2-21/2 BAHISA");
        component1.setDiscount1(33.00);
        component1.setDiscount2(0.00);
        component1.setPrice(383.2065);

        Family family1 = new Family();
        family1.setCode("36");
        family1.setDescription("CONTADORES");
        Set<Component> components1 = new HashSet<Component>();
        components1.add(component1);
        family1.setComponents(components1);

        //when
        Long importedComponents = importer.importData(file);

        //then
        assertThat("The number of components imported is not 1", importedComponents, is(1L));
        verify(componentDAO, times(1)).save(component1);
        verify(componentDAO, atMost(1)).save((Component) anyObject());
        verify(familyDAO, times(1)).save(family1);
        verify(familyDAO, atMost(1)).save((Family) anyObject());
    }

    @Test
    public void shouldNotImportComponentsWithTheSameCodeTwice()
            throws Exception {
        //given
        ExcelToMySQLImporter importer = new ExcelToMySQLImporter(familyDAO, componentDAO);
        MultipartFile file = new MockMultipartFile("dataWithDuplicatedComponentCodes.xlsx",
                getClass().getResourceAsStream("/dataWithDuplicatedComponentCodes.xlsx"));

        Component component1 = new Component();
        component1.setCode("KITAZUL162212");
        component1.setDescription("KIT AZUL BATERIA 16-2-21/2 BAHISA");
        component1.setDiscount1(33.00);
        component1.setDiscount2(0.00);
        component1.setPrice(383.2065);

        Family family1 = new Family();
        family1.setCode("36");
        family1.setDescription("CONTADORES");
        Set<Component> components1 = new HashSet<Component>();
        components1.add(component1);
        family1.setComponents(components1);

        Family family2 = new Family();
        family2.setCode("33");
        family2.setDescription("ACCES. FONTANERIA");
        family2.setComponents(new HashSet<Component>());

        when(componentDAO.getById((Class<Component>) anyObject(), anyString())).thenReturn(null, component1);

        //when
        Long importedComponents = importer.importData(file);

        //then
        assertThat("The number of components imported is not 1", importedComponents, is(1L));
        verify(componentDAO, times(1)).save(component1);
        verify(componentDAO, atMost(1)).save((Component) anyObject());
        verify(familyDAO, times(1)).save(family1);
        verify(familyDAO, times(1)).save(family2);
        verify(familyDAO, atMost(2)).save((Family) anyObject());
    }

    @Test
    public void shouldNotImportFamiliesWithTheSameCodeTwice()
            throws Exception {
        //given
        ExcelToMySQLImporter importer = new ExcelToMySQLImporter(familyDAO, componentDAO);
        MultipartFile file = new MockMultipartFile("dataWithDuplicatedFamilyCodes.xlsx",
                getClass().getResourceAsStream("/dataWithDuplicatedFamilyCodes.xlsx"));

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

        Family family1 = new Family();
        family1.setCode("36");
        family1.setDescription("CONTADORES");
        Set<Component> components1 = new HashSet<Component>();
        components1.add(component1);
        family1.setComponents(components1);

        when(familyDAO.getById(Family.class, family1.getCode())).thenReturn(null, family1);

        //when
        Long importedComponents = importer.importData(file);

        //then
        assertThat("The number of components imported is not 2", importedComponents, is(2L));
        verify(componentDAO, times(1)).save(component1);
        verify(componentDAO, times(1)).save(component2);
        verify(componentDAO, atMost(2)).save((Component) anyObject());
        verify(familyDAO, times(1)).save(family1);
        verify(familyDAO, atMost(1)).save((Family) anyObject());
    }

}