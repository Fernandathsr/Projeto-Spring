package com.traveland.serviceImpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.traveland.dto.PedidoDTO;
import com.traveland.model.Passageiro;
import com.traveland.model.Pedido;
import com.traveland.repository.PassageiroRepository;
import com.traveland.repository.PedidoRepository;
import com.traveland.service.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService {

	@Autowired
	private ModelMapper mp;
	
	@Autowired
	private PedidoRepository pr;
	
	@Autowired
	private PassageiroRepository rp;
	
	@Override 
	
	public List<Pedido> getAllPedidos(){
		return pr.findAll();
	}
	
	@Override 
	public Pedido getPedidoById(Long id) {
		return pr.findById(id).orElseThrow(() -> new RuntimeException("ID: " + id + "Not Found"));
	}
		@Override
		public Pedido savePedido(PedidoDTO pedidoDTO) {
			Pedido pedido = mp.map(pedidoDTO, Pedido.class);
			
			return pr.save(pedido);
			
		}
	
		@Override
		public Pedido updatePedido(Long id, PedidoDTO pedidoDTOUpdated ) {
			Pedido pedidoExists = pr.findById(id).orElseThrow(() -> new RuntimeException("ID: " + id + "Not Found"));
			pedidoExists.setName((pedidoDTOUpdated.getName()));
			pedidoExists.setValor((pedidoDTOUpdated.getValor()));
			pedidoExists.setIda((pedidoDTOUpdated.getIda()));
			pedidoExists.setVolta((pedidoDTOUpdated.getVolta()));
			
			return pr.save(pedidoExists);
		}
		
	
		
		@Override
		public void addRelationship(Long pedidoId, Long passageiroId) {
			Pedido pedido = pr.findById(pedidoId).orElseThrow(() -> new RuntimeException("ID: " + pedidoId + "Not Found"));
			Passageiro passageiro = rp.findById(passageiroId).orElseThrow(() -> new RuntimeException("ID: " + passageiroId + "Not Found"));
			
			if(pedido != null && passageiro != null) {
				pedido.getPassageiro().add(passageiro);
				passageiro.getPedidos().add(pedido);
				
				pr.save(pedido);
				rp.save(passageiro);
			}
	}

		@Override
		public List<Object> findAllres() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public void deleteById(Long id) {
			pr.deleteById(id);
		}
}

