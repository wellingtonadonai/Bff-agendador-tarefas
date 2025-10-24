package br.com.bffAgendador.bff_agendador_tarefas.bunisses;

import br.com.bffAgendador.bff_agendador_tarefas.bunisses.dto.EnderecoDto;
import br.com.bffAgendador.bff_agendador_tarefas.bunisses.dto.TelefoneDto;
import br.com.bffAgendador.bff_agendador_tarefas.bunisses.dto.UsuarioDto;
import br.com.bffAgendador.bff_agendador_tarefas.infraestructure.client.UsuarioClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService {

    private final UsuarioClient client;

    public UsuarioService(UsuarioClient client){
        this.client = client;
    }

    public UsuarioDto salvarUsuario(UsuarioDto usuarioDto){
        return client.salvarUsuario(usuarioDto);
    }

    public String loginUsuario(UsuarioDto dto){
        return client.login(dto);
    }

    public UsuarioDto buscaUsuarioPorEmail(String email, String token){

        return client.buscaUsuarioPorEmail(email, token);

    }

    public void deletaUsuarioPorEmail(String email, String token){
        client.deletarUsuarioEmail(email, token);
    }
    public UsuarioDto atualizaDadosUsuario(String token, UsuarioDto dto){
        return client.atualizaadosUsuarios(dto, token);

    }
    public EnderecoDto atualizaEndereco(Long idEndereco, EnderecoDto enderecoDto, String token){
        return client.atualizarEndereco(enderecoDto, idEndereco, token);

    }

    public TelefoneDto atualizaTelefone(Long idTelefone, TelefoneDto telefoneDto, String token){
        return client.atualizarTelefone(telefoneDto, idTelefone, token);
    }
    public EnderecoDto cadastroEndereco(String token, EnderecoDto dto){
        return client.cadastrarNovoEndereco(dto, token);

    }
    public TelefoneDto cadastroTelefone(String token, TelefoneDto dto){
        return client.cadastrarNovoTelefone(dto, token);
    }
}
