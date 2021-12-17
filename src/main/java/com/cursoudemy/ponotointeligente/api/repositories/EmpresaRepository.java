package com.cursoudemy.ponotointeligente.api.repositories;


import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cursoudemy.ponotointeligente.api.entities.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
	
	@Transactional(readOnly = true)
	Empresa findByCnpj(String cnpj);

}
