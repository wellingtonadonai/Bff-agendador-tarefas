package br.com.bffAgendador.bff_agendador_tarefas.bunisses.dto.out;

import lombok.*;

import java.util.List;
import java.util.Objects;


@Builder
public class UsuarioDtoResponse {

    private String nome;
    private String email;
    private String senha;

    private List<EnderecoDtoResponse> enderecos;
    private List<TelefoneDtoResponse> telefone;

    public UsuarioDtoResponse(){}

    public UsuarioDtoResponse(String nome, String email, String senha, List<EnderecoDtoResponse> enderecos, List<TelefoneDtoResponse> telefone) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.enderecos = enderecos;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<EnderecoDtoResponse> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<EnderecoDtoResponse> enderecos) {
        this.enderecos = enderecos;
    }

    public List<TelefoneDtoResponse> getTelefone() {
        return telefone;
    }

    public void setTelefone(List<TelefoneDtoResponse> telefone) {
        this.telefone = telefone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UsuarioDtoResponse that)) return false;
        return Objects.equals(getNome(), that.getNome()) && Objects.equals(getEmail(), that.getEmail()) && Objects.equals(getSenha(), that.getSenha()) && Objects.equals(getEnderecos(), that.getEnderecos()) && Objects.equals(getTelefone(), that.getTelefone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getEmail(), getSenha(), getEnderecos(), getTelefone());
    }
}
