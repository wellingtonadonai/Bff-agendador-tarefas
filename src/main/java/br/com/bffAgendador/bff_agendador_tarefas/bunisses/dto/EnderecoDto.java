package br.com.bffAgendador.bff_agendador_tarefas.bunisses.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EnderecoDto {

    private Long id;
    private String rua;
    private Long numero;
    private String complemento;
    private String cidade;
    private String cep;
    private String estado;


}

