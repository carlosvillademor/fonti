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
 * Unit tests for {@link Client}}
 */
public class CompanyTest {
	private Company company;
	
	@Before
	public void setup () {
		company = new Company();
	}
	
	@Test
	public void companyConstructorShouldReturnANonNullCompany() {
		assertNotNull("Company constructor has returned null", company);
	}
}
