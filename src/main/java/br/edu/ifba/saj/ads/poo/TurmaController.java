package br.edu.ifba.saj.ads.poo;

import java.io.IOException;

import br.edu.ifba.saj.ads.poo.data.Escola;
import br.edu.ifba.saj.ads.poo.model.Professor;
import br.edu.ifba.saj.ads.poo.model.Turma;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class TurmaController {

    @FXML
    private ChoiceBox<Professor> cbProfessor;

    @FXML
    private TableColumn<Turma, String> clmAlunos;

    @FXML
    private TableColumn<Turma, String> clmNome;

    @FXML
    private TableColumn<Turma, String> clmProfessor;

    @FXML
    private TableView<Turma> tbTurmas;

    @FXML
    private TextField txNome;

	@FXML
	private AnchorPane pane;

	private Professor professorSelecionado;

	@FXML
	private void initialize() {
		clmNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        clmProfessor.setCellValueFactory(new PropertyValueFactory<>("nomeProfessores"));
        clmAlunos.setCellValueFactory(new PropertyValueFactory<>("nomeAlunos"));

		cbProfessor.getItems().addAll(Escola.professores);
        cbProfessor.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                professorSelecionado = newValue;
            }
		});
	}

	public void loadTurmasList() {
        tbTurmas.setItems(FXCollections.observableList(Escola.turmas));
    }

    @FXML
    void salvar(ActionEvent event) {
		 if (!txNome.getText().isBlank() && cbProfessor.getValue() != null) {
            Turma novaTurma = new Turma(txNome.getText());
            novaTurma.addProfessor(professorSelecionado);
            Escola.turmas.add(novaTurma);
            new Alert(AlertType.INFORMATION, String.format("Turma de %s cadastrada", novaTurma.getNome()))
                    .showAndWait();
		}
        loadTurmasList();
    }

    @FXML
    void goToCadProfessores(ActionEvent event) {
		try {
            App.setRoot("Professores");
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
