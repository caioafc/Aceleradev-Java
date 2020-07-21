package challenge;

public interface Criptografia {

    String criptografar(String texto);

    String descriptografar(String texto);

    String converter(String texto, int cifra_indexador, int cifra_indexador_final);
}
