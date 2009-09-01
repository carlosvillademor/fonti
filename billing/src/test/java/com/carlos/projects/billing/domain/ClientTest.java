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
 * Unit tests for {@link }
 */
public class ClientTest {

	private Client client;
	
	@Before
	public void startup() {
		client = new Client();
	}
	
	@Test
	public void clientConstructorShouldCreateANonNullClient() {
		assertNotNull("Client constructor has returned null", client);
	}

}
