package br.edu.ifba.saj.ads.poo.model;

import java.util.ArrayList;
import java.util.List;

public class Professor {
	private final String nome;
	private final List<Turma> turmas;

	public Professor(String nome) {
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
		if (!turma.getProfessores().contains(this)) turma.addProfessor(this);
	}

	public void removeTurma(Turma turma) {
		if (turmas.contains(turma)) turmas.remove(turma);
		if (turma.getProfessores().contains(this)) turma.removeProfessor(this);
	}

	public String listarTurmas() {
		String lista = "Turmas lecionadas por " + nome + ": ";

		if (turmas.isEmpty()) {
			lista += "Sem turmas";
			return lista;
		}

		for (Turma t : this.turmas) {
			lista += t.getNome() + "; ";
		}

		return lista;
	}

	@Override
	public String toString() {
		return nome;
	}
}