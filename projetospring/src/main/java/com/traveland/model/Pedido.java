package com.traveland.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="pedido_name", length = 50, nullable = false )
	private String name;
	
	private double valor;
	
	private LocalDate ida;
	
	private LocalDate volta;
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="pedido_passageiro",
	joinColumns=@JoinColumn(name="pedido_id"),
	inverseJoinColumns=@JoinColumn(name="passageiro_id"))
	private Set<Passageiro> passageiro = new HashSet<>();


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
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


	public Set<Passageiro> getPassageiro() {
		return passageiro;
	}


	public void setPassageiro(Set<Passageiro> passageiro) {
		this.passageiro = passageiro;
	}


	


	

	
	

}
