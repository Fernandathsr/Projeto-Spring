package com.traveland.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.traveland.model.Passageiro;
import com.traveland.service.PassageiroService;

@RestController
@RequestMapping("/passageiro")
public class PassageiroController {
	
	@Autowired 
	private PassageiroService ss;
	
	@PostMapping("/savepassageiro")
	public Passageiro createPassageiro(@RequestBody Passageiro passageiro) { 
	return ss.savePassageiro(passageiro);
	
}
	@GetMapping("/allpassageiros")
	public List<Passageiro> getAllPassageiros(){
		return ss.getAllPassageiros();
	}
	@GetMapping("/{id}")
	public ResponseEntity<Passageiro> getPassageiroById(@PathVariable Long id) {
		Passageiro passageiro = ss.getPassageiroById(id);

		return ResponseEntity.ok(passageiro);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Passageiro> updatePassgeiro(@PathVariable Long id, @RequestBody Passageiro passageiroUpdated) {
		Passageiro passageiro = ss.getPassageiroById(id);

		passageiro.setName(passageiroUpdated.getName());
		passageiro.setEmail(passageiroUpdated.getEmail());
		passageiro.setEndereco(passageiroUpdated.getEndereco());
		passageiro.setTelefone(passageiroUpdated.getTelefone());
		

		ss.savePassageiro(passageiro);

		return ResponseEntity.ok(passageiro);
	}

	@DeleteMapping("/{id}")
	public void deletepassageiro(@PathVariable Long id) {
		ss.deleteById(id);
	}
}