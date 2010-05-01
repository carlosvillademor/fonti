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
package com.carlos.projects.billing.ui.helpers;

import com.carlos.projects.billing.dao.FamilyDAO;
import com.carlos.projects.billing.domain.Family;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Unit test for {@link com.carlos.projects.billing.ui.helpers.BudgetViewHelper}
 *
 * @author Carlos Fernandez
 * @date 29-Apr-2010
 */
public class BudgetViewHelperTest {

    @Mock
    private FamilyDAO familyDAO;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldGetAllTheFamilies() {
        //given
        BudgetViewHelper viewHelper = new BudgetViewHelper();
        viewHelper.setFamilyDAO(familyDAO);
        List<Family> families = new ArrayList<Family>();
        when(familyDAO.findAllOrderByDescription("Family")).thenReturn(families);

        //when
        List<Family> actualFamilies = viewHelper.getAllFamilies();

        //then
        verify(familyDAO).findAllOrderByDescription("Family");
        assertThat(actualFamilies, is(families));
    }

}