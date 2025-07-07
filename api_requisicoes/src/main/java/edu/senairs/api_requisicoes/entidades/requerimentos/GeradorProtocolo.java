package edu.senairs.api_requisicoes.entidades.requerimentos;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class GeradorProtocolo {

    public enum Processo {
        TRMAT, CAMAT
    }

    private static final AtomicInteger contadorSerial = new AtomicInteger(1);

    public String gerarProtocolo(Processo processo){
        return gerarNumeroProtocolo(processo);
    }

    private static String gerarNumeroProtocolo(Processo processo){
        LocalDateTime dateNow = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");
        String ano = dateNow.format(formatter);

        return processo.name() +
                ano +
                String.format("%06d", contadorSerial.getAndIncrement());
    }
}
