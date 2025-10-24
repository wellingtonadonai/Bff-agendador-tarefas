package br.com.bffAgendador.bff_agendador_tarefas.controller;


import br.com.bffAgendador.bff_agendador_tarefas.bunisses.TarefasService;
import br.com.bffAgendador.bff_agendador_tarefas.bunisses.dto.in.TarefaDtoRequest;
import br.com.bffAgendador.bff_agendador_tarefas.bunisses.dto.out.TarefaDtoResponse;
import br.com.bffAgendador.bff_agendador_tarefas.infraestructure.enuns.StatusNotificacao;
import br.com.bffAgendador.bff_agendador_tarefas.infraestructure.security.SecurityConfig;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/tarefas")
@Tag(name = "Tarefas", description = "Cadastra tarfas de usuário")
@SecurityRequirement(name = SecurityConfig.SECURITY_SCHEME)
public class TarefasController {

    private final TarefasService tarefasService;

    public TarefasController(TarefasService tarefasService){
        this.tarefasService = tarefasService;
    }

    @PostMapping
    @Operation(summary = "Salvar tarefa de usuarios", description = "Cria uma nova tarefa")
    @ApiResponse(responseCode = "200", description = "Tarefa salva com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro de Servidor")
    public ResponseEntity<TarefaDtoResponse> gravarTarefa(@RequestBody TarefaDtoRequest dto,
                                                          @RequestHeader(name = "Authorization", required = false)String token){
        return ResponseEntity.ok(tarefasService.gravarTarefa(token, dto));
    }

    @GetMapping("/eventos")
    @Operation(summary = "Busca tarefa por periodo", description = "Busca tarefas cadastradas por periodos")
    @ApiResponse(responseCode = "200", description = "Tarefa salva encontradas")
    @ApiResponse(responseCode = "500", description = "Erro de Servidor")
    public ResponseEntity<List<TarefaDtoResponse>> buscarlistadeTarefaPeriodo(

            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)LocalDateTime dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)LocalDateTime dataFinal,
            @RequestHeader(name = "Authorization", required = false)String token


){

        return ResponseEntity.ok(tarefasService.tarefaAgendadasPorPeriodo(dataInicial, dataFinal, token));
    }

    @GetMapping
    @Operation(summary = "Busca  tarefa por email de usuarios", description = "Busca tarefas cadastradas")
    @ApiResponse(responseCode = "200", description = "Tarefa encontrada")
    @ApiResponse(responseCode = "500", description = "Erro de Servidor")
    public ResponseEntity <List<TarefaDtoResponse>> buscarTarefaEmail(@RequestHeader(name = "Authorization", required = false)String token){
        return ResponseEntity.ok(tarefasService.buscaTarefaEmail(token));
    }

    @DeleteMapping
    @Operation(summary = "Deleta tarefa por id", description = "Deleta tarefa por id")
    @ApiResponse(responseCode = "200", description = "Tarefa deletada com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro de Servidor")
    public ResponseEntity<Void> deletaTarefaPorId(@RequestParam("id")String id,
                                                  @RequestHeader(name = "Authorization", required = false)String token


){
        tarefasService.deletaTarefaPorId(id, token);
        return ResponseEntity.ok().build();
    }

    @PatchMapping
    @Operation(summary = "Altera status de tarefas", description = "Altera status das tarfeas cadastradas")
    @ApiResponse(responseCode = "200", description = "Status de Tarefa alterado")
    @ApiResponse(responseCode = "500", description = "Erro de Servidor")
    public ResponseEntity<TarefaDtoResponse> alteraStatusNotificacao(@RequestParam("status") StatusNotificacao status,
                                                                     @RequestParam("id")String id,
                                                                     @RequestHeader(name = "Authorization", required = false)String token


){
        return ResponseEntity.ok(tarefasService.alteraStatus(status, id, token));
    }

    @PutMapping
    @Operation(summary = "Altera dados de tarefas", description = "Altera dados de tarefa")
    @ApiResponse(responseCode = "200", description = "Tarefa alteradas com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro de Servidor")
    public ResponseEntity<TarefaDtoResponse> updateTarefa(@RequestBody TarefaDtoRequest dto, @RequestParam("id")String id,
                                                          @RequestHeader(name = "Authorization", required = false)String token


){
        return ResponseEntity.ok(tarefasService.updateTarefas(dto, id, token));
    }
}
