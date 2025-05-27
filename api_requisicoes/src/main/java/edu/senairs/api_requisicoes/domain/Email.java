package edu.senairs.api_requisicoes.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {
    private final String email;

    public Email(String email) {
        if (!emailIsValid(email)){
            throw new IllegalArgumentException("Email inválido");
        }
        this.email = email;
    }

    private final Pattern REGEX_VALID_EMAIL =
            Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$", Pattern.CASE_INSENSITIVE);

    private boolean emailIsValid(String email) {
        Matcher matcher = REGEX_VALID_EMAIL.matcher(email);
        return matcher.matches();
    }
}
