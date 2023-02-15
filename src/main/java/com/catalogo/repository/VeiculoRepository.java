package com.catalogo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.catalogo.model.Veiculo;


@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long>{
	public List <Veiculo> findAllByMarcaContainingIgnoreCase(@Param("marca") String marca);
}

