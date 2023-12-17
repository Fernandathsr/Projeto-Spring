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

import com.traveland.dto.PedidoDTO;
import com.traveland.model.Pedido;
import com.traveland.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
	
	@Autowired
	private PedidoService ps;
	
	@PostMapping ("/savepedido")
	
	public Pedido createPedido(@RequestBody PedidoDTO pedidoDTO) {
		
		return ps.savePedido(pedidoDTO);
		
	}
	
	@GetMapping("/allpedidos")
	
	public List<Pedido> getAllPedidos(){
		return ps.getAllPedidos();
	}
	
	@GetMapping("/{id}")
	
	public ResponseEntity<Pedido> getPedidoById(@PathVariable Long id){
		Pedido pedido = ps.getPedidoById(id);
		return ResponseEntity.ok(pedido);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Pedido> updatePedido(@PathVariable Long id, @RequestBody PedidoDTO pedidoDTOUpdated) {
		Pedido pedido = ps.getPedidoById(id);
		
		ps.updatePedido(id, pedidoDTOUpdated);
		
		return ResponseEntity.ok(pedido);
	}
	
	@DeleteMapping("/{id}")
		public void deletePedido(@PathVariable Long id) {
		ps.deleteById(id);
	}
}


