package com.giaccneto.bff_agendador_tarefa.infrastructure.client;


import com.giaccneto.bff_agendador_tarefa.business.dto.EnderecoDTO;
import com.giaccneto.bff_agendador_tarefa.business.dto.TelefoneDTO;
import com.giaccneto.bff_agendador_tarefa.business.dto.UsuarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "usuario", url = "${usuario.url}")
public interface UsuarioClient {

    @GetMapping
    UsuarioDTO buscaUsuarioPorEmail(@RequestParam("email") String email,
                                    @RequestHeader("Autorization") String token);

    @PostMapping
    UsuarioDTO salvaUsuario(@RequestBody UsuarioDTO usuarioDTO);


    @PostMapping("/login")
    String login(@RequestBody UsuarioDTO usuarioDTO);


    @DeleteMapping("/{email}")
    Void deletaUsuarioPorEmail(@PathVariable String email, @RequestHeader("Authorization") String token);


    @PutMapping
    UsuarioDTO atualizaUsuario(@RequestParam UsuarioDTO dto, @RequestHeader("Authorization") String token);

    @PutMapping("/endereco")
    EnderecoDTO atualizaEndereco(@RequestBody EnderecoDTO dto, @RequestParam("id") Long id, @RequestHeader("Authorization") String token);

    @PutMapping("/telefone")
    TelefoneDTO atualizaTelefone(@RequestBody TelefoneDTO dto, @RequestParam("id") Long id, @RequestHeader("Authorization") String token);

    @PostMapping("/endereco")
    EnderecoDTO cadastraEndereco(@RequestBody EnderecoDTO dto, @RequestHeader("Authorization") String token);

    @PostMapping("/telefone")
    TelefoneDTO cadastraTelefone(@RequestBody TelefoneDTO dto, @RequestHeader("Authorization") String token);
}
