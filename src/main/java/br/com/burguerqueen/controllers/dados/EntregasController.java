package br.com.burguerqueen.controllers.dados;

import br.com.burguerqueen.classes.Notificacao;
import br.com.burguerqueen.classes.Pedido;
import br.com.burguerqueen.controllers.ControllerMethod;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.util.Random;

public class EntregasController {

    @FXML
    private TextField CampoEndereco;

    @FXML
    private TextField CampoTelefone;

    private String CodigoRetirada = "";

    public static Pedido pedido;

    @FXML
    void BotaoRetirada(ActionEvent event) {
        Notificacao.mostraNotificacao("Código", "Código de retirada", "O seu código de retirada é " + CodigoRetirada,
                Alert.AlertType.CONFIRMATION);
    }

    @FXML
    void BotaoSeguirPagamento(ActionEvent event) {
        if (CampoEndereco.getText().trim().equals("")||CampoTelefone.getText().trim().equals("")) {
            Notificacao.mostraNotificacao("Pedido", "Informações inválidas", "Os dados não foram preenchidos " +
                    "corretamente.", Alert.AlertType.WARNING);
            return;
        }

        pedido.setCodigoRetirada(CodigoRetirada);
        pedido.setEndereco(CampoEndereco.getText());
        pedido.setTelefone(CampoTelefone.getText());
        PagamentoController.pedido = pedido;
        ControllerMethod.changeScene(event, "dados/pagamento.fxml");
    }

    @FXML
    void initialize() {
        assert CampoEndereco != null : "fx:id=\"CampoEndereco\" was not injected: check your FXML file 'entregas.fxml'.";
        assert CampoTelefone != null : "fx:id=\"CampoTelefone\" was not injected: check your FXML file 'entregas.fxml'.";
        Random rdm = new Random();
        CodigoRetirada = String.format("%04d", rdm.nextInt(9999));
    }

}
