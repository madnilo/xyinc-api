package com.xyinc.poilocator.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pois")
public class POIResource {
	
	@RequestMapping(method = RequestMethod.GET)
	public String listAll(){
		return "Servidor Funcionando";
	}

}
