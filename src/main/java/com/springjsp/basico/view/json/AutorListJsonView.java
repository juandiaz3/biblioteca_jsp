package com.springjsp.basico.view.json;

import java.util.Map;

import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

public class AutorListJsonView extends MappingJackson2JsonView {

	@Override
	protected Object filterModel(Map<String, Object> model) {
		
		
		return super.filterModel(model);
	}

}
