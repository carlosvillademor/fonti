/**
 * @author Carlos Fernandez
 *
 * @date 3 Aug 2009
 *
 */
package com.carlos.projects.billing.domain;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for {@link Category}
 */
public class CategoryTest {

	private Category category;

	@Before
	public void setup() {
		category = new Category();
	}

	@Test
	public void categoryConstructorShouldCreateNotNullCategory() {
		//assertThat(category, equaltTo(1));
	}

}
