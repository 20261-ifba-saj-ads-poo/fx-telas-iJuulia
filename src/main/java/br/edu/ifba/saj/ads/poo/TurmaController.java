package br.edu.ifba.saj.ads.poo;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;

import br.edu.ifba.saj.ads.poo.data.Cinema;
import br.edu.ifba.saj.ads.poo.model.Filme;
import javafx.collections.FXCollections;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class TurmaController {

    @FXML
    private ChoiceBox<Professor> cbProfessor;

    @FXML
    private TableColumn<Aluno, String> clmAlunos;

    @FXML
    private TableColumn<Turma, String> clmNome;

    @FXML
    private TableColumn<Professor, String> clmProfessor;

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
        clmProfessor.setCellValueFactory(new PropertyValueFactory<>("nome"));
        clmAlunos.setCellValueFactory(new PropertyValueFactory<>("nome"));

		cbProfessor.getItems().addAll(Escola.turmas);
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
		 if ((Objects.nonNull(txNome.getText())
                && !txNome.getText().isEmpty())
                &&
                (Objects.nonNull(cbProfessor.getSelectionModel().getSelectedItem())
                        && !txNome.getText().isEmpty()
                        && !txNome.getText().isEmpty())) {
            Turma novaTurma = new Turma(txNome.getText());
            Escola.turmas.add(novaTurma);
            new Alert(AlertType.INFORMATION, String.format("Nova turma %s cadastrada", novaTurma.getNome()))
                    .showAndWait();
		}
    }

    @FXML
    void goToCadProfessores(ActionEvent event) {
		System.out.println("Indo para cadastro de professores");
    }

	@FXML
    void goToCadAlunos(ActionEvent event) {
		System.out.println("Indo para cadastro de alunos");
		pane.

    }

}
