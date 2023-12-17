package com.traveland.service;

import java.util.List;

import com.traveland.dto.PedidoDTO;
import com.traveland.model.Pedido;

public interface PedidoService {

	List<Pedido> getAllPedidos();
	
	Pedido getPedidoById(Long id);
	
	Pedido savePedido(PedidoDTO pedidoDTO);
	
	Pedido updatePedido(Long id, PedidoDTO pedidoDTOUpdated);

	void deleteById(Long id);
	
	void addRelationship(Long pedidoId, Long passageiroId);
	
	List<Object>findAllres();
}
