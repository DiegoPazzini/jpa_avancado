// Declaração do pacote ao qual a classe pertence
package com.pazzini.dao;

// Importação das classes relacionadas à persistência e ao domínio
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.pazzini.domain.Marca;

// Declaração da classe MarcaDao que implementa a interface IMarcaDao
public class MarcaDao implements IMarcaDao {

    // Implementação do método cadastrar da interface IMarcaDao
    @Override
    public Marca cadastrar(Marca marca) {
        // Criação da fábrica de EntityManagers com base na unidade de persistência "ExemploJPA"
        EntityManagerFactory entityManagerFactory = 
                Persistence.createEntityManagerFactory("ExemploJPA");

        // Criação de um EntityManager a partir da fábrica
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        // Início de uma transação no EntityManager
        entityManager.getTransaction().begin();

        // Persistência do objeto marca no banco de dados
        entityManager.persist(marca);

        // Commit da transação
        entityManager.getTransaction().commit();
        
        // Fechamento do EntityManager
        entityManager.close();

        // Fechamento da fábrica de EntityManagers
        entityManagerFactory.close();

        // Retorno do objeto marca após a persistência no banco de dados
        return marca;
    }

}
