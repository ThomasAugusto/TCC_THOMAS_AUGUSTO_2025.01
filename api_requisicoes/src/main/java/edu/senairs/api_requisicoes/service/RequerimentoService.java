package edu.senairs.api_requisicoes.service;

import edu.senairs.api_requisicoes.entidades.processos.CancelamentoMatricula;
import edu.senairs.api_requisicoes.entidades.processos.CancelamentoMatriculaDTO;
import edu.senairs.api_requisicoes.entidades.processos.TrancamentoMatricula;
import edu.senairs.api_requisicoes.entidades.processos.TrancamentoMatriculaDTO;
import edu.senairs.api_requisicoes.entidades.requerimentos.EstadoProcesso;
import edu.senairs.api_requisicoes.entidades.requerimentos.GeradorProtocolo;
import edu.senairs.api_requisicoes.entidades.requerimentos.MongoRequerimento;
import edu.senairs.api_requisicoes.entidades.requerimentos.ObservacaoDTO;
import edu.senairs.api_requisicoes.entidades.usuarios.*;
import edu.senairs.api_requisicoes.entidades.usuarios.autentificacao.TipoUsuario;
import edu.senairs.api_requisicoes.repository.MongoRequerimentosRepository;
import edu.senairs.api_requisicoes.repository.MongoUsuariosRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class RequerimentoService {

    private final MongoRequerimentosRepository mongoRequerimentosRepository;
    private final MongoUsuariosRepository mongoUsuariosRepository;

    public RequerimentoService(MongoRequerimentosRepository mongoRequerimentosRepository,
                               MongoUsuariosRepository mongoUsuariosRepository) {
        this.mongoRequerimentosRepository = mongoRequerimentosRepository;
        this.mongoUsuariosRepository = mongoUsuariosRepository;
    }

    public List<MongoRequerimento> listarRequerimentos(String idUsuario){
        var usuario = this.mongoUsuariosRepository.findTipoUsuarioByIdUsuario(idUsuario);
        var tipo = Objects.requireNonNull(TipoUsuario.getTipoUsuarioEnum(usuario.getTipoUsuario()), "Tipo nulo");

        return switch (tipo) {
                        case SECRETARIA -> mongoRequerimentosRepository
                                .findAllByEstadoProcesso(EstadoProcesso.ENVIAR_SECRETARIA.getDescricao());
                        case COORDENACAO -> mongoRequerimentosRepository
                                .findAllByEstadoProcesso(EstadoProcesso.ENVIAR_COORDENACAO.getDescricao());
                        case BIBLIOTECA -> mongoRequerimentosRepository
                                .findAllByEstadoProcesso(EstadoProcesso.ENVIAR_BIBLIOTECA.getDescricao());
                        case FINANCEIRO -> mongoRequerimentosRepository
                                .findAllByEstadoProcesso(EstadoProcesso.ENVIAR_FINANCEIRO.getDescricao());
                        default -> throw new IllegalArgumentException("Usuário inválido");
                    };
    }

    public void solicitarCancelamentoMatricula(CancelamentoMatriculaDTO data){
        var tipoUsuario = this.mongoUsuariosRepository.findTipoUsuarioByIdUsuario(data.idUsuario());
        if(!tipoUsuario.getTipoUsuario().equals(TipoUsuario.ALUNO.getTipoUsuario())){
            throw new IllegalArgumentException("Usuário inválido");
        }
        Aluno dadosAluno = new Aluno(data.dadosAluno().nome(),
                                        data.dadosAluno().cpf(),
                                        data.dadosAluno().telefone(),
                                        data.dadosAluno().email());
        CancelamentoMatricula formulario = new CancelamentoMatricula(data.curso(), data.motivo());
        GeradorProtocolo geradorProtocolo = new GeradorProtocolo();
        var protocolo = geradorProtocolo.gerarProtocolo(GeradorProtocolo.Processo.CAMAT);
        MongoRequerimento<CancelamentoMatricula> novoRequerimento = new MongoRequerimento<>(formulario, protocolo, dadosAluno);
        this.mongoRequerimentosRepository.save(novoRequerimento);
    }

    public void solicitarTrancamentoMatricula(TrancamentoMatriculaDTO data){
        var tipoUsuario = this.mongoUsuariosRepository.findTipoUsuarioByIdUsuario(data.idUsuario());
        if(!tipoUsuario.getTipoUsuario().equals(TipoUsuario.ALUNO.getTipoUsuario())){
            throw new IllegalArgumentException("Usuário inválido");
        }
        Aluno dadosAluno = new Aluno(data.dadosAluno().nome(),
                                        data.dadosAluno().cpf(),
                                        data.dadosAluno().telefone(),
                                        data.dadosAluno().email());
        TrancamentoMatricula formulario = new TrancamentoMatricula(data.curso(),data.motivo(),
                                                                    data.semestreAtual(), data.semestresAfastados());
        GeradorProtocolo geradorProtocolo = new GeradorProtocolo();
        var protocolo = geradorProtocolo.gerarProtocolo(GeradorProtocolo.Processo.TRMAT);
        MongoRequerimento<TrancamentoMatricula> novoRequerimento = new MongoRequerimento<>(formulario, protocolo, dadosAluno);
        this.mongoRequerimentosRepository.save(novoRequerimento);
    }

    public void atualizarRequerimento(String idUsuario, String idRequerimento, ObservacaoDTO data){
        var usuario = this.mongoUsuariosRepository.findTipoUsuarioByIdUsuario(idUsuario);
        var nome = usuario.getNomeUsuario();
        var email = usuario.getEmailUsuario();
        var requerimento = this.mongoRequerimentosRepository.findById(idRequerimento).orElseThrow(() ->
                new IllegalArgumentException("Requerimento não encontrado"));
        var observacao = Optional.ofNullable(data.observacao()).filter(c -> !c.isBlank()).orElse("");

        var tipo = Objects.requireNonNull(TipoUsuario.getTipoUsuarioEnum(usuario.getTipoUsuario()), "Tipo nulo");

        switch (tipo) {
            case SECRETARIA -> {
                Secretaria secretaria = new Secretaria(nome, email, observacao);
                requerimento.setSecretaria(secretaria);
                requerimento.setEstado(EstadoProcesso.ENVIAR_COORDENACAO.getDescricao());
                this.mongoRequerimentosRepository.save(requerimento);
            }
            case COORDENACAO -> {
                Coordenacao coordenacao = new Coordenacao(nome, email, observacao);
                requerimento.setCoordenacao(coordenacao);
                requerimento.setEstado(EstadoProcesso.ENVIAR_BIBLIOTECA.getDescricao());
                this.mongoRequerimentosRepository.save(requerimento);
            }
            case BIBLIOTECA -> {
                Biblioteca biblioteca = new Biblioteca(nome, email, observacao);
                requerimento.setBiblioteca(biblioteca);
                requerimento.setEstado(EstadoProcesso.ENVIAR_FINANCEIRO.getDescricao());
                this.mongoRequerimentosRepository.save(requerimento);
            }
            case FINANCEIRO -> {
                Financeiro financeiro = new Financeiro(nome, email, observacao);
                requerimento.setFinanceiro(financeiro);
                requerimento.setEstado(EstadoProcesso.CONCLUIDO.getDescricao());
                requerimento.setDataConclusao(java.time.LocalDateTime.now());
                requerimento.setAtivo(false);
                this.mongoRequerimentosRepository.save(requerimento);
            }
            default -> throw new IllegalArgumentException("Usuário inválido");
        }
    }

    public void enviarParaRevisarDados(String idUsuario, String idRequerimento, ObservacaoDTO data){
        var usuario = this.mongoUsuariosRepository.findTipoUsuarioByIdUsuario(idUsuario);
        var nome = usuario.getNomeUsuario();
        var email = usuario.getEmailUsuario();
        var requerimento = this.mongoRequerimentosRepository.findById(idRequerimento).orElseThrow(() ->
                new IllegalArgumentException("Requerimento não encontrado"));
        var observacao = Optional.ofNullable(data.observacao()).filter(c -> !c.isBlank()).orElse("");

        var tipo = Objects.requireNonNull(TipoUsuario.getTipoUsuarioEnum(usuario.getTipoUsuario()), "Tipo nulo");

        if (!tipo.equals(TipoUsuario.BIBLIOTECA)){
            throw new IllegalArgumentException("Usuário inválido");
        }
        Secretaria secretaria = new Secretaria(nome, email, observacao);
        requerimento.setSecretaria(secretaria);
        requerimento.setEstado(EstadoProcesso.ENVIAR_ALUNO.getDescricao());
        this.mongoRequerimentosRepository.save(requerimento);
    }

    public void atualizarDadosAluno(String idUsuario, String idRequerimento, DadosAlunoDTO data){
        var tipoUsuario = this.mongoUsuariosRepository.findTipoUsuarioByIdUsuario(idUsuario);
        if(!tipoUsuario.getTipoUsuario().equals(TipoUsuario.ALUNO.getTipoUsuario())){
            throw new IllegalArgumentException("Usuário inválido");
        }
        var requerimento = this.mongoRequerimentosRepository.findById(idRequerimento).orElseThrow(() ->
                new IllegalArgumentException("Requerimento não encontrado"));
        Aluno dadosAluno = new Aluno(data.nome(),
                                        data.cpf(),
                                        data.telefone(),
                                        data.email());
        requerimento.setAluno(dadosAluno);
        requerimento.setEstado(EstadoProcesso.ENVIAR_SECRETARIA.getDescricao());
        this.mongoRequerimentosRepository.save(requerimento);
    }
}
