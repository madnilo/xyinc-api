package com.xyinc.poilocator.resource;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.xyinc.poilocator.helper.MathHelper;
import com.xyinc.poilocator.model.PointOfInterest;
import com.xyinc.poilocator.repository.PointOfInterestRepository;

@RestController
@RequestMapping("/points-of-interest")
public class PointOfInterestResource {
	
	@Autowired
	PointOfInterestRepository repository;
	
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST, path="/new")
	public ResponseEntity<PointOfInterest> addNew(@RequestBody PointOfInterest poi){
		
		poi = repository.save(poi);
		
		URI uri = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.replacePath("/points-of-interest")
					.path("/{id}")
					.buildAndExpand(poi.getId())
					.toUri();
		
		return ResponseEntity.created(uri).body(poi);
	}
	
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PointOfInterest>> listAll(){
		
		List<PointOfInterest> results = repository.findAll();
		
		return ResponseEntity.ok().body(results);
	}
	
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET, path="/nearby/{x}/{y}/{d-max}")
	public ResponseEntity<List<PointOfInterest>> listNearby(	
								@PathVariable("x") int x,
								@PathVariable("y") int y,
								@PathVariable("d-max") int maxDistance){
		
		List<PointOfInterest> points = repository.findAll();
		List<PointOfInterest> result = new ArrayList<>();
		
		PointOfInterest a = new PointOfInterest(x, y);

		for(PointOfInterest b : points){
			if(MathHelper.distanceBetweenTwoPoints(a, b) <= maxDistance) result.add(b);
		}
		
		return ResponseEntity.ok().body(result);
	} 
	
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST, path="/populate-db")
	public ResponseEntity<Void> populateDB(@RequestBody List<PointOfInterest> points){
		
		for(PointOfInterest poi : points){
			repository.save(poi);
		}
		return ResponseEntity.ok().build();
	}

	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	public ResponseEntity<PointOfInterest> searchById(@PathVariable("id") long id){
		
		PointOfInterest result = repository.findOne(id);
		
		return ResponseEntity.ok().body(result);
	}
}



