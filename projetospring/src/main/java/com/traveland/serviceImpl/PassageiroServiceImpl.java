package com.traveland.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.traveland.model.Passageiro;
import com.traveland.repository.PassageiroRepository;
import com.traveland.service.PassageiroService;

@Service
public class PassageiroServiceImpl implements PassageiroService {

	@Autowired
	private PassageiroRepository sr;
	
	@Override
	public List<Passageiro> getAllPassageiros() {

		return sr.findAll();
	}
	

	@Override
	public Passageiro getPassageiroById(Long id) {

		return sr.findById(id).orElseThrow(() -> new RuntimeException("ID: " + id + "Not Found"));
	}

	@Override
	public Passageiro savePassageiro(Passageiro passageiro) {

		return sr.save(passageiro);
	}

	@Override
	public Passageiro updatePassageiro(Long id, Passageiro passageiroUpdated) {
		Passageiro passageiroExists = sr.findById(id).orElseThrow(() -> new RuntimeException("ID: " + id + "Not Found"));
		passageiroExists.setName(passageiroUpdated.getName());
		passageiroExists.setEmail(passageiroUpdated.getEmail());
		passageiroExists.setEndereco(passageiroUpdated.getEndereco());
		passageiroExists.setTelefone(passageiroUpdated.getTelefone());
		
		

		return sr.save(passageiroExists);
	}

	@Override
	public void deleteById(Long id) {
		sr.deleteById(id);

	}

}
