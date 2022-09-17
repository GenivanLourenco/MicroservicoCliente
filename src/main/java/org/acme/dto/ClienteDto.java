package org.acme.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ClienteDto {
    private Long id;

        @NotBlank(message = "Nome é obrigatório")
        private String nome;

        @NotNull(message = "Idade é obrigatório")
        private String idade;

        @NotNull(message = "Digite o endereço")
        private String endereco;

        @NotNull(message = "Digite o telefone")
        private String telefone;

        @NotNull(message = "Digite o email")
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
