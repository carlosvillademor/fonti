package com.carlos.projects.billing.domain;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Carlos Fernandez
 *
 * @date 19 Jul 2009
 *
 * Class to represent a file upload on the application
 */
public class FileUpload {
	
	private MultipartFile file;

	/**
	 * @return the file
	 */
	public MultipartFile getFile() {
		return file;
	}

	/**
	 * @param file the file to set
	 */
	public void setFile(MultipartFile file) {
		this.file = file;
	}

}
