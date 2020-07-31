package challenge;

import java.util.Objects;

public class Carro {

    private final Motorista motorista;

    private final String placa;

    private final Cor cor;

    private Carro(Motorista motorista, String placa, Cor cor) {
        this.motorista = motorista;
        this.placa = placa;
        this.cor = cor;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public String getPlaca() {
        return placa;
    }

    public Cor getCor() {
        return cor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Carro carro = (Carro) o;
        return Objects.equals(motorista, carro.motorista) &&
                Objects.equals(placa, carro.placa) &&
                cor == carro.cor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(motorista, placa, cor);
    }

    @Override
    public String toString() {
        return "Carro{" +
                "motorista=" + motorista +
                ", placa='" + placa + '\'' +
                ", cor=" + cor +
                '}';
    }

    public static CarroBuilder builder() {
        return new CarroBuilder();
    }


    public static class CarroBuilder {

        private Motorista motorista;

        private String placa;

        private Cor cor;

        private CarroBuilder() {
        }

        public CarroBuilder withMotorista(Motorista motorista) {
            this.motorista = motorista;
            validaMotorista();
            return this;
        }

        public CarroBuilder withPlaca(String placa) {
            this.placa = placa;
            validaPlaca();
            return this;
        }

        public CarroBuilder withCor(Cor cor) {
            this.cor = cor;
            validaCor();
            return this;
        }

        public Carro build() {
            validaCarro();
            return new Carro(motorista, placa, cor);
        }

        private void validaPlaca() {
            if(this.placa == null) {
                throw new NullPointerException("O valor preenchido no campo placa é inválido.");
            }
        }

        private void validaCor() {
            if(this.cor == null) {
                throw new NullPointerException("O valor preenchido no campo cor é inválido.");
            }
        }

        private void validaMotorista() {
            if(this.motorista == null) {
                throw new EstacionamentoException("Não é permitido cadastrar carros sem motorista.");
            }
        }

        private void validaCarro() {
            validaPlaca();
            validaCor();
            validaMotorista();
        }
    }
}
