package com.xyinc.poilocator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class PoilocatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(PoilocatorApplication.class, args);
	}
	
	@Controller 
	public class HomeContoller {
	    @RequestMapping("/")
	    public String index() {
	        return "index.html";
	    }
	}
}
