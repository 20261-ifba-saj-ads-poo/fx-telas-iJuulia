package br.edu.ifba.saj.ads.poo;

import java.io.IOException;

import br.edu.ifba.saj.ads.poo.data.Escola;
import br.edu.ifba.saj.ads.poo.model.Aluno;
import br.edu.ifba.saj.ads.poo.model.Professor;
import br.edu.ifba.saj.ads.poo.model.Turma;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class TurmaController {

    @FXML
    private ListView<Professor> lvProfessor;

    @FXML
    private ListView<Aluno> lvAlunos;

    @FXML
    private TextField txNome;

	@FXML
	private void initialize() {
		lvProfessor.getItems().addAll(Escola.professores);
        lvProfessor.getSelectionModel().setSelectionMode(javafx.scene.control.SelectionMode.MULTIPLE);
        lvAlunos.getItems().addAll(Escola.alunos);
        lvAlunos.getSelectionModel().setSelectionMode(javafx.scene.control.SelectionMode.MULTIPLE);
	}

    @FXML
    void salvar(ActionEvent event) {
		if (!txNome.getText().isBlank()) {
            Turma novaTurma = new Turma(txNome.getText());
            Escola.turmas.add(novaTurma);
            if (lvProfessor.getSelectionModel() != null && !lvProfessor.getSelectionModel().getSelectedItems().isEmpty()) {
                for (Professor p : lvProfessor.getSelectionModel().getSelectedItems()) {
                    novaTurma.addProfessor(p);
                }                
            }

            if (lvAlunos.getSelectionModel() != null && !lvAlunos.getSelectionModel().getSelectedItems().isEmpty()) {
                for (Aluno a : lvAlunos.getSelectionModel().getSelectedItems()) {
                    novaTurma.addAluno(a);
                }                
            }
            new Alert(AlertType.INFORMATION, String.format("Turma de %s cadastrada com professores %s", novaTurma.getNome(), novaTurma.getNomeProfessores()))
                    .showAndWait();
		}
    }

    @FXML
    void goToCadProfessores(ActionEvent event) {
		try {
            App.setRoot("Professor");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	@FXML
    void goToCadAlunos(ActionEvent event) {
		try {
            App.setRoot("Aluno");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
