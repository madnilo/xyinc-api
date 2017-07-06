package com.xyinc.poilocator.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class PointOfInterest implements Serializable{
	
	private static final long serialVersionUID = 1L;

	
	@Id @GeneratedValue
	private long id;
	private String nome;
	private Integer coordenadaX;
	private Integer coordenadaY;

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Integer getCoordenadaX() {
		return coordenadaX;
	}
	
	public void setCoordenadaX(Integer coordenadaX) {
		this.coordenadaX = coordenadaX < 0 ? (coordenadaX*(-1)) : coordenadaX;
	}
	
	public Integer getCoordenadaY() {
		return coordenadaY;
	}
	
	public void setCoordenadaY(Integer coordenadaY) {
		this.coordenadaY = coordenadaY < 0 ? (coordenadaY*(-1)) : coordenadaY;
	}
}
