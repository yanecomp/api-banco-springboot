package com.banco.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.banco.api.domain.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long>{
	
	@Query("SELECT c FROM Conta c WHERE c.conta = :cod")
	public Conta findByConta(@Param("cod") Long cod);

}
