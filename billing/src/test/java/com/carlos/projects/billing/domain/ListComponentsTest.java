/**
 * @author Carlos Fernandez
 *
 * @date 4 Aug 2009
 *
 */
package com.carlos.projects.billing.domain;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for {
 */
public class ListComponentsTest {

	private ListComponents listComponents;
	
	@Before
	public void setup() {
		listComponents = new ListComponents();
	}
	
	@Test
	public void listComponentsConstructorShouldReturnNonNullListComponents() {
		assertNotNull(listComponents);
	}
}
