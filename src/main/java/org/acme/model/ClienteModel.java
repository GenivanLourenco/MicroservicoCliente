package org.acme.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
@NamedNativeQueries({
        @NamedNativeQuery(name = "INSERT_CLIENTE", query = "INSERT INTO cliente (nome, idade, endereco, telefone, email) VALUES (:nome, :idade, :endereco, :telefone, :email)"),
        @NamedNativeQuery(name = "CONSULTAR_TODOS_CLIENTES", query = "SELECT * FROM cliente", resultClass = ClienteModel.class),
        @NamedNativeQuery(name = "CONSULTAR_CLIENTE_POR_ID", query = "SELECT * FROM cliente WHERE id = :id", resultClass = ClienteModel.class),
        @NamedNativeQuery(name = "ATUALIZAR_CLIENTE", query = "UPDATE cliente SET nome = :nome, idade = :idade, endereco = :endereco, telefone = :telefone, email = :email WHERE id = :id"),
        @NamedNativeQuery(name = "DELETAR_CLIENTE", query = "DELETE FROM cliente WHERE id = :id")
})

public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String nome;

        private String idade;

        private String endereco;

        private String telefone;

        private String email;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getIdade() {
            return idade;
        }

        public void setIdade(String idade) {
            this.idade = idade;
        }

        public String getEndereco() {
            return endereco;
        }

        public void setEndereco(String endereco) {
            this.endereco = endereco;
        }

        public String getTelefone() {
            return telefone;
        }

        public void setTelefone(String telefone) {
            this.telefone = telefone;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

}
