package edu.senairs.api_requisicoes.dominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

public class ProtocolIdGenerate {

    public enum Process{
        TRMAT, CAMAT
    }

    private static final AtomicInteger serialAcount = new AtomicInteger(1);

    public static String generateProtocolId(Process process){
        LocalDate dateNow = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");
        String year = dateNow.format(formatter);

        StringBuilder protocolId = new StringBuilder();
        protocolId.append(process.name());
        protocolId.append(year);
        protocolId.append(String.format("%06d", serialAcount.getAndIncrement()));

        return protocolId.toString();
    }
}
