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
 * Unit tests for {@link User}}}
 */
public class UserTest {
	private User user;
	
	@Before
	public void setup () {
		user = new User();
	}
	
	@Test
	public void userConstructorShouldReturnNonNullUser() {
		assertNotNull("User constructor has returned null", user);
	}
	
}
