package br.com.bffAgendador.bff_agendador_tarefas.bunisses.dto.out;


import br.com.bffAgendador.bff_agendador_tarefas.infraestructure.enuns.StatusNotificacao;
import com.fasterxml.jackson.annotation.JsonFormat;


import java.time.LocalDateTime;
import java.util.Objects;

public class TarefaDtoResponse {

    private String id;
    private String nomeTarefa;
    private String descricao;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dataCriacao;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dataEvento;
    private String emailUsuario;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dataAlteracao;
    private StatusNotificacao statusNotificacaoEnum;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomeTarefa() {
        return nomeTarefa;
    }

    public void setNomeTarefa(String nomeTarefa) {
        this.nomeTarefa = nomeTarefa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDateTime dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public LocalDateTime getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(LocalDateTime dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public StatusNotificacao getStatusNotificacaoEnum() {
        return statusNotificacaoEnum;
    }

    public void setStatusNotificacaoEnum(StatusNotificacao statusNotificacaoEnum) {
        this.statusNotificacaoEnum = statusNotificacaoEnum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TarefaDtoResponse tarefaDto)) return false;
        return Objects.equals(getId(), tarefaDto.getId()) && Objects.equals(getNomeTarefa(), tarefaDto.getNomeTarefa()) && Objects.equals(getDescricao(), tarefaDto.getDescricao()) && Objects.equals(getDataCriacao(), tarefaDto.getDataCriacao()) && Objects.equals(getDataEvento(), tarefaDto.getDataEvento()) && Objects.equals(getEmailUsuario(), tarefaDto.getEmailUsuario()) && Objects.equals(getDataAlteracao(), tarefaDto.getDataAlteracao()) && getStatusNotificacaoEnum() == tarefaDto.getStatusNotificacaoEnum();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNomeTarefa(), getDescricao(), getDataCriacao(), getDataEvento(), getEmailUsuario(), getDataAlteracao(), getStatusNotificacaoEnum());
    }
}
