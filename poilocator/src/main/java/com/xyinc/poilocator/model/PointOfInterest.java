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
	private Integer x;
	private Integer y;

	
	public PointOfInterest(){
		
	}
	
	public PointOfInterest(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Integer getX() {
		return x;
	}
	
	public void setX(Integer x) {
		this.x = x < 0 ? (x*(-1)) : x;
	}
	
	public Integer getY() {
		return y;
	}
	
	public void setY(Integer y) {
		this.y = y < 0 ? (y*(-1)) : y;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
