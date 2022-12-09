package br.com.burguerqueen.controllers.dados;

import br.com.burguerqueen.classes.Notificacao;
import br.com.burguerqueen.classes.Produto;
import br.com.burguerqueen.controllers.ControllerMethod;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.List;

public class TelaInicialController {

    @FXML
    private Label CampoNomeUsuario;

    @FXML
    private Label QtdBebida;

    @FXML
    private Label QtdSuco;

    @FXML
    private Label QtdLanche;

    @FXML
    private Label QtdSalgado;

    private int qtdBebida = 0;
    private int qtdSuco = 0;
    private int qtdLanche = 0;
    private int qtdSalgado = 0;

    @FXML
    private Font x1;

    @FXML
    private Font x11;

    @FXML
    private Font x111;

    @FXML
    private Font x112;

    @FXML
    private Font x1121;

    @FXML
    private Font x3;

    @FXML
    private Color x4;

    public static String nomeUsuario;

    private List<Produto> ListaProduto = new ArrayList<>();

    @FXML
    void initialize() {
        assert CampoNomeUsuario != null : "fx:id=\"CampoNomeUsuario\" was not injected: check your FXML file 'telainicial.fxml'.";
        assert QtdBebida != null : "fx:id=\"QtdBebida\" was not injected: check your FXML file 'telainicial.fxml'.";
        assert QtdLanche != null : "fx:id=\"QtdLanche\" was not injected: check your FXML file 'telainicial.fxml'.";
        assert QtdSalgado != null : "fx:id=\"QtdSalgado\" was not injected: check your FXML file 'telainicial.fxml'.";
        assert QtdSuco != null : "fx:id=\"QtdSuco\" was not injected: check your FXML file 'telainicial.fxml'.";
        assert x1 != null : "fx:id=\"x1\" was not injected: check your FXML file 'telainicial.fxml'.";
        assert x11 != null : "fx:id=\"x11\" was not injected: check your FXML file 'telainicial.fxml'.";
        assert x111 != null : "fx:id=\"x111\" was not injected: check your FXML file 'telainicial.fxml'.";
        assert x112 != null : "fx:id=\"x112\" was not injected: check your FXML file 'telainicial.fxml'.";
        assert x1121 != null : "fx:id=\"x1121\" was not injected: check your FXML file 'telainicial.fxml'.";
        assert x3 != null : "fx:id=\"x3\" was not injected: check your FXML file 'telainicial.fxml'.";
        assert x4 != null : "fx:id=\"x4\" was not injected: check your FXML file 'telainicial.fxml'.";
        CampoNomeUsuario.setText(nomeUsuario);
    }

    @FXML
    void FazerPedido(ActionEvent event) {
        if (ListaProduto.isEmpty()) {
            Notificacao.mostraNotificacao("Pedido", "Faça um pedido!", "Antes de prosseguir, faça um pedido que está " +
                            "listado no cardápio.",
                    Alert.AlertType.INFORMATION);
            return;
        }
        PedidoController.nomeUsuario = nomeUsuario;
        PedidoController.InstanciarPreco(ListaProduto);
        ControllerMethod.changeScene(event, "dados/pedido.fxml");
    }

    @FXML
    void BotaoTelaIncial(ActionEvent event) {
        ControllerMethod.changeScene(event, "dados/inicial.fxml");
    }

    @FXML
    void BotaoAddLanche(ActionEvent event) {
        ListaProduto.add(Produto.BuscarProduto(4));
        qtdLanche += 1;
        atualizaQuantidade(QtdLanche, qtdLanche);
    }

    @FXML
    void BotaoRemLanche(ActionEvent event) {
        if (qtdLanche == 0) {
            return;
        }
        qtdLanche -= 1;
        remover(4, QtdLanche, qtdLanche);
    }

    @FXML
    void BotaoAddSalgado(ActionEvent event) {
        ListaProduto.add(Produto.BuscarProduto(3));
        qtdSalgado += 1;
        atualizaQuantidade(QtdSalgado, qtdSalgado);
    }

    @FXML
    void BotaoRemSalgado(ActionEvent event) {
        if (qtdSalgado == 0) {
            return;
        }
        qtdSalgado -= 1;
        remover(3, QtdSalgado, qtdSalgado);
    }

    @FXML
    void BotaoAddSuco(ActionEvent event) {
        ListaProduto.add(Produto.BuscarProduto(2));
        qtdSuco += 1;
        atualizaQuantidade(QtdSuco, qtdSuco);
    }

    @FXML
    void BotaoRemSuco(ActionEvent event) {
        if (qtdSuco == 0) {
            return;
        }
        qtdSuco -= 1;
        remover(2, QtdSuco, qtdSuco);
    }

    @FXML
    void BotaoAddBebida(ActionEvent event) {
        ListaProduto.add(Produto.BuscarProduto(1));
        qtdBebida += 1;
        atualizaQuantidade(QtdBebida, qtdBebida);
    }

    @FXML
    void BotaoRemBebida(ActionEvent event) {
        if (qtdBebida == 0) {
            return;
        }
        qtdBebida -= 1;
        remover(1, QtdBebida, qtdBebida);
    }

    void remover (int id, Label l, int q) {
        ListaProduto.removeIf(p -> p.getId() == id);
        atualizaQuantidade(l, q);
    }

    void atualizaQuantidade (Label l, int q) {
        l.setText("Quantidade: " + q);
    }

    public static void setNomeUsuario(String n) {
        nomeUsuario = n;
    }
}
