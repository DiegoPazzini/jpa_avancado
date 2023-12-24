// Declaração do pacote ao qual a classe pertence
package com.pazzini.dao;

// Importação das classes relacionadas à persistência e ao domínio
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.pazzini.domain.Acessorio;

// Declaração da classe AcessorioDao que implementa a interface IAcessorioDao
public class AcessorioDao implements IAcessorioDao {

    // Implementação do método cadastrar da interface IAcessorioDao
    @Override
    public Acessorio cadastrar(Acessorio acessorio) {
        // Criação da fábrica de EntityManagers com base na unidade de persistência "ExemploJPA"
        EntityManagerFactory entityManagerFactory = 
                Persistence.createEntityManagerFactory("ExemploJPA");

        // Criação de um EntityManager a partir da fábrica
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        // Início de uma transação no EntityManager
        entityManager.getTransaction().begin();

        // Persistência do objeto acessorio no banco de dados
        entityManager.persist(acessorio);

        // Commit da transação
        entityManager.getTransaction().commit();

        // Fechamento do EntityManager
        entityManager.close();

        // Fechamento da fábrica de EntityManagers
        entityManagerFactory.close();
        
        // Retorno do objeto acessorio após a persistência no banco de dados
        return acessorio;
    }

}
