// Declaração do pacote ao qual a interface pertence
package com.pazzini.dao;

// Importação da classe Carro do pacote com.pazzini.domain
import com.pazzini.domain.Carro;

// Declaração da interface ICarroDao
public interface ICarroDao {

    // Assinatura do método cadastrar que recebe um objeto Carro e retorna um objeto Carro
    public Carro cadastrar(Carro carro);

    // Assinatura do método buscarPorChassi que recebe um número de chassi e retorna um objeto Carro
    Carro buscarPorChassi(String chassi);
}
