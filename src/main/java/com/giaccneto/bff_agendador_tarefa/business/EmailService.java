package com.giaccneto.bff_agendador_tarefa.business;

import com.giaccneto.bff_agendador_tarefa.business.dto.out.TarefasDTOResponse;
import com.giaccneto.bff_agendador_tarefa.infrastructure.client.security.EmailClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final EmailClient emailclient;

    public void enviaEmail(TarefasDTOResponse dto) {

        emailclient.enviarEmail(dto);
    }

}
