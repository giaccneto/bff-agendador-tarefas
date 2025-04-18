package com.giaccneto.bff_agendador_tarefa.infrastructure.client;


import com.giaccneto.bff_agendador_tarefa.business.dto.out.TarefasDTOResponse;
import com.giaccneto.bff_agendador_tarefa.business.enums.StatusNotificacaoEnum;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@FeignClient(name = "agendador-tarefas", url = "${agendador-tarefas.url}")
public interface TarefasClient {

    @PostMapping
    TarefasDTOResponse gravarTarefas(@RequestBody TarefasDTOResponse dto, @RequestHeader("Autorization") String token);

    @GetMapping("/eventos")
    List<TarefasDTOResponse> buscaListaDeTarefasPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal, @RequestHeader("Autorization") String token);

    @GetMapping
    List<TarefasDTOResponse> buscaTarefasPorEmail(@RequestHeader("Autorization") String token);

    @DeleteMapping
    Void deletaTarefaPorId(@RequestParam("id") String id, @RequestHeader("Autorization") String token);

    @PatchMapping
    TarefasDTOResponse alteraStatusNotificacao(@RequestParam("status") StatusNotificacaoEnum status, @RequestParam("id") String id, @RequestHeader("Autorization") String token);

    @PutMapping
    TarefasDTOResponse updateTarefas(@RequestBody TarefasDTOResponse dto, @RequestParam("id") String id, @RequestHeader("Autorization") String token);
}
