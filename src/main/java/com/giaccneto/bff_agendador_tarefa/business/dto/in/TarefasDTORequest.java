package com.giaccneto.bff_agendador_tarefa.business.dto.in;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.giaccneto.bff_agendador_tarefa.business.enums.StatusNotificacaoEnum;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TarefasDTORequest {


    private String nomaTarefa;
    private String descricao;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dataEvento;
    private String emailUsuari;
}
