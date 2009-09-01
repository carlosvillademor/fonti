/**
 * @author Carlos Fernandez
 *
 * @date 25 Jul 2009
 *
 */
package com.carlos.projects.billing.domain;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for {@link Component}}
 */
public class ComponentTest {
	private Component component;

	@Before
	public void setup() {
		component = new Component();
	}
	
	@Test
	public void componentConstructorShouldReturnNonNullComponent() {
		assertNotNull("Component constructor has returned null", component);
	}
}
