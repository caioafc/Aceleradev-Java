package challenge;

public class teste {
    public static void main(String[] args) {
            Motorista motorista = Motorista.builder().withNome("Ada").withIdade(20)
                    .withPontos(3)
                    .withHabilitacao("1231")
                    .build();
            Carro carro = Carro.builder().withCor(Cor.BRANCO).
                    withPlaca("123")
                    .withMotorista(motorista)
                    .build();

            Estacionamento estacionamento = new Estacionamento();
            estacionamento.estacionar(carro);

        System.out.println(estacionamento.carrosEstacionados());

        }

}
