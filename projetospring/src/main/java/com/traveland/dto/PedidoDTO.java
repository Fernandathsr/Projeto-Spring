package com.traveland.dto;

import java.time.LocalDate;

public class PedidoDTO {
	
	private long id;
	
	private String name;
	
	private double valor;
	
	private LocalDate ida;
	
	private LocalDate volta;
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public LocalDate getIda() {
		return ida;
	}

	public void setIda(LocalDate ida) {
		this.ida = ida;
	}

	public LocalDate getVolta() {
		return volta;
	}

	public void setVolta(LocalDate volta) {
		this.volta = volta;
	}
	
	

}
