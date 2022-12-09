package br.com.burguerqueen.controllers.dados;

import br.com.burguerqueen.classes.Pedido;
import br.com.burguerqueen.classes.Notificacao;
import br.com.burguerqueen.controllers.ControllerMethod;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;

import java.util.Locale;

public class PagamentoController {

    @FXML
    private TextField CampoCVV;

    @FXML
    private TextField CampoNumCartao;

    @FXML
    private TextField CamppoNomeCartao;

    public static Pedido pedido;

    @FXML
    void BotaoConcluirPedido(ActionEvent event) {
        if (CampoNumCartao.getText().trim().equals("")||CamppoNomeCartao.getText().trim().equals("")||CampoCVV.getText().trim().equals("")) {
            Notificacao.mostraNotificacao("Pedido", "Os valores não foram inseridos!", "Os valores dos campos acima " +
                    "não foram preenchidos corretamente.", Alert.AlertType.WARNING);
            return;
        }

        if (!Pedido.PedidoBD(pedido)) {
            return;
        }

        Notificacao.mostraNotificacao("Pedido", "O pedido foi realizado", "O seu pedido foi enviado com sucesso",
                Alert.AlertType.CONFIRMATION);
        ControllerMethod.changeScene(event, "dados/inicial.fxml");
    }

    @FXML
    void BotaoVoltar(ActionEvent event) {
        ControllerMethod.changeScene(event, "dados/entregas.fxml");
    }

    @FXML
    void CvvDigitado(KeyEvent event) {
        if (CampoCVV.getText().length() > 3) {
            CampoCVV.setText(CampoCVV.getText().substring(0, 2));
        }
    }
}
