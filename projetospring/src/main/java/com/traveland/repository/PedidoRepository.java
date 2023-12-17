package com.traveland.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.traveland.model.Pedido;

import jakarta.transaction.Transactional;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	@Transactional
	@Modifying
	@Query(nativeQuery= true, value= "INSERT INTO pedido_passageiro (pedido_id, passageiro_id) VALUES (:pedidoId, :passageiroId)")
	void addRelationship(@Param("pedidoId") Long pedidoId, @Param("passageiroId") Long passageiroId);
	
	
	
	@Query(nativeQuery= true, 
			value = "SELECT DISTINCT c.pedido_name, s.passageiro_name "
			+ " FROM pedido_passageiro as cs"
			+ " INNER JOIN pedido as c"
			+ " ON c.id = cs.pedido_id"
			+ " INNER JOIN passageiro as s"
			+ " ON s.id = cs.passageiro_id"
			)
	List<Object> findAllRels();

}
