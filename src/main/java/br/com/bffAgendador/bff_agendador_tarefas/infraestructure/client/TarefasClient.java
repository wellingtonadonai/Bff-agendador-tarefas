package br.com.bffAgendador.bff_agendador_tarefas.infraestructure.client;

import br.com.bffAgendador.bff_agendador_tarefas.bunisses.dto.in.TarefaDtoRequest;
import br.com.bffAgendador.bff_agendador_tarefas.bunisses.dto.out.TarefaDtoResponse;
import br.com.bffAgendador.bff_agendador_tarefas.infraestructure.enuns.StatusNotificacao;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@FeignClient(name = "agendador-tarefas", url = "${tarefas.url}")
public interface TarefasClient {

    @PostMapping
    TarefaDtoResponse gravarTarefa(@RequestBody TarefaDtoRequest dto,
                                   @RequestHeader("Authorization") String token);

    @GetMapping("/eventos")
    List<TarefaDtoResponse> buscarlistadeTarefaPeriodo(

            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal,
            @RequestHeader("Authorization")String token);

    @GetMapping
    List<TarefaDtoResponse> buscarTarefaEmail(@RequestHeader("Authorization") String token);

    @DeleteMapping
    void deletaTarefaPorId(@RequestParam("id") String id,
                           @RequestHeader("Authorization") String token);

    @PatchMapping
    TarefaDtoResponse alteraStatusNotificacao(@RequestParam("status") StatusNotificacao status,
                                              @RequestParam("id") String id,
                                              @RequestHeader("Authorization") String token);

    @PutMapping
    TarefaDtoResponse updateTarefa(@RequestBody TarefaDtoRequest dto, @RequestParam("id") String id,
                                   @RequestHeader("Authorization") String token);

}
