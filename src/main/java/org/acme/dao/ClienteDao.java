package org.acme.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.acme.model.ClienteModel;

@RequestScoped
public class ClienteDao {
    
    @PersistenceContext
     EntityManager em;

     public List<ClienteModel> listar() {
        String nomeConsulta = "CONSULTAR_TODOS_CLIENTES";
            java.util.List<ClienteModel> listaRetorno;
            TypedQuery<ClienteModel> query = em.createNamedQuery(nomeConsulta, ClienteModel.class);
            listaRetorno = query.getResultList();
            return listaRetorno;
    }

    public ClienteModel consultarPorId(Long id) {
        String nomeConsulta = "CONSULTAR_CLIENTE_POR_ID";
        TypedQuery<ClienteModel> query = em.createNamedQuery(nomeConsulta, ClienteModel.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

     @Transactional
        public void inserir(ClienteModel cliente) {
            String nomeSql = "INSERT_CLIENTE";
            em.createNamedQuery(nomeSql)
                    .setParameter("nome", cliente.getNome())
                    .setParameter("idade", cliente.getIdade())
                    .setParameter("endereco", cliente.getEndereco())
                    .setParameter("telefone", cliente.getTelefone())
                    .setParameter("email", cliente.getEmail())
                    .executeUpdate();
        }

        @Transactional
        public void atualizar(ClienteModel cliente) {
            String nomeSql = "ATUALIZAR_CLIENTE";            
            em.createNamedQuery(nomeSql)
                    .setParameter("nome", cliente.getNome())
                    .setParameter("idade", cliente.getIdade())
                    .setParameter("endereco", cliente.getEndereco())
                    .setParameter("telefone", cliente.getTelefone())
                    .setParameter("email", cliente.getEmail())
                    .setParameter("id", cliente.getId())                    
                    .executeUpdate();
        }

        @Transactional
        public void deletar(Long id) {
            String nomeSql = "DELETAR_CLIENTE";
            em.createNamedQuery(nomeSql)
                    .setParameter("id", id)
                    .executeUpdate();
        }
}
