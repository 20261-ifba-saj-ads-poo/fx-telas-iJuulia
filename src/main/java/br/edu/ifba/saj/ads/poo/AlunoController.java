package br.edu.ifba.saj.ads.poo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.TextField;

public class AlunoController {
    @FXML
    private AnchorPane pane;

    @FXML
    private TextField txNome;

    @FXML
    void goToCadProfessores(ActionEvent event) {

    }

    @FXML
    void goToCadTurmas(ActionEvent event) {
         try {
            pane.(FXMLLoader.load(getClass().getResource("Filme.fxml")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void salvar(ActionEvent event) {

    }

}
