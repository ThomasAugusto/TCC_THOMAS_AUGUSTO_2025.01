package edu.senairs.api_requisicoes.service;

import edu.senairs.api_requisicoes.entidades.requerimentos.GeradorProtocolo;
import edu.senairs.api_requisicoes.entidades.usuarios.autentificacao.TipoUsuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Objects;

class RequerimentoServiceTest {

    @Test
    void deveVerificarSeUsuarioEhAluno () {
        // Arrange
        String tipoUsuario = "aluno";
        // Act
        boolean resultado = tipoUsuario.equals(TipoUsuario.ALUNO.getTipoUsuario());
        // Assert
        Assertions.assertTrue(resultado);
    }
    @Test
    void deveVerficarSeUsuarioNaoEhAluno(){
        // Arrange
        String tipoUsuario = "secretaria";
        // Act
        boolean resultado = tipoUsuario.equals(TipoUsuario.ALUNO.getTipoUsuario());
        // Assert
        Assertions.assertFalse(resultado);
    }
    @Test
    void testarGeradorProtocolo(){
        // Arrange
        String esperado = "CAMAT2025000001";
        // Act
        GeradorProtocolo geradorProtocolo = new GeradorProtocolo();
        var resultado = geradorProtocolo.gerarProtocolo(GeradorProtocolo.Processo.CAMAT);
        // Assert
        Assertions.assertEquals(esperado, resultado);
    }
    @Test
    void testandoUsuarioBiblioteca(){
        // Arrange
        String tipoUsuario = "biblioteca";
        // Act
        String resultado = testandoBlocoSwitchUsuarios(tipoUsuario);
        // Assert
        Assertions.assertEquals("Usuário é da biblioteca", resultado);
    }
    @Test
    void testandoUsuarioSecretaria(){
        // Arrange
        String tipoUsuario = "secretaria";
        // Act
        String resultado = testandoBlocoSwitchUsuarios(tipoUsuario);
        // Assert
        Assertions.assertEquals("Usuário é da secretaria", resultado);
    }
    @Test
    void testandoUsuarioCoordenacao(){
        // Arrange
        String tipoUsuario = "coordenacao";
        // Act
        String resultado = testandoBlocoSwitchUsuarios(tipoUsuario);
        // Assert
        Assertions.assertEquals("Usuário é da coordenação", resultado);
    }
    @Test
    void testandoUsuarioFinanceiro(){
        // Arrange
        String tipoUsuario = "financeiro";
        // Act
        String resultado = testandoBlocoSwitchUsuarios(tipoUsuario);
        // Assert
        Assertions.assertEquals("Usuário é do financeiro", resultado);
    }

    private String testandoBlocoSwitchUsuarios(String tipoUsuario){
        var tipo = Objects.requireNonNull(TipoUsuario.getTipoUsuarioEnum(tipoUsuario), "Tipo nulo");

        return switch (tipo) {
            case SECRETARIA -> "Usuário é da secretaria";
            case COORDENACAO -> "Usuário é da coordenação";
            case BIBLIOTECA -> "Usuário é da biblioteca";
            case FINANCEIRO -> "Usuário é do financeiro";
            default -> "Usuário é inválido";
        };
    }
}