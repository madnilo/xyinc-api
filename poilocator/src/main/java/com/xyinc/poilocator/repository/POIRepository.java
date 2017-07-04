package com.xyinc.poilocator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xyinc.poilocator.model.POI;

public interface POIRepository extends JpaRepository<POI, Long>{

}
