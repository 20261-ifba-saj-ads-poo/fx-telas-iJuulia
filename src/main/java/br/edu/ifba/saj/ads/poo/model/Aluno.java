package br.edu.ifba.saj.ads.poo.model;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
	private final String nome;
	private final List<Turma> turmas;

    public Aluno(String nome) {
		this.nome = nome;
		this.turmas = new ArrayList<>();
	}

	public String getNome() {
        return nome;
    }

    public List<Turma> getTurmas() {
        return List.copyOf(turmas);
    }

	public void addTurma(Turma turma) {
		if (!turmas.contains(turma)) turmas.add(turma);
		if (!turma.getAlunos().contains(this)) turma.addAluno(this);
	}

	public void removeTurma(Turma turma) {
		if (turmas.contains(turma)) turmas.remove(turma);
		if (turma.getAlunos().contains(this)) turma.removeAluno(this);
	}

	public String listarTurmas() {
		if (turmas.isEmpty()) {
			return "";
		} 
		return turmas.get(0).getNome();
	}

	@Override
	public String toString() {
		return nome;
	}

}