package challenge;

import java.util.ArrayList;
import java.util.List;

public class Estacionamento {

    private List<Carro> carros = new ArrayList<>();

    public void estacionar(Carro carro) {
        if(carrosEstacionados() == 10) {
            removeCarro();
        }

        if(carrosEstacionados() < 10) {
            carros.add(carro);
        }
    }

    public int carrosEstacionados() {
        return carros.size();
    }

    public boolean carroEstacionado(Carro carro) {
        return carros.contains(carro);
    }

    private void removeCarro() {
        carros.remove(carros.stream()
                            .filter(motorista -> motorista.getMotorista().getIdade() < 55)
                            .findFirst()
                            .orElseThrow(() -> new EstacionamentoException("O estacionamento está lotado.")));
    }
}
