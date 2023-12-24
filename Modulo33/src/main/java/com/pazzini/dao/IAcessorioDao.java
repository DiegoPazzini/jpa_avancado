// Declaração do pacote ao qual a interface pertence
package com.pazzini.dao;

// Importação da classe Acessorio do pacote com.pazzini.domain
import com.pazzini.domain.Acessorio;

// Declaração da interface IAcessorioDao
public interface IAcessorioDao {

    // Assinatura do método cadastrar que recebe um objeto Acessorio e retorna um objeto Acessorio
    public Acessorio cadastrar(Acessorio acessorio);

}
