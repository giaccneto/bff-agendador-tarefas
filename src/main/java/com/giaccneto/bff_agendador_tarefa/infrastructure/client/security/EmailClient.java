package com.giaccneto.bff_agendador_tarefa.infrastructure.client.security;



import com.giaccneto.bff_agendador_tarefa.business.dto.out.TarefasDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "notificacao", url = "${notificacao.url}")
public interface EmailClient {

    Void enviarEmail(@RequestBody TarefasDTOResponse dto);
}
