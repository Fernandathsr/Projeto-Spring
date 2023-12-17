package com.traveland.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.traveland.dto.PedidoPassageiroDTO;
import com.traveland.service.PedidoService;



@RestController
@RequestMapping("/pedidopassageiro")
public class PedidoPassageiroController {
	
	@Autowired
	private PedidoService ps;
	
	
	
	@PostMapping("/addpedidopassageiro")
	public ResponseEntity<String> addRelationship(@RequestBody PedidoPassageiroDTO psDTO){
		ps.addRelationship(psDTO.getPedidoId(), psDTO.getPassageiroId());
		
		
		return new ResponseEntity<>("Relatioship created", HttpStatus.CREATED);
		
		
	}
	
	@GetMapping("/findallres")
	public List<Object>getAllrels(){
		
		return ps.findAllres();
	}

}
