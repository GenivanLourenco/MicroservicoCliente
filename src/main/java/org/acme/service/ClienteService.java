package org.acme.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.acme.dao.ClienteDao;
import org.acme.dto.ClienteDto;
import org.acme.model.ClienteModel;
import org.acme.parse.ClienteParse;

@RequestScoped
public class ClienteService {

    @Inject
    ClienteDao dao;

    public List<ClienteDto> listar() {
        return dao.listar().stream().map(ClienteParse.get()::dto).collect(Collectors.toList());
    }

    public ClienteDto consultarPorId(Long id) {
        return ClienteParse.get().dto(dao.consultarPorId(id));
    }

    @Transactional(rollbackOn = Exception.class)
    public void inserir(ClienteDto dto) {
        ClienteModel cliente = ClienteParse.get().entidade(dto);
        dao.inserir(cliente);
    }

    @Transactional(rollbackOn = Exception.class)
    public void atualizar(ClienteDto dto) {
        ClienteModel cliente = ClienteParse.get().entidade(dto);
       
        dao.atualizar(cliente);
        

    }

    @Transactional(rollbackOn = Exception.class)
    public void deletar(Long id) {
        dao.deletar(id);
    }
}
