package br.com.burguerqueen.controllers.dados;

import br.com.burguerqueen.Main;
import br.com.burguerqueen.classes.Notificacao;
import br.com.burguerqueen.classes.Usuario;
import br.com.burguerqueen.controllers.ControllerMethod;
import com.gluonhq.charm.glisten.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;

public class LoginController {
    @FXML
    private PasswordField CampoSenha;

    @FXML
    private TextField CampoUsuario;

    @FXML
    void BotaoFazerLogin(ActionEvent event) {
        String us = CampoUsuario.getText();
        String senha = CampoSenha.getText();

        if(us.trim().equals("")||senha.trim().equals("")) {
            Notificacao.mostraNotificacao("Login", "Os valores não foram inseridos", "Os valores dos campos acima " +
                    "não foram preenchidos corretamente.", Alert.AlertType.WARNING);
            return;
        }

        Usuario.login_usuario(event, us, senha);
    }

    @FXML
    void LabelFazerCadastro(MouseEvent event) {
        ControllerMethod.changeScene(event, "dados/cadastro.fxml");
    }
}
