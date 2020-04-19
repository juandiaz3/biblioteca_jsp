package com.springjsp.basico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springjsp.basico.entity.Editorial;
import com.springjsp.basico.repository.EditorialRepository;

@Service
public class EditorialServiceImpl implements IEditorialService{
	
	@Autowired
	private EditorialRepository editorialRepository;

	@Override
	public List<Editorial> findAll() {
		
		return editorialRepository.findAll();
	}

	@Override
	public Editorial findById(int idEditorial) {
		
		return editorialRepository.findById(idEditorial).orElse(null);
	}

}
