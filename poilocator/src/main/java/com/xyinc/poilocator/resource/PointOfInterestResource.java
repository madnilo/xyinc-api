package com.xyinc.poilocator.resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xyinc.poilocator.model.PointOfInterest;

@RestController
@RequestMapping("/points-of-interest")
public class PointOfInterestResource {
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST, path="/new")
	public String addNew(PointOfInterest poi){
		return "Servidor Funcionando";
	}
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET)
	public String listAll(){
		return "Servidor Funcionando";
	}
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET, path="/nearby")
	public String listNearby(){
		return "ok";
	} 

}
