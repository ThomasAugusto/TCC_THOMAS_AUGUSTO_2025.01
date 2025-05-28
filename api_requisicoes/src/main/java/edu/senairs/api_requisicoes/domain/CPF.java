package edu.senairs.api_requisicoes.domain;

public class CPF {
    private final String cpf;

    public CPF(String cpf) {
        if (!cpfIsValid(cpf)) {
            throw new IllegalArgumentException("CPF inválido");
        }
        this.cpf = cpf;
    }

    private boolean cpfIsValid(String cpf) {
        String filtredCpf = filterString(cpf);
        return lengthIsValid(filtredCpf) && repetitiveNumber(filtredCpf) && cpfValidity(filtredCpf);
    }

    private boolean lengthIsValid(String cpf) {
        int CPF_LENGTH = 11;
        return cpf.length() == CPF_LENGTH;
    }

    private String filterString(String cpf) {
        return cpf.replaceAll("\\D", "");
    }

    private boolean repetitiveNumber(String cpf) {
        return !cpf.matches("(\\d)\\1{10}");

    }

    private boolean cpfValidity(String cpf) {
        final int[] cpfArray = arrayToString(cpf);
        int number1 = number1Calculator(cpfArray);
        int number2 = number2Calculator(cpfArray);
        return number1 == cpfArray[9] && number2 == cpfArray[10];
    }

    private int number2Calculator(int[] cpfArray) {
        int sum2 = cpfSumProducts2(cpfArray);
        return remainderForEleven(sum2);
    }

    private int cpfSumProducts2(int[] cpfArray) {
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += cpfArray[i] * (11 - i);
        }
        return sum;
    }

    private int number1Calculator(int[] cpfArray) {
        int sum1 = cpfSumProducts1(cpfArray);
        return remainderForEleven(sum1);
    }

    private int cpfSumProducts1(int[] cpfArray) {
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += cpfArray[i] * (10 - i);
        }
        return sum;
    }

    private int remainderForEleven(int sum) {
        int remainder = sum % 11;
        return (remainder < 2) ? 0 : 11 - remainder;
    }

    private int[] arrayToString(String cpf){
        int[] cpfArray = new int[cpf.length()];
        for(int i = 0; i < cpfArray.length; i++){
            cpfArray[i] = Character.getNumericValue(cpf.charAt(i));
        }
        return cpfArray;
    }
}
