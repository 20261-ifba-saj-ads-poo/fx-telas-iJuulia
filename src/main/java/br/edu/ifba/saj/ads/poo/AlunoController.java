package br.edu.ifba.saj.ads.poo;

import java.io.IOException;

import br.edu.ifba.saj.ads.poo.data.Escola;
import br.edu.ifba.saj.ads.poo.model.Aluno;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AlunoController {
    @FXML
    private TextField txNome;

    @FXML
    void goToCadProfessores(ActionEvent event) {
        try {
            App.setRoot("Professor");
            System.out.println("Tela carregada");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    @FXML
    void goToCadTurmas(ActionEvent event) {
        System.out.println(getClass().getResource("Turma.fxml"));
        try {
            App.setRoot("Turma");
         } catch (IOException e) {
            e.printStackTrace();
         }
    }

    @FXML
    void salvar(ActionEvent event) {
        Aluno novoAluno = new Aluno(txNome.getText());
        Escola.alunos.add(novoAluno);
    }

}
