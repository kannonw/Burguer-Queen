package br.com.burguerqueen.controllers.dados;

import br.com.burguerqueen.Main;
import br.com.burguerqueen.controllers.ControllerMethod;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class InicialController {

    @FXML
    private Label LabelAtendimento;

    @FXML
    private Label LabelTrabalhe;


    @FXML
    private Font x1;

    @FXML
    private Font x3;

    @FXML
    private Color x4;

    @FXML
    void fazerPedido(ActionEvent event) {
        ControllerMethod.changeScene(event,"dados/telainicial.fxml");
    }

    @FXML
    void ClickLabelAtendimento(MouseEvent event) {
        ControllerMethod.changeScene(event, "dados/atendimento.fxml");
    }

    @FXML
    void ClickLabelTrabalhe(MouseEvent event) {
        ControllerMethod.changeScene(event, "dados/cadastrotrabalho.fxml");
    }

    @FXML
    void BotaoSair(ActionEvent event) {
        ControllerMethod.changeScene(event, "dados/login.fxml");
    }

}
