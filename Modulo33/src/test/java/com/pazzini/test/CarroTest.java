// Declaração do pacote ao qual a classe pertence
package com.pazzini.test;

// Importações de classes relacionadas a testes e assertivas
import org.junit.Assert;
import org.junit.Test;

// Importações de classes do domínio e DAOs
import com.pazzini.dao.AcessorioDao;
import com.pazzini.dao.CarroDao;
import com.pazzini.dao.IAcessorioDao;
import com.pazzini.dao.ICarroDao;
import com.pazzini.dao.IMarcaDao;
import com.pazzini.dao.MarcaDao;
import com.pazzini.domain.Acessorio;
import com.pazzini.domain.Carro;
import com.pazzini.domain.Marca;

// Declaração da classe de teste CarroTest
public class CarroTest {

	// Instâncias dos DAOs utilizados nos testes
	private ICarroDao carroDao;
	private IMarcaDao marcaDao;
	private IAcessorioDao acessorioDao;
	
	// Construtor da classe de teste, inicializa os DAOs
	public CarroTest() {
		carroDao = new CarroDao();
		marcaDao = new MarcaDao();
		acessorioDao = new AcessorioDao();
	}
	
	// Método auxiliar para criar um acessório com dados padrão
	private Acessorio criarAcessorio(String codigo) {
		Acessorio aces = new Acessorio();
		aces.setCodigo(codigo);
		aces.setClassificacao("Item Segurança");
		aces.setDetalhes_tecnicos("Detalhes Técnicos");
		return aces;
	}
	
	// Método auxiliar para criar uma marca com dados padrão
	private Marca criarMarca(String codigo) {
		Marca marca = new Marca();
		marca.setCodigo(codigo);
		marca.setModelo("Polo");
		return marcaDao.cadastrar(marca);
	}
	
	// Método de teste para cadastrar um carro
	@Test
	public void cadastrarCarro() {
		// Criação de acessórios
		Acessorio acess1 = criarAcessorio("FAROL");
		Acessorio acess2 = criarAcessorio("BAGAGEIRO");
		// Criação de uma marca
		Marca marca = criarMarca("VolksWagen");
		// Criação de um carro
		Carro carro = new Carro();
		carro.setAno_fabricacao(2023L);
		carro.setChassi("CHASSI-01");
		carro.setCor("Azul");
		carro.addAcessorio(acess1);
		carro.addAcessorio(acess2);
		carro.setMarca(marca);
		// Cadastro do carro no banco de dados
		carro = carroDao.cadastrar(carro);
		//
		// Assertivas para verificar se o cadastro foi bem-sucedido
		Assert.assertNotNull(carro);
		Assert.assertNotNull(carro.getId());
		// Testando JPQL: buscar por chassi do carro
		Carro carroBD = carroDao.buscarPorChassi(carro.getChassi());
		Assert.assertNotNull(carroBD);
		Assert.assertEquals(carroBD.getId(), carro.getId());
	}
	
}
