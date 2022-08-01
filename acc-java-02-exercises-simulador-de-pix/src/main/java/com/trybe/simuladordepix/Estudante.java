package com.trybe.simuladordepix;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Estudante {

	private String matricula;

	private String nome;

	private String curso;

	public Estudante() {
	}

	public Estudante(String matricula, String nome, String curso) {
		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
	}
	// GETs e SETs

	public Object getCurso() {
		return this.curso;
	}

	public String getNome() {
		return this.nome;
	}

	public Object getMatricula() {
		return this.matricula;
	}
}

class CodeExamples {

	public static Collection<Estudante> obterEntrada() {
		return Set.of(
				new Estudante("2001", "Maria", "Computação"),
				new Estudante("2002", "João", "Computação"),
				new Estudante("2003", "José", "Pedagogia"),
				new Estudante("2004", "Ana", "Computação"),
				new Estudante("2005", "Bernardo", "Engenharia"),
				new Estudante("2006", "Mário", "Computação"));
	}

	public static void main(String[] args) {
		Collection<Estudante> entrada = obterEntrada();
		List<Object> matriculas = entrada.stream()
				.filter(e -> "Computação".equals(e.getCurso()))
				.sorted(Comparator.comparing(Estudante::getNome))
				.map(Estudante::getMatricula)
				.collect(Collectors.toList());
		System.out.println(matriculas);

		Collection<Estudante> entrada2 = obterEntrada();
		Estudante estudanteDeNomeMario = entrada2.stream()
				.filter(e -> "Mário".equals(e.getNome()))
				.findAny()
				.orElse(null);

		System.out.println(
				(estudanteDeNomeMario != null)
						? estudanteDeNomeMario.getNome()
						: "nada");
		System.out.println(
				"só pra saber se não trava o programa quando vem null");

	}

}