package com.giaccneto.bff_agendador_tarefa.business;


import com.giaccneto.bff_agendador_tarefa.business.dto.in.TarefasDTORequest;
import com.giaccneto.bff_agendador_tarefa.business.dto.out.TarefasDTOResponse;
import com.giaccneto.bff_agendador_tarefa.business.enums.StatusNotificacaoEnum;
import com.giaccneto.bff_agendador_tarefa.infrastructure.client.TarefasClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefasService {

    private final TarefasClient tarefasClient;

    public TarefasDTOResponse gravarTarefa(String token, TarefasDTORequest dto) {

        return tarefasClient.gravarTarefas(dto, token);
    }

    public List<TarefasDTOResponse> buscaTarefasAgendadasPorPeriodo(LocalDateTime dataInicial, LocalDateTime dataFinal, String token) {
        return tarefasClient.buscaListaDeTarefasPorPeriodo(dataInicial, dataFinal, token);
    }

    public List<TarefasDTOResponse> buscaTarefasPorEmail(String token) {

        return tarefasClient.buscaTarefasPorEmail(token);
    }

    public Void deletaTarefaPorId(String id, String token) {
        return tarefasClient.deletaTarefaPorId(id, token);

    }

    public TarefasDTOResponse alteraStatus(StatusNotificacaoEnum status, String id, String token) {
        return tarefasClient.alteraStatusNotificacao(status, id, token);
    }

    public TarefasDTOResponse updateTarefas(TarefasDTOResponse dto, String id, String token) {
        return tarefasClient.updateTarefas(dto, id, token);

    }
}