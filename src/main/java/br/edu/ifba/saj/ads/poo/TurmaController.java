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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class TurmaController {

    @FXML
    private ChoiceBox<Professor> cbProfessor;

    @FXML
    private ChoiceBox<Aluno> cbAlunos;

    @FXML
    private TextField txNome;

	private Professor professorSelecionado;
	// private Professor alunosSelecionado;

	@FXML
	private void initialize() {
		cbProfessor.getItems().addAll(Escola.professores);
        cbProfessor.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                professorSelecionado = newValue;
            }
		});

		// cbAlunos.getItems().addAll(Escola.alunos);
        // cbAlunos.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
        //     if (newValue != null) {
        //         professorSelecionado = newValue;
        //     }
		// });
	}

    @FXML
    void salvar(ActionEvent event) {
		if (!txNome.getText().isBlank()) {
            Turma novaTurma = new Turma(txNome.getText());
            Escola.turmas.add(novaTurma);
            if (cbProfessor.getValue() != null) {
                novaTurma.addProfessor(professorSelecionado);
            }
            new Alert(AlertType.INFORMATION, String.format("Turma de %s cadastrada", novaTurma.getNome()))
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
