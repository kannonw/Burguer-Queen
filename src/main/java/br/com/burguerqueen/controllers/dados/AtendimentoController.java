package br.com.burguerqueen.controllers.dados;

import br.com.burguerqueen.classes.Pedido;
import br.com.burguerqueen.controllers.ControllerMethod;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.PseudoColumnUsage;

public class AtendimentoController {

    @FXML
    private TextField CampoEstado;

    @FXML
    private TextField CampoServico;

    @FXML
    private TextField CampoSugestao;

    @FXML
    private TextField CampoTempo;

    @FXML
    void BotaoEnviar(ActionEvent event) {
        String tempo = CampoTempo.getText();
        String estado = CampoEstado.getText();
        String servico = CampoServico.getText();
        String sugestao = CampoSugestao.getText();

        if (!Pedido.AtendimentoBD(tempo, estado, servico, sugestao)) {
            return;
        }

        ControllerMethod.changeScene(event,"dados/inicial.fxml");
    }

    @FXML
    void BotaoVoltar(ActionEvent event) {
        ControllerMethod.changeScene(event, "dados/inicial.fxml");
    }

}
