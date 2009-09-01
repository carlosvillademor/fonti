/**
 * @author Carlos Fernandez
 *
 * @date 10/08/2009
 *
 */
package com.carlos.projects.billing.ui.viewHelpers;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for {@link ShowComponentsViewHelper}
 */
public class ShowComponentsViewHelperTest {

	private ShowComponentsViewHelper vh;
	
	@Before
	public void setup() {
		vh = new ShowComponentsViewHelper();
	}
	
	@Test
	public void getComponentsShouldReturnAllComponents() {
		Set components = vh.getComponents();
	}
}
