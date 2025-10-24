package br.com.bffAgendador.bff_agendador_tarefas.controller;

import br.com.bffAgendador.bff_agendador_tarefas.bunisses.UsuarioService;
import br.com.bffAgendador.bff_agendador_tarefas.bunisses.dto.in.EnderecoDtoRequest;
import br.com.bffAgendador.bff_agendador_tarefas.bunisses.dto.in.LoginRequestDto;
import br.com.bffAgendador.bff_agendador_tarefas.bunisses.dto.in.TelefoneDtoRequest;
import br.com.bffAgendador.bff_agendador_tarefas.bunisses.dto.in.UsuarioDtoRequest;
import br.com.bffAgendador.bff_agendador_tarefas.bunisses.dto.out.EnderecoDtoResponse;
import br.com.bffAgendador.bff_agendador_tarefas.bunisses.dto.out.TelefoneDtoResponse;
import br.com.bffAgendador.bff_agendador_tarefas.bunisses.dto.out.UsuarioDtoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@Tag(name = "Usuário", description = "Cadastro e Login de usuário")
public class UsuarioController {

    private final UsuarioService usuarioService;


    public UsuarioController(UsuarioService service){
        this.usuarioService = service;
    }

    @PostMapping
    @Operation(summary = "Salvar Usuário", description = "Cria um novo usuário")
    @ApiResponse(responseCode = "200", description = "Usuário salvo com Sucesso")
    @ApiResponse(responseCode = "400", description = "Usuário ja cadastrado")
    @ApiResponse(responseCode = "500", description = "Erro de Servidor")
    public ResponseEntity<UsuarioDtoResponse> salvarUsuario(@RequestBody UsuarioDtoRequest usuarioDto) {
        return ResponseEntity.ok(usuarioService.salvarUsuario(usuarioDto));

    }

    @PostMapping("/login")
    @Operation(summary = "Login de Usuario", description = "Login de usuário")
    @ApiResponse(responseCode = "200", description = "Usuário Logado")
    @ApiResponse(responseCode = "401", description = "Credenciais inválidas ")
    @ApiResponse(responseCode = "500", description = "Erro de Servidor")
    public String login(@RequestBody LoginRequestDto usuarioDto) {

        return usuarioService.loginUsuario(usuarioDto);

    }

    @GetMapping
    @Operation(summary = "Buscar dados de Usuario por Email", description = "Buscar dados de usuário")
    @ApiResponse(responseCode = "200", description = "Usuário Encontrado")
    @ApiResponse(responseCode = "404", description = "Usuário não encontrado ")
    @ApiResponse(responseCode = "500", description = "Erro de Servidor")
    public ResponseEntity<UsuarioDtoResponse> buscaUsuarioPorEmail(@RequestParam("email") String email,
                                                                   @RequestHeader(name = "Authorization", required = false)String token


){
        return ResponseEntity.ok(usuarioService.buscaUsuarioPorEmail(email, token));

    }

    @DeleteMapping("/{email}")
    @Operation(summary = "Deletar de Usuario por id", description = "Deleta o usuário")
    @ApiResponse(responseCode = "200", description = "Usuário Deletado")
    @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de Servidor")
    public ResponseEntity<Void> deletarUsuarioEmail(@PathVariable String email,
                                                    @RequestHeader(name = "Authorization", required = false)String token


){
        usuarioService.deletaUsuarioPorEmail(email, token);

        return ResponseEntity.ok().build();

    }

    @PutMapping
    @Operation(summary = "Atualizar dados de Usuario", description = "Atualizar dados de Usuario")
    @ApiResponse(responseCode = "200", description = "Usuário atualizado com sucesso")
    @ApiResponse(responseCode = "404", description = "Usuário não cadastrado")
    @ApiResponse(responseCode = "500", description = "Erro de Servidor")
    public ResponseEntity<UsuarioDtoResponse> atualizaadosUsuarios(@RequestBody UsuarioDtoRequest dto,
                                                                   @RequestHeader(name = "Authorization", required = false)String token


) {
        return ResponseEntity.ok(usuarioService.atualizaDadosUsuario(token, dto));
    }

    @PutMapping("/endereco")
    @Operation(summary = "Atualizar endereço de Usuario", description = "Atualizar endereço de Usuario")
    @ApiResponse(responseCode = "200", description = "Endereço atualizado com sucesso")
    @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de Servidor")
    public ResponseEntity<EnderecoDtoResponse> atualizarEndereco(@RequestBody EnderecoDtoRequest dto,
                                                                 @RequestParam("id") Long id,
                                                                 @RequestHeader(name = "Authorization", required = false)String token


){
        return ResponseEntity.ok(usuarioService.atualizaEndereco(id, dto, token));
    }

    @PutMapping("/telefone")
    @Operation(summary = "Atualizar telefone de Usuario", description = "Atualizar telefone de Usuario")
    @ApiResponse(responseCode = "200", description = "Telefone atualizado com sucesso")
    @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de Servidor")
    public ResponseEntity<TelefoneDtoResponse> atualizarTelefone(@RequestBody TelefoneDtoRequest dto,
                                                                 @RequestParam("id") Long id,
                                                                 @RequestHeader(name = "Authorization", required = false)String token


){
        return ResponseEntity.ok(usuarioService.atualizaTelefone(id, dto, token));
    }

    @PostMapping("/enderecos")
    @Operation(summary = "Salva endereço de Usuario", description = "Salva endereço de Usuario")
    @ApiResponse(responseCode = "200", description = "Endereço salvo com sucesso")
    @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de Servidor")
    public ResponseEntity<EnderecoDtoResponse> cadastrarNovoEndereco(@RequestBody EnderecoDtoRequest dto,
                                                                     @RequestHeader(name = "Authorization", required = false)String token


) {
        return ResponseEntity.ok(usuarioService.cadastroEndereco(token, dto));
    }

    @PostMapping("/telefone")
    @Operation(summary = "Salva telefone de Usuario", description = "Salva telefone de Usuario")
    @ApiResponse(responseCode = "200", description = "Telefone salvo com sucesso")
    @ApiResponse(responseCode = "404", description = "Usuário não Encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de Servidor")
    public ResponseEntity<TelefoneDtoResponse> cadastrarNovoTelefone(@RequestBody TelefoneDtoRequest dto,
                                                                     @RequestHeader(name = "Authorization", required = false)String token


) {
        return ResponseEntity.ok(usuarioService.cadastroTelefone(token, dto));
    }
}
