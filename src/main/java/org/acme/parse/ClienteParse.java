package org.acme.parse;

import org.acme.dto.ClienteDto;
import org.acme.model.ClienteModel;

public class ClienteParse {

    public static ClienteParse get() {
        return new ClienteParse();
    }

    public ClienteModel entidade(ClienteDto dto) {
        ClienteModel entidade = new ClienteModel();
        entidade.setId(dto.getId());
        entidade.setNome(dto.getNome());
        entidade.setEmail(dto.getEmail());
        entidade.setTelefone(dto.getTelefone());
        entidade.setEndereco(dto.getEndereco());
        entidade.setIdade(dto.getIdade());

        return entidade;
    }

    public ClienteDto dto(ClienteModel entidade) {
        ClienteDto dto = new ClienteDto();
        dto.setId(entidade.getId());
        dto.setNome(entidade.getNome());
        dto.setEmail(entidade.getEmail());
        dto.setTelefone(entidade.getTelefone());
        dto.setEndereco(entidade.getEndereco());
        dto.setIdade(entidade.getIdade());

        return dto;
    }

}
