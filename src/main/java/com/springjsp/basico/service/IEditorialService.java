package com.springjsp.basico.service;

import java.util.List;

import com.springjsp.basico.entity.Editorial;

public interface IEditorialService {
	
	public List<Editorial> findAll();
	
	public Editorial findById(int idEditorial);

}
