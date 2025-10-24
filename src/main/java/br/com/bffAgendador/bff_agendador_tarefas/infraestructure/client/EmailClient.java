package br.com.bffAgendador.bff_agendador_tarefas.infraestructure.client;

import br.com.bffAgendador.bff_agendador_tarefas.bunisses.dto.out.TarefaDtoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "notificacao", url = "${notificacao.url}")
public interface EmailClient {

    @PostMapping
    void enviarEmail(@RequestBody TarefaDtoResponse tarefasDto);

}