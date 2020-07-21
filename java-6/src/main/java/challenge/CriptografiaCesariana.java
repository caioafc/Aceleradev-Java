package challenge;

public class CriptografiaCesariana implements Criptografia {

    @Override
    public String criptografar(String texto) {
        return converter(texto, 3, 26);
    }

    @Override
    public String descriptografar(String texto) {
        return converter(texto, -3,-26);
    }

    @Override
    public String converter(String texto, int cifra_indexador, int cifra_indexador_final) {

        String novoTexto = "";
        int novo_ascii = 0;
        String lowerTexto = texto.toLowerCase();


        if (texto.isEmpty()) {
            throw new IllegalArgumentException();
        }

        else {
            for (int i = 0; i < lowerTexto.length(); i++) {
                int valorAtual = lowerTexto.charAt(i);

                if (valorAtual >= 97 && valorAtual <= 122) {      //caracteres a-z
                    novo_ascii = valorAtual + cifra_indexador;

                    if(novo_ascii > 122 || novo_ascii < 97) {     //Limitando Caracteres ASCII - Tratando (a,b,c - 3) e (x,y,z + 3)
                        novo_ascii -= cifra_indexador_final;
                    }
                }

                else { novo_ascii = valorAtual; } //Espaços, numeros e caracteres especiais

                novoTexto = novoTexto + (char) novo_ascii;
             }
            return novoTexto;
        }
    }
}

