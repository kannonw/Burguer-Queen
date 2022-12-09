package br.com.burguerqueen.controllers.dados;

import br.com.burguerqueen.Main;
import br.com.burguerqueen.classes.Usuario;
import br.com.burguerqueen.controllers.ControllerMethod;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class CadastroController {
    @FXML
    private PasswordField CampoConfirmarSenha;

    @FXML
    private TextField CampoEmail;

    @FXML
    private TextField CampoNome;

    @FXML
    private PasswordField CampoSenha;

    @FXML
    private TextField CampoUsuario;

    @FXML
    void BotaoCadastro(ActionEvent event) {
        String nome = CampoNome.getText();
        String usuario = CampoUsuario.getText();
        String senha = CampoSenha.getText();
        String email = CampoEmail.getText();

        Usuario objus = new Usuario(nome, usuario, senha, email);

        Usuario.cadastrar_usuario(objus, CampoConfirmarSenha.getText());
    }

    @FXML
    void LabelFazerLogin(MouseEvent event) {
        ControllerMethod.changeScene(event, "dados/login.fxml");
    }

}
