package challenge;


import java.util.Objects;

public class Motorista {

    private final String nome;

    private final int idade;

    private final int pontos;

    private final String habilitacao;

    private Motorista(String nome, int idade, int pontos, String habilitacao) {
        validaIdade(idade);
        validaPontos(pontos);
        this.nome = nome;
        this.idade = idade;
        this.pontos = pontos;
        this.habilitacao = habilitacao;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public int getPontos() {
        return pontos;
    }

    public String getHabilitacao() {
        return habilitacao;
    }

    private void validaIdade(int idade) {
        if (idade < 18) {
            throw new EstacionamentoException("O motorista não possui idade suficiente para dirigir.");
        }
    }

    private void validaPontos(int pontos) {
        if (pontos > 20) {
            throw new EstacionamentoException("A carteira do motorista está suspensa.");
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Motorista motorista = (Motorista) o;
        return Objects.equals(habilitacao, motorista.habilitacao);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(habilitacao);
    }

    @Override
    public String toString() {
        return "Motorista{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", pontos=" + pontos +
                ", habilitacao='" + habilitacao + '\'' +
                '}';
    }

    public static MotoristaBuilder builder() {
        return new MotoristaBuilder();
    }


    public static class MotoristaBuilder {

        private String nome;

        private int idade;

        private int pontos;

        private String habilitacao;

        private MotoristaBuilder() {
        }

        public MotoristaBuilder withNome(String nome) {
            this.nome = nome;
            validaCampoNome();
            return this;
        }

        public MotoristaBuilder withIdade(int idade) {
            this.idade = idade;
            validaCampoIdade();
            return this;
        }

        public MotoristaBuilder withPontos(int pontos) {
            this.pontos = pontos;
            validaCampoPontos();
            return this;
        }

        public MotoristaBuilder withHabilitacao(String habilitacao) {
            this.habilitacao = habilitacao;
            validaCampoHabilitacao();
            return this;
        }

        public Motorista build() {
            validaExistenciaCampos();
            return new Motorista(nome, idade, pontos, habilitacao);
        }

        private void validaCampoHabilitacao() {
            if (this.habilitacao == null) {
                throw new NullPointerException("É necessário preencher o campo habilitação.");
            }
        }

        private void validaCampoPontos() {
            if (this.pontos < 0) {
                throw new IllegalArgumentException("O valor preenchido no campo pontuação não é válido.");
            }
        }

        private void validaCampoNome() {
            if (this.nome == null) {
                throw new NullPointerException("É necessário preencher o campo nome.");
            }
        }

        private void validaCampoIdade() {
            if (this.idade < 0) {
                throw new IllegalArgumentException("O valor preenchido no campo idade não é válido.");
            }
        }

        private void validaExistenciaCampos() {
            validaCampoNome();
            validaCampoHabilitacao();
        }
    }
}
