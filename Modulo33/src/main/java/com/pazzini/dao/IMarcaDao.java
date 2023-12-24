// Declaração do pacote ao qual a interface pertence
package com.pazzini.dao;

// Importação da classe Marca do pacote com.pazzini.domain
import com.pazzini.domain.Marca;

// Declaração da interface IMarcaDao
public interface IMarcaDao {

    // Assinatura do método cadastrar que recebe um objeto Marca e retorna um objeto Marca
    public Marca cadastrar(Marca marca);
}
