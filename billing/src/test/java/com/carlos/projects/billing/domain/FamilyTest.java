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

package com.carlos.projects.billing.domain;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Carlos Fernandez
 *
 * @date 3 Aug 2009
 *
 * Unit tests for {@link Family}}
 */
public class FamilyTest {

	private Family family;
	
	@Before
	public void setup() {
		family = new Family();
	}
	
	@Test
	public void familyConstructorShouldReturnNonNullFamily() {
		assertThat(family, is(notNullValue()));
	}
}