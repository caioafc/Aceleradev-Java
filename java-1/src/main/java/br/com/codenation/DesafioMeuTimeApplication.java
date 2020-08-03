package br.com.codenation;

import br.com.codenation.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.exceptions.TimeNaoEncontradoException;
import br.com.codenation.models.Jogador;
import br.com.codenation.models.Time;
import br.com.codenation.exceptions.IdentificadorUtilizadoException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class DesafioMeuTimeApplication implements MeuTimeInterface {

	private final List<Time> times = new ArrayList<>();

	private final List<Jogador> jogadores = new ArrayList<>();

	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
		if (buscarTimes().contains(id)) {
			throw new IdentificadorUtilizadoException();

		} else {
			Time time = new Time(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario);
			time.setId(id);
			time.setNome(nome);
			time.setDataCriacao(dataCriacao);
			time.setCorUniformePrincipal(corUniformePrincipal);
			time.setCorUniformeSecundario(corUniformeSecundario);
			times.add(time);
		}
	}

	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
		if (buscarJogadores().contains(id)) {
			throw new IdentificadorUtilizadoException();

		} else if (!buscarTimes().contains(idTime)){
			throw new TimeNaoEncontradoException();

		} else {
			Jogador jogador = new Jogador(id, idTime, nome, dataNascimento, nivelHabilidade, salario);
			jogador.setId(id);
			jogador.setIdTime(idTime);
			jogador.setNome(nome);
			jogador.setDataNascimento(dataNascimento);
			jogador.setNivelHabilidade(nivelHabilidade);
			jogador.setSalario(salario);
			jogadores.add(jogador);
		}
	}

	private Boolean verificaCapitaoPorJogador(Long idJogador) {
		return jogadores.stream()
				.filter(jogador -> jogador.getIdTime().equals(idJogador))
				.map(Jogador::getCapitao)
				.collect(Collectors.toList())
				.contains(true);
	}

	private Boolean verificaCapitaoPorTime (Long idTime) {
		return jogadores.stream()
				.filter(jogador -> jogador.getIdTime().equals(idTime))
				.map(Jogador::getCapitao)
				.collect(Collectors.toList())
				.contains(true);
	}

	public void definirCapitao(Long idJogador) {
		if (!buscarJogadores().contains(idJogador)) {
			throw new JogadorNaoEncontradoException();

		} else {
			if (verificaCapitaoPorJogador(idJogador)) {
				jogadores.forEach(jogador -> jogador.setCapitao(false));
			}

			jogadores.stream()
					.filter(jogador -> jogador.getId().equals(idJogador))
					.findFirst()
					.orElseThrow(JogadorNaoEncontradoException::new)
					.setCapitao(true);
		}
	}

	public Long buscarCapitaoDoTime(Long idTime) {
		if (!buscarTimes().contains(idTime)) {
			throw new TimeNaoEncontradoException();

		} else if (!verificaCapitaoPorTime(idTime)) {
			throw new CapitaoNaoInformadoException();

		} else {
			return jogadores.stream()
					.filter(jogador -> jogador.getIdTime().equals(idTime) && jogador.getCapitao().equals(true))
					.findFirst()
					.orElseThrow(CapitaoNaoInformadoException::new)
					.getId();
		}
	}

	public String buscarNomeJogador(Long idJogador) {
		if (!buscarJogadores().contains(idJogador)) {
			throw new JogadorNaoEncontradoException();

		} else {
			return  jogadores.stream()
					.filter(jogador -> jogador.getId().equals(idJogador))
					.map(Jogador::getNome)
					.collect(Collectors.joining());
		}
	}

	public String buscarNomeTime(Long idTime) {
		if (!buscarTimes().contains(idTime)) {
			throw new TimeNaoEncontradoException();

		} else {
			return times.stream()
					.filter(time -> time.getId().equals(idTime))
					.map(Time::getNome)
					.collect(Collectors.joining());
		}
	}

	public List<Long> buscarJogadoresDoTime(Long idTime) {
		if (!buscarTimes().contains(idTime)) {
			throw new TimeNaoEncontradoException();

		} else {
			return jogadores.stream()
					.filter(jogador -> jogador.getIdTime().equals(idTime))
					.map(Jogador::getId)
					.collect(Collectors.toList());
		}
	}

	public Long buscarMelhorJogadorDoTime(Long idTime) {
		if (!buscarTimes().contains(idTime)) {
			throw new TimeNaoEncontradoException();

		} else {
			return jogadores.stream()
					.filter(jogador -> jogador.getIdTime().equals(idTime))
					.max(Comparator.comparingInt(Jogador::getNivelHabilidade))
					.orElseThrow(NullPointerException::new)
					.getId();
		}
	}

	public Long buscarJogadorMaisVelho(Long idTime) {
		if (!buscarTimes().contains(idTime)) {
			throw new TimeNaoEncontradoException();

		} else {
			return jogadores.stream()
					.filter(jogador -> jogador.getIdTime().equals(idTime))
					.min(Comparator.comparing(Jogador::getDataNascimento))
					.orElseThrow(NullPointerException::new)
					.getId();
		}
	}

	public List<Long> buscarTimes() {
		return times.stream()
				.map(Time::getId)
				.collect(Collectors.toList());
	}

	public List<Long> buscarJogadores() {
		return jogadores.stream()
				.map(Jogador::getId)
				.collect(Collectors.toList());
	}

	public Long buscarJogadorMaiorSalario(Long idTime) {
		if (!buscarTimes().contains(idTime)) {
			throw new TimeNaoEncontradoException();

		} else {
			return jogadores.stream()
					.filter(jogador -> jogador.getIdTime().equals(idTime))
					.max(Comparator.comparing(Jogador::getSalario))
					te.orElseThrow(NullPointerException::new)
					.getId();
		}
	}

	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
		if(!buscarJogadores().contains(idJogador)) {
			throw new JogadorNaoEncontradoException();

		} else {
			return  jogadores.stream()
					 .filter(jogador -> jogador.getId().equals(idJogador))
					 .map(Jogador::getSalario)
					 .findFirst()
					 .orElseThrow(NullPointerException::new)
					 .abs();
		}
	}

	public List<Long> buscarTopJogadores(Integer top) {
		return jogadores.stream()
				.sorted(Comparator.comparing(Jogador::getNivelHabilidade).reversed())
				.limit(top)
				.map(Jogador::getId)
				.collect(Collectors.toList());
	}
}
