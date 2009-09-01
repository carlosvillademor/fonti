/**
 * @author Carlos Fernandez
 *
 * @date 3 Aug 2009
 *
 */
package com.carlos.projects.billing.domain;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

/**
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
		assertNotNull(family);
	}
}
