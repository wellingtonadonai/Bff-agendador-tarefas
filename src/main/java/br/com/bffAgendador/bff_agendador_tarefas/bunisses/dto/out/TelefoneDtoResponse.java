package br.com.bffAgendador.bff_agendador_tarefas.bunisses.dto.out;

import lombok.*;

import java.util.Objects;


@Builder
public class TelefoneDtoResponse {

    private Long id;
    private String numero;
    private String ddd;

    public TelefoneDtoResponse(){}

    public TelefoneDtoResponse(Long id, String numero, String ddd) {
        this.id = id;
        this.numero = numero;
        this.ddd = ddd;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TelefoneDtoResponse that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getNumero(), that.getNumero()) && Objects.equals(getDdd(), that.getDdd());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNumero(), getDdd());
    }
}
