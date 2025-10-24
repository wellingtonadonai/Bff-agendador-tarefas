package br.com.bffAgendador.bff_agendador_tarefas.bunisses.dto.in;

import lombok.Builder;

import java.util.Objects;


@Builder
public class EnderecoDtoRequest {


    private String rua;
    private Long numero;
    private String complemento;
    private String cidade;
    private String cep;
    private String estado;

    public EnderecoDtoRequest(){}

    public EnderecoDtoRequest( String rua, Long numero, String complemento, String cidade, String cep, String estado) {
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.cidade = cidade;
        this.cep = cep;
        this.estado = estado;
    }



    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EnderecoDtoRequest that)) return false;
        return Objects.equals(getRua(), that.getRua()) && Objects.equals(getNumero(), that.getNumero()) && Objects.equals(getComplemento(), that.getComplemento()) && Objects.equals(getCidade(), that.getCidade()) && Objects.equals(getCep(), that.getCep()) && Objects.equals(getEstado(), that.getEstado());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRua(), getNumero(), getComplemento(), getCidade(), getCep(), getEstado());
    }
}

