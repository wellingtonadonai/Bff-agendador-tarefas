package br.com.bffAgendador.bff_agendador_tarefas.infraestructure.client;


import br.com.bffAgendador.bff_agendador_tarefas.bunisses.dto.in.EnderecoDtoRequest;
import br.com.bffAgendador.bff_agendador_tarefas.bunisses.dto.in.LoginRequestDto;
import br.com.bffAgendador.bff_agendador_tarefas.bunisses.dto.in.TelefoneDtoRequest;
import br.com.bffAgendador.bff_agendador_tarefas.bunisses.dto.in.UsuarioDtoRequest;
import br.com.bffAgendador.bff_agendador_tarefas.bunisses.dto.out.EnderecoDtoResponse;
import br.com.bffAgendador.bff_agendador_tarefas.bunisses.dto.out.TelefoneDtoResponse;
import br.com.bffAgendador.bff_agendador_tarefas.bunisses.dto.out.UsuarioDtoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "usuario", url = "${usuario.url}")
public interface UsuarioClient {

    @GetMapping("/usuario")
    UsuarioDtoResponse buscaUsuarioPorEmail(@RequestParam("email") String email,
                                            @RequestHeader("Authorization") String token);

    @PostMapping
    UsuarioDtoResponse salvarUsuario(@RequestBody UsuarioDtoRequest usuarioDto);


    @PostMapping("/login")
    String login(@RequestBody LoginRequestDto usuarioDto);


    @DeleteMapping("/{email}")
    void deletarUsuarioEmail(@PathVariable String email,
                             @RequestHeader("Authorization") String token);

    @PutMapping
    UsuarioDtoResponse atualizaadosUsuarios(@RequestBody UsuarioDtoRequest dto,
                                            @RequestHeader("Authorization") String token);


    @PutMapping("/endereco")
    EnderecoDtoResponse atualizarEndereco(@RequestBody EnderecoDtoRequest dto,
                                          @RequestParam("id") Long id,
                                          @RequestHeader("Authorization") String token);


    @PutMapping("/telefone")
    TelefoneDtoResponse atualizarTelefone(@RequestBody TelefoneDtoRequest dto,
                                          @RequestParam("id") Long id,
                                          @RequestHeader("Authorization") String token);

    @PostMapping("/enderecos")
    EnderecoDtoResponse cadastrarNovoEndereco(@RequestBody EnderecoDtoRequest dto,
                                              @RequestHeader("Authorization") String token);

    @PostMapping("/telefone")
    TelefoneDtoResponse cadastrarNovoTelefone(@RequestBody TelefoneDtoRequest dto,
                                              @RequestHeader("Authorization") String token);
}
