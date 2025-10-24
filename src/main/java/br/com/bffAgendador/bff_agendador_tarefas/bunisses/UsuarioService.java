package br.com.bffAgendador.bff_agendador_tarefas.bunisses;

import br.com.bffAgendador.bff_agendador_tarefas.bunisses.dto.in.EnderecoDtoRequest;
import br.com.bffAgendador.bff_agendador_tarefas.bunisses.dto.in.LoginRequestDto;
import br.com.bffAgendador.bff_agendador_tarefas.bunisses.dto.in.TelefoneDtoRequest;
import br.com.bffAgendador.bff_agendador_tarefas.bunisses.dto.in.UsuarioDtoRequest;
import br.com.bffAgendador.bff_agendador_tarefas.bunisses.dto.out.EnderecoDtoResponse;
import br.com.bffAgendador.bff_agendador_tarefas.bunisses.dto.out.TelefoneDtoResponse;
import br.com.bffAgendador.bff_agendador_tarefas.bunisses.dto.out.UsuarioDtoResponse;
import br.com.bffAgendador.bff_agendador_tarefas.infraestructure.client.UsuarioClient;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService {

    private final UsuarioClient client;

    public UsuarioService(UsuarioClient client){
        this.client = client;
    }

    public UsuarioDtoResponse salvarUsuario(UsuarioDtoRequest usuarioDto){
        return client.salvarUsuario(usuarioDto);
    }

    public String loginUsuario(LoginRequestDto dto){
        return client.login(dto);
    }

    public UsuarioDtoResponse buscaUsuarioPorEmail(String email, String token){

        return client.buscaUsuarioPorEmail(email, token);

    }

    public void deletaUsuarioPorEmail(String email, String token){
        client.deletarUsuarioEmail(email, token);
    }
    public UsuarioDtoResponse atualizaDadosUsuario(String token, UsuarioDtoRequest dto){
        return client.atualizaadosUsuarios(dto, token);

    }
    public EnderecoDtoResponse atualizaEndereco(Long idEndereco, EnderecoDtoRequest dtos, String token){
        return client.atualizarEndereco(dtos, idEndereco, token);

    }

    public TelefoneDtoResponse atualizaTelefone(Long idTelefone, TelefoneDtoRequest telefoneDto, String token){
        return client.atualizarTelefone(telefoneDto, idTelefone, token);
    }
    public EnderecoDtoResponse cadastroEndereco(String token, EnderecoDtoRequest dto){
        return client.cadastrarNovoEndereco(dto, token);

    }
    public TelefoneDtoResponse cadastroTelefone(String token, TelefoneDtoRequest dto){
        return client.cadastrarNovoTelefone(dto, token);
    }
}
