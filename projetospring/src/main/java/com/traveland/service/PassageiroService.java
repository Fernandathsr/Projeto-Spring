package com.traveland.service;

import java.util.List;

import com.traveland.model.Passageiro;

public interface PassageiroService {

	List<Passageiro> getAllPassageiros();
	
	Passageiro getPassageiroById(Long id);
	
	Passageiro savePassageiro(Passageiro passageiro);
	
	Passageiro updatePassageiro(Long id, Passageiro passageiroUpdated);

	void deleteById(Long id);
	}
