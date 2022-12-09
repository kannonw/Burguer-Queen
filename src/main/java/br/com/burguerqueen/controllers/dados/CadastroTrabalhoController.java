package br.com.burguerqueen.controllers.dados;

import br.com.burguerqueen.classes.Funcionario;
import br.com.burguerqueen.controllers.ControllerMethod;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.Date;

public class CadastroTrabalhoController {

    @FXML
    private PasswordField CampoCep;

    @FXML
    private PasswordField CampoCpf;

    @FXML
    private DatePicker CampoDataNasc;

    @FXML
    private TextField CampoEmail;

    @FXML
    private TextField CampoNome;

    @FXML
    void BotaoCadastro(ActionEvent event) {
        Date data = Date.valueOf(CampoDataNasc.getValue());
        String email = CampoEmail.getText();
        String nome = CampoNome.getText();
        String cpf = CampoCpf.getText();
        String cep = CampoCep.getText();

        Funcionario f = new Funcionario(nome, data, cpf, cep, email);
        System.out.println(f.getDataNasc());

        if (!Funcionario.CadastrarCandidato(f)) {
            return;
        }

        ControllerMethod.changeScene(event, "dados/inicial.fxml");
    }

    @FXML
    void BotaoVoltar(ActionEvent event) {
        ControllerMethod.changeScene(event, "dados/inicial.fxml");
    }

}
