package com.carlos.projects.billing.ui.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.ParameterizableViewController;

/**
 * @author Carlos Fernandez
 *
 * @date 17 Jul 2009
 * 
 * Controller to deal with the updated list of components
 *
 */
public class ShowComponentsController extends ParameterizableViewController {

	public ShowComponentsController() {
		super();
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.ParameterizableViewController#handleRequestInternal(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return super.handleRequestInternal(request, response);
	}

}
