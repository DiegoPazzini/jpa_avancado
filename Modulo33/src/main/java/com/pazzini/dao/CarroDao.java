// Declaração do pacote ao qual a classe pertence
package com.pazzini.dao;

// Importação das classes relacionadas à persistência e ao domínio
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.pazzini.domain.Carro;

// Declaração da classe CarroDao que implementa a interface ICarroDao
public class CarroDao implements ICarroDao {

    // Implementação do método cadastrar da interface ICarroDao
    @Override
    public Carro cadastrar(Carro carro) {
        // Criação da fábrica de EntityManagers com base na unidade de persistência "ExemploJPA"
        EntityManagerFactory entityManagerFactory = 
                Persistence.createEntityManagerFactory("ExemploJPA");

        // Criação de um EntityManager a partir da fábrica
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        // Início de uma transação no EntityManager
        entityManager.getTransaction().begin();

        // Persistência do objeto carro no banco de dados
        entityManager.persist(carro);

        // Commit da transação
        entityManager.getTransaction().commit();
        
        // Fechamento do EntityManager
        entityManager.close();

        // Fechamento da fábrica de EntityManagers
        entityManagerFactory.close();

        // Retorno do objeto carro após a persistência no banco de dados
        return carro;
    }
    
    // Implementação do método buscarPorChassi da interface ICarroDao
    @Override
    public Carro buscarPorChassi(String chassi) {
        // Criação da fábrica de EntityManagers com base na unidade de persistência "ExemploJPA"
        EntityManagerFactory entityManagerFactory = 
                Persistence.createEntityManagerFactory("ExemploJPA");
        
        // Criação de um EntityManager a partir da fábrica
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        // Construção da consulta JPQL para buscar um carro por chassi
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT c FROM Carro c ");
        sb.append(" WHERE c.chassi = :chassi");
        
        // Início de uma transação no EntityManager
        entityManager.getTransaction().begin();
        
        // Criação de uma consulta tipada para a entidade Carro
        TypedQuery<Carro> query = 
                entityManager.createQuery(sb.toString(), Carro.class);
        
        // Definição do parâmetro "chassi" na consulta
        query.setParameter("chassi", chassi);
        
        // Execução da consulta e obtenção do resultado único
        Carro carro = query.getSingleResult();
        
        // Fechamento do EntityManager
        entityManager.close();
        
        // Fechamento da fábrica de EntityManagers
        entityManagerFactory.close();
        
        // Retorno do objeto Carro encontrado na consulta
        return carro;
    }
}
