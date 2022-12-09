package br.com.burguerqueen.controllers.dados;

import br.com.burguerqueen.classes.Pedido;
import br.com.burguerqueen.classes.Produto;
import br.com.burguerqueen.controllers.ControllerMethod;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import java.util.List;

public class PedidoController {
    @FXML
    private Text CampoPreco;

    private static Float preco = 0f;

    public static String nomeUsuario;

    @FXML
    void BotaoSeguir(ActionEvent event) {
        EntregasController.pedido = new Pedido(null, null, nomeUsuario, null, preco);
        ControllerMethod.changeScene(event, "dados/entregas.fxml");
    }

    @FXML
    void BotaoVoltar(ActionEvent event) {
        preco = 0f;
        ControllerMethod.changeScene(event, "dados/telainicial.fxml");
    }

    public static void InstanciarPreco(List<Produto> p) {
        try {
            for (Produto pro:p) {
                preco += pro.getPreco();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void initialize() {
        assert CampoPreco != null : "fx:id=\"CampoPreco\" was not injected: check your FXML file 'pedido.fxml'.";
        CampoPreco.setText(String.format("R$%.2f", preco));
    }
}
