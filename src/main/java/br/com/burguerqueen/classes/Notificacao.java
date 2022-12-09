package br.com.burguerqueen.classes;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Notificacao {

    public static void mostraNotificacao(String titulo, String cabecalho, String mensagem, AlertType tipo){
        Alert notificacao = new Alert(tipo);
        notificacao.setTitle(titulo);
        notificacao.setHeaderText(cabecalho);
        notificacao.setContentText(mensagem);
        notificacao.show();
    }
}
