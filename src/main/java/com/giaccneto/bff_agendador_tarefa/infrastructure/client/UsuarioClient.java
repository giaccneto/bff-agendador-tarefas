package com.giaccneto.bff_agendador_tarefa.infrastructure.client;


import com.giaccneto.bff_agendador_tarefa.business.dto.EnderecoDTO;
import com.giaccneto.bff_agendador_tarefa.business.dto.TelefoneDTO;
import com.giaccneto.bff_agendador_tarefa.business.dto.UsuarioDTO;
import com.giaccneto.bff_agendador_tarefa.business.dto.in.EnderecoDTORequest;
import com.giaccneto.bff_agendador_tarefa.business.dto.in.LoginRequestDTO;
import com.giaccneto.bff_agendador_tarefa.business.dto.in.TelefoneDTORequest;
import com.giaccneto.bff_agendador_tarefa.business.dto.in.UsuarioDTORequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "usuario", url = "${usuario.url}")
public interface UsuarioClient {

    @GetMapping
    UsuarioDTO buscaUsuarioPorEmail(@RequestParam("email") String email,
                                    @RequestHeader("Autorization") String token);

    @PostMapping
    UsuarioDTO salvaUsuario(@RequestBody UsuarioDTORequest usuarioDTO);


    @PostMapping("/login")
    String login(@RequestBody LoginRequestDTO usuarioDTO);


    @DeleteMapping("/{email}")
    Void deletaUsuarioPorEmail(@PathVariable String email, @RequestHeader("Authorization") String token);


    @PutMapping
    UsuarioDTO atualizaUsuario(@RequestParam UsuarioDTORequest dto, @RequestHeader("Authorization") String token);

    @PutMapping("/endereco")
    EnderecoDTO atualizaEndereco(@RequestBody EnderecoDTORequest dto, @RequestParam("id") Long id, @RequestHeader("Authorization") String token);

    @PutMapping("/telefone")
    TelefoneDTO atualizaTelefone(@RequestBody TelefoneDTORequest dto, @RequestParam("id") Long id, @RequestHeader("Authorization") String token);

    @PostMapping("/endereco")
    EnderecoDTO cadastraEndereco(@RequestBody EnderecoDTORequest dto, @RequestHeader("Authorization") String token);

    @PostMapping("/telefone")
    TelefoneDTO cadastraTelefone(@RequestBody TelefoneDTORequest dto, @RequestHeader("Authorization") String token);
}
