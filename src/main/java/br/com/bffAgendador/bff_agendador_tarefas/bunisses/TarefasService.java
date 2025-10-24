package br.com.bffAgendador.bff_agendador_tarefas.bunisses;

import br.com.bffAgendador.bff_agendador_tarefas.bunisses.dto.in.TarefaDtoRequest;
import br.com.bffAgendador.bff_agendador_tarefas.bunisses.dto.out.TarefaDtoResponse;
import br.com.bffAgendador.bff_agendador_tarefas.infraestructure.client.TarefasClient;
import br.com.bffAgendador.bff_agendador_tarefas.infraestructure.enuns.StatusNotificacao;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TarefasService {

    private final TarefasClient client;

    public TarefasService(TarefasClient client){
        this.client = client;
    }

    public TarefaDtoResponse gravarTarefa(String token, TarefaDtoRequest tarefaDto){
        return client.gravarTarefa(tarefaDto, token);
    }
    public List<TarefaDtoResponse> tarefaAgendadasPorPeriodo(LocalDateTime dataInicial, LocalDateTime dataFinal, String token) {
       return client.buscarlistadeTarefaPeriodo(dataInicial, dataFinal, token);
    }

    public List<TarefaDtoResponse> buscaTarefaEmail(String token){
        return client.buscarTarefaEmail(token);
    }

    public void deletaTarefaPorId(String id, String token){
        client.deletaTarefaPorId(id, token);
    }
    public TarefaDtoResponse alteraStatus(StatusNotificacao statusNotificacao, String id, String token){
        return client.alteraStatusNotificacao(statusNotificacao, id, token);

    }
    public TarefaDtoResponse updateTarefas(TarefaDtoRequest dto, String id, String token) {
        return client.updateTarefa(dto, id, token);

    }




}
