package br.com.bffAgendador.bff_agendador_tarefas.bunisses.dto.in;

import lombok.Builder;

import java.util.List;
import java.util.Objects;


@Builder
public class UsuarioDtoRequest {

    private String nome;
    private String email;
    private String senha;

    private List<EnderecoDtoRequest> enderecos;
    private List<TelefoneDtoRequest> telefone;

    public UsuarioDtoRequest(){}

    public UsuarioDtoRequest(String nome, String email, String senha, List<EnderecoDtoRequest> enderecos, List<TelefoneDtoRequest> telefone) {
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

    public List<EnderecoDtoRequest> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<EnderecoDtoRequest> enderecos) {
        this.enderecos = enderecos;
    }

    public List<TelefoneDtoRequest> getTelefone() {
        return telefone;
    }

    public void setTelefone(List<TelefoneDtoRequest> telefone) {
        this.telefone = telefone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UsuarioDtoRequest that)) return false;
        return Objects.equals(getNome(), that.getNome()) && Objects.equals(getEmail(), that.getEmail()) && Objects.equals(getSenha(), that.getSenha()) && Objects.equals(getEnderecos(), that.getEnderecos()) && Objects.equals(getTelefone(), that.getTelefone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getEmail(), getSenha(), getEnderecos(), getTelefone());
    }
}
