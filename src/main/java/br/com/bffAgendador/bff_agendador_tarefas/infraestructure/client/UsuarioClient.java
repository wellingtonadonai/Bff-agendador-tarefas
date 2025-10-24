package br.com.bffAgendador.bff_agendador_tarefas.infraestructure.client;


import br.com.bffAgendador.bff_agendador_tarefas.bunisses.dto.EnderecoDto;
import br.com.bffAgendador.bff_agendador_tarefas.bunisses.dto.TelefoneDto;
import br.com.bffAgendador.bff_agendador_tarefas.bunisses.dto.UsuarioDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "usuario", url = "${usuario.url}")
public interface UsuarioClient {

    @GetMapping("/usuario")
    UsuarioDto buscaUsuarioPorEmail(@RequestParam("email") String email,
                                    @RequestHeader("Authorization") String token);

    @PostMapping
    UsuarioDto salvarUsuario(@RequestBody UsuarioDto usuarioDto);


    @PostMapping("/login")
    String login(@RequestBody UsuarioDto usuarioDto);


    @DeleteMapping("/{email}")
    void deletarUsuarioEmail(@PathVariable String email,
                             @RequestHeader("Authorization") String token);

    @PutMapping
    UsuarioDto atualizaadosUsuarios(@RequestBody UsuarioDto dto,
                                    @RequestHeader("Authorization") String token);


    @PutMapping("/endereco")
    EnderecoDto atualizarEndereco(@RequestBody EnderecoDto dto,
                                  @RequestParam("id") Long id,
                                  @RequestHeader("Authorization") String token);


    @PutMapping("/telefone")
    TelefoneDto atualizarTelefone(@RequestBody TelefoneDto dto,
                                  @RequestParam("id") Long id,
                                  @RequestHeader("Authorization") String token);

    @PostMapping("/enderecos")
    EnderecoDto cadastrarNovoEndereco(@RequestBody EnderecoDto dto,
                                      @RequestHeader("Authorization") String token);

    @PostMapping("/telefone")
    TelefoneDto cadastrarNovoTelefone(@RequestBody TelefoneDto dto,
                                      @RequestHeader("Authorization") String token);
}
