package com.springjsp.basico.utilities.uploadfiles;

import org.springframework.web.multipart.MultipartFile;

public interface IUploadFilesService {
	
	// Crear fichero
	public String createFile(MultipartFile fileName);
	
	// Borrar fichero
	public boolean deleteFile(String fileName);

}
