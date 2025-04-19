package com.giaccneto.bff_agendador_tarefa.business;

import com.giaccneto.bff_agendador_tarefa.business.dto.EnderecoDTO;
import com.giaccneto.bff_agendador_tarefa.business.dto.TelefoneDTO;
import com.giaccneto.bff_agendador_tarefa.business.dto.UsuarioDTO;
import com.giaccneto.bff_agendador_tarefa.business.dto.in.EnderecoDTORequest;
import com.giaccneto.bff_agendador_tarefa.business.dto.in.LoginRequestDTO;
import com.giaccneto.bff_agendador_tarefa.business.dto.in.TelefoneDTORequest;
import com.giaccneto.bff_agendador_tarefa.business.dto.in.UsuarioDTORequest;
import com.giaccneto.bff_agendador_tarefa.infrastructure.client.UsuarioClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioClient client;

    public UsuarioDTO salvaUsuario(UsuarioDTORequest usuarioDTO) {

        return client.salvaUsuario(usuarioDTO);
    }
    public String loginUsuario(LoginRequestDTO usuarioDTO){
        return client.login(usuarioDTO);
    }


    public UsuarioDTO buscarUsuarioPorEmail(String email, String token) {
        return client.buscaUsuarioPorEmail(email, token);
    }

    public void deletaUsuarioPorEmail(String email, String token){

        client.deletaUsuarioPorEmail(email, token);
    }

    public UsuarioDTO atualizaDadosUsuario(String token, UsuarioDTORequest dto){

        return client.atualizaUsuario(dto, token);
    }




    public EnderecoDTO atualizaEndereco(Long idEndereco, EnderecoDTORequest enderecoDTO, String token){
        return client.atualizaEndereco( enderecoDTO, idEndereco, token );

    }




    public TelefoneDTO atualizaTelefone(Long idTelefone, TelefoneDTORequest dto, String token){
       return client.atualizaTelefone(dto, idTelefone, token);

    }




    public EnderecoDTO cadastraEndereco(String token, EnderecoDTORequest dto){
        return client.cadastraEndereco(dto, token);
    }




    public TelefoneDTO cadastraTelefone(String token, TelefoneDTORequest dto){
       return client.cadastraTelefone(dto, token);

    }
}
