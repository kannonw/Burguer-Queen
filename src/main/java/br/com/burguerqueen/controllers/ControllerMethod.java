package br.com.burguerqueen.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ControllerMethod {

    public static FXMLLoader changeScene(ActionEvent event, String url) {
        FXMLLoader fxmlLoader = null;

        try {
            fxmlLoader = new FXMLLoader(ControllerMethod.class.getResource(url));
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();

            stage.setScene(new Scene(fxmlLoader.load()));
            stage.show();

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        return fxmlLoader;
    }

    public static FXMLLoader changeScene(MouseEvent event, String url) {
        FXMLLoader fxmlLoader = null;

        try {
            fxmlLoader = new FXMLLoader(ControllerMethod.class.getResource(url));
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();

            stage.setScene(new Scene(fxmlLoader.load()));
            stage.show();

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        return fxmlLoader;
    }

}