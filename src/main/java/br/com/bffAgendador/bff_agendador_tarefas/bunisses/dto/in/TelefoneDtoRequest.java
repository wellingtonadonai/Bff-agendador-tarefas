package br.com.bffAgendador.bff_agendador_tarefas.bunisses.dto.in;

import lombok.Builder;

import java.util.Objects;


@Builder
public class TelefoneDtoRequest {

    private String numero;
    private String ddd;

    public TelefoneDtoRequest(){}

    public TelefoneDtoRequest(Long id, String numero, String ddd) {

        this.numero = numero;
        this.ddd = ddd;
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
        if (!(o instanceof TelefoneDtoRequest that)) return false;
        return Objects.equals(getNumero(), that.getNumero()) && Objects.equals(getDdd(), that.getDdd());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumero(), getDdd());
    }
}
