package br.com.bffAgendador.bff_agendador_tarefas.bunisses.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TelefoneDto {

    private Long id;
    private String numero;
    private String ddd;
}
