package senai.apirequisicoes.dominio.validacoes;

public class Cpf {

    public Cpf(String cpf) {
        if (!validaCPF(cpf)) {
            throw new IllegalArgumentException("CPF inválido");
        }
    }

    private boolean validaCPF(String cpf) {
        String cpfFiltrado = filtraCaracteres(cpf);
        return verificaTamanho(cpfFiltrado) && verificaDigitoEmSequencia(cpfFiltrado) && verificaDigito(cpfFiltrado);
    }

    private boolean verificaTamanho(String cpf) {
        int QUANTIDADE_CARACTERES_CPF = 11;
        return cpf.length() == QUANTIDADE_CARACTERES_CPF;
    }

    private String filtraCaracteres(String cpf) {
        return cpf.replaceAll("\\D", "");
    }

    private boolean verificaDigitoEmSequencia(String cpf) {
        return !cpf.matches("(\\d)\\1{10}");

    }

    private boolean verificaDigito(String cpf) {
        final int[] cpfArray = transformaStringEmArray(cpf);
        int digito1 = calculaDigito1(cpfArray);
        int digito2 = calculaDigito2(cpfArray);
        return digito1 == cpfArray[9] && digito2 == cpfArray[10];
    }

    private int calculaDigito2(int[] cpfArray) {
        int soma2 = somaDoCpfMultiplicado2(cpfArray);
        return restoDivisaoPorOnze(soma2);
    }

    private int somaDoCpfMultiplicado2(int[] cpfArray) {
        int soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += cpfArray[i] * (11 - i);
        }
        return soma;
    }

    private int calculaDigito1(int[] cpfArray) {
        int soma1 = somaDoCpfMultiplicado1(cpfArray);
        return restoDivisaoPorOnze(soma1);
    }

    private int somaDoCpfMultiplicado1(int[] cpfArray) {
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += cpfArray[i] * (10 - i);
        }
        return soma;
    }

    private int restoDivisaoPorOnze(int soma) {
        int resto = soma % 11;
        return (resto < 2) ? 0 : 11 - resto;
    }

    private int[] transformaStringEmArray(String cpf){
        int[] cpfArray = new int[cpf.length()];
        for(int i = 0; i < cpfArray.length; i++){
            cpfArray[i] = Character.getNumericValue(cpf.charAt(i));
        }
        return cpfArray;
    }

}
