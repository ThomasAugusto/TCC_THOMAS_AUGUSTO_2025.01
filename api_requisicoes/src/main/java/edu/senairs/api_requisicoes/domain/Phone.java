package edu.senairs.api_requisicoes.domain;

public class Phone {
    private String number;

    public Phone(String number) {
        if (!phoneNumberIsValid(number)){
            throw new IllegalArgumentException("Telefone invalido");
        }
        this.number = number;
    }

    private boolean phoneNumberIsValid(String number){
        String filtredNumber = filterNumber(number);
        return numberSize(filtredNumber) && regexNumber(filtredNumber)
                && distinctNumber(filtredNumber) && repetitiveNumber(filtredNumber);
    }

    private boolean repetitiveNumber(String number){
        return !number.matches(".*(\\d)\\1{4,}.*");
    }

    private boolean distinctNumber(String number){
        int DISTINCT_NUMBERS = 3;
        return number.chars().distinct().count() >= DISTINCT_NUMBERS;
    }

    private boolean numberSize(String number){
        int NUMBER_WITH_DDD_SIZE = 11;
        return number.length() == NUMBER_WITH_DDD_SIZE;
    }

    private boolean regexNumber(String number){
        return number.matches("^[1-9]{2}9[1-9][0-9]{7}$");
    }

    private String filterNumber(String number){
        return number.replaceAll("\\D", "");
    }
}
