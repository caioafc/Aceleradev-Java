package br.com.codenation.models;

import br.com.codenation.DesafioMeuTimeApplication;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Teste {
    public static void main(String[] args) {
        final DesafioMeuTimeApplication desafioMeuTimeApplication = new DesafioMeuTimeApplication();
        desafioMeuTimeApplication.incluirTime(1l, "Teste1", LocalDate.now(), "branco", "branco");
        desafioMeuTimeApplication.incluirTime(2l, "Teste1", LocalDate.now(), "branco", "branco");

        System.out.println(desafioMeuTimeApplication.buscarTopJogadores(2));
    }
}
