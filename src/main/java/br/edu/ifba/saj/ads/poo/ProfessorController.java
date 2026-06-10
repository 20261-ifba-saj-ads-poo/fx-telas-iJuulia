package br.edu.ifba.saj.ads.poo;

import java.io.IOException;

import br.edu.ifba.saj.ads.poo.data.Escola;
import br.edu.ifba.saj.ads.poo.model.Professor;
import br.edu.ifba.saj.ads.poo.model.Turma;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class ProfessorController {
    @FXML
    private TextField txNome;

    @FXML
    private ChoiceBox<Turma> cbTurma;

    private Turma turmaSelecionada;

    @FXML
    private void initialize() {
		cbTurma.getItems().addAll(Escola.turmas);
        cbTurma.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                turmaSelecionada = newValue;
            }
		});
	}

    @FXML
    void goToCadAlunos(ActionEvent event) {
        try {
            App.setRoot("Aluno");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    @FXML
    void goToCadTurmas(ActionEvent event) {
        try {
            App.setRoot("Turma");
         } catch (IOException e) {
            e.printStackTrace();
         }
    }

    @FXML
    void salvar(ActionEvent event) {
        if (!txNome.getText().isBlank()) {
            Professor novoProfessor = new Professor(txNome.getText());
            Escola.professores.add(novoProfessor);
            if (cbTurma.getValue() != null) {
                novoProfessor.addTurma(turmaSelecionada);
            }
            new Alert(AlertType.INFORMATION, String.format("Professor %s cadastrado", novoProfessor.getNome()))
                    .showAndWait();
		}
    }
}
