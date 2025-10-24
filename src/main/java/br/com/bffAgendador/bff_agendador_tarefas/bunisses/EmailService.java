package br.com.bffAgendador.bff_agendador_tarefas.bunisses;

import br.com.bffAgendador.bff_agendador_tarefas.bunisses.dto.out.TarefaDtoResponse;
import br.com.bffAgendador.bff_agendador_tarefas.infraestructure.client.EmailClient;
import org.springframework.stereotype.Service;


@Service
public class EmailService {

    private final EmailClient client;

    public EmailService(EmailClient client){
        this.client = client;
    }

    public void enviarEmail (TarefaDtoResponse tarefaDto){
        client.enviarEmail(tarefaDto);
    }





}
