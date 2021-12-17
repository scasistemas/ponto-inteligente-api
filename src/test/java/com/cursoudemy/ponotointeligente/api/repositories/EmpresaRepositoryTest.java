package com.cursoudemy.ponotointeligente.api.repositories;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.cursoudemy.ponotointeligente.api.entities.Empresa;


@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test") //teste seja utilizado o profile de teste application-test
class EmpresaRepositoryTest {
	@Autowired
	private EmpresaRepository empresaRepository;
	final Logger log = LoggerFactory.getLogger(EmpresaRepositoryTest.class);
	
	private static final String CNPJ = "51463645000100";

	@BeforeEach 
	public void setUp() throws Exception {
		Empresa empresa = new Empresa();
		empresa.setRazaoSocial("Empresa de exemplo");
		empresa.setCnpj(CNPJ);
		this.empresaRepository.save(empresa);
	}
	
	@AfterEach 
    public final void tearDown() { 
		this.empresaRepository.deleteAll();
	}

	@Test
	public void testBuscarPorCnpj() {
		
		Empresa empresa = this.empresaRepository.findByCnpj(CNPJ);
		assertEquals(CNPJ, empresa.getCnpj());
	}
}
