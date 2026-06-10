package br.edu.ifba.saj.ads.poo.model;

import java.util.ArrayList;
import java.util.List;

public class Turma {
	private final String nome;
	private final List<Professor> professores;
	private final List<Aluno> alunos;

    public Turma(String nome) {
		this.nome = nome;
		this.alunos = new ArrayList<>();
		this.professores = new ArrayList<>();
	}

	public String getNome() {
        return nome;
    }

    public List<Professor> getProfessores() {
        return List.copyOf(professores);
    }

    public List<Aluno> getAlunos() {
        return List.copyOf(alunos);
    }

	public void addProfessor(Professor professor) {
		if (!professores.contains(professor)) professores.add(professor);
		if (!professor.getTurmas().contains(this)) professor.addTurma(this);
	}

	public void addAluno(Aluno aluno) {
		if (!alunos.contains(aluno)) alunos.add(aluno);
		if (!aluno.getTurmas().contains(this)) aluno.addTurma(this);
	}

	public void removeProfessor(Professor professor) {
		if (professores.contains(professor)) professores.remove(professor);
		if (professor.getTurmas().contains(this)) professor.removeTurma(this);
	}

	public void removeAluno(Aluno aluno) {
		if (alunos.contains(aluno)) alunos.remove(aluno);
		if (aluno.getTurmas().contains(this)) aluno.removeTurma(this);
	}

	public String getNomeProfessores() {
		return professores.stream()
            .map(Professor::getNome)
            .reduce((a, b) -> a + ", " + b)
            .orElse("");
	}

	public String getNomeAlunos() {
		return alunos.stream()
            .map(Aluno::getNome)
            .reduce((a, b) -> a + ", " + b)
            .orElse("");
	}
}
