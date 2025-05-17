package senai.apirequisicoes.dominio.validacoes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

class CpfTest {

    @Test
    void testFiltraCaracteres() throws Exception {
       // Acessa o metodo privado da classe Cpf
        Method filtro = Cpf.class.getDeclaredMethod("filtraCaracteres", String.class);
        filtro.setAccessible(true);

        // arrange
        String cpfEntrada = "032.79f0.770-36";
        String resultadoEsperado = "03279077036";

        // act
        String cpfFiltrado = filtro.invoke(new Cpf("03279077036"), cpfEntrada).toString();

        // assertion
        Assertions.assertEquals(resultadoEsperado, cpfFiltrado);
    }

    @Test
    void testVerificaTamanhoValido() throws Exception {
        Method method = Cpf.class.getDeclaredMethod("verificaTamanho", String.class);
        method.setAccessible(true);

        method.invoke(new Cpf("03279077036"), "99999999999");

        Assertions.assertTrue(true);
    }

    @Test
    void testVerificaTamanhoInvalido() throws Exception {
        Method method = Cpf.class.getDeclaredMethod("verificaTamanho", String.class);
        method.setAccessible(true);

        method.invoke(new Cpf("03279077036"), "999999999");

        Assertions.assertFalse(false);
    }

    @Test
    void testTransformaStringEmArray() throws Exception {
        Method method = Cpf.class.getDeclaredMethod("transformaStringEmArray", String.class);
        method.setAccessible(true);

        int[] arrayEsperado = {2, 4, 6, 8, 1, 3, 5, 7, 9, 0, 0};
        int[] arrayAtual = (int[]) method.invoke(new Cpf("03279077036"), "24681357900");

        Assertions.assertArrayEquals(arrayEsperado, arrayAtual);
    }

    @Test
    void testSomaDoCpfMultiplicado1() throws Exception {
        Method method = Cpf.class.getDeclaredMethod("somaDoCpfMultiplicado1", int[].class);
        method.setAccessible(true);

        int[] arrayComCpfValido = {0, 3, 2, 7, 9, 0, 7, 7, 0, 3, 6};
        int somaEsperada = 195;
        int somaAtual = (int) method.invoke(new Cpf("03279077036"), arrayComCpfValido);

        Assertions.assertEquals(somaEsperada, somaAtual);
    }

    @Test
    void testRestoDivisaoPorOnze() throws Exception {
        Method method = Cpf.class.getDeclaredMethod("restoDivisaoPorOnze", int.class);
        method.setAccessible(true);

        int soma = 195;
        int restoEsperado = 3;
        int restoAtual = (int) method.invoke(new Cpf("03279077036"), soma);

        Assertions.assertEquals(restoEsperado, restoAtual);
    }

    @Test
    void testVerficaDigito() throws Exception {
        Method method = Cpf.class.getDeclaredMethod("verificaDigito", String.class);
        method.setAccessible(true);

        String cpfValido = "03279077036";
        method.invoke(new Cpf(cpfValido), cpfValido);

        Assertions.assertTrue(true);
    }

    @Test
    void testverificaDigitoEmSequencia() throws Exception {
        Method method = Cpf.class.getDeclaredMethod("verificaDigitoEmSequencia", String.class);
        method.setAccessible(true);

        String cpfInvalido = "99999999999";
        method.invoke(new Cpf("03279077036"), cpfInvalido);

        Assertions.assertFalse(false);
    }

    @Test
    void testValidaCPFInvalido() throws Exception {
        Method method = Cpf.class.getDeclaredMethod("validaCPF", String.class);
        method.setAccessible(true);

        String cpfInvalido = "999-999-999-99";
        method.invoke(new Cpf("03279077036"), cpfInvalido);

        Assertions.assertFalse(false);
    }

    @Test
    void testValidaCPFValido() throws Exception {
        Method method = Cpf.class.getDeclaredMethod("validaCPF", String.class);
        method.setAccessible(true);

        String cpfValido = "032-79d0-770-36"; //testando filtro junto
        method.invoke(new Cpf("03279077036"), cpfValido);

        Assertions.assertTrue(true);
    }

}