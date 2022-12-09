package br.com.burguerqueen.classes;


import br.com.burguerqueen.DB.Conexao;
import br.com.burguerqueen.controllers.ControllerMethod;
import br.com.burguerqueen.controllers.dados.PedidoController;
import br.com.burguerqueen.controllers.dados.TelaInicialController;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import org.jasypt.util.password.BasicPasswordEncryptor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Usuario extends Pessoa {

    public Usuario(String nome, String nome_usuario, String senha, String email) {
        super(nome, nome_usuario, senha, email);
    }

    public static void cadastrar_usuario(Usuario us, String vtsenha) {
        BasicPasswordEncryptor encry = new BasicPasswordEncryptor();
        PreparedStatement pstmt = null;
        Connection conn = null;
        String rsquery = null;

        String query = null;
        ResultSet rs = null;
        try {

            if (!us.getSenha().equals(vtsenha)) {
                Notificacao.mostraNotificacao("Aviso", "Senha incorreta", "As senhas devem ser iguais, tente " +
                        "novamente.", Alert.AlertType.WARNING);
                return;
            }

            conn = Conexao.conectaBD();

            rsquery = String.format("select nome_usuario from usuario where nome_usuario = '%s';",
                    us.getNome_usuario());
            rs = conn.createStatement().executeQuery(rsquery);

            if (rs.next()) {
                Notificacao.mostraNotificacao("Aviso", "Esse usuário já existe", "O nome de usuário digitado já " +
                        "existe, tente um novo nome", Alert.AlertType.INFORMATION);
                return;
            }

            query = "insert into usuario values (null,?,?,?,?);";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, us.getNome());
            pstmt.setString(2, us.getNome_usuario());
            pstmt.setString(3, encry.encryptPassword(us.getSenha()));
            pstmt.setString(4, us.getEmail());
            pstmt.executeUpdate();

            Notificacao.mostraNotificacao("Cadastro", "Sucesso", "Cadastro realizado com sucesso!", Alert.AlertType.CONFIRMATION);
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            Notificacao.mostraNotificacao("Erro", "Erro de conexão", "Houve um erro ao tentar se conectar com o " +
                    "servidor", Alert.AlertType.ERROR);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            Notificacao.mostraNotificacao("Erro", "Erro inesperado", "Ocorreu um erro inesperado durante a execução " +
                    "do programa, tente novamente", Alert.AlertType.ERROR);
        } finally {
            try {
                pstmt.close();
                conn.close();
            }catch (Exception e){
                System.out.println("Erro finally: " + e.getMessage());
            }
        }
    }

    public static void login_usuario(ActionEvent event, String lnome_usuario, String lsenha){
        String query = null;
        String dbPass = null;
        ResultSet rs = null;

        BasicPasswordEncryptor encry = new BasicPasswordEncryptor();
        Connection conn = null;

        try {
            conn = Conexao.conectaBD();

            query = String.format("select senha from usuario where nome_usuario = '%s';", lnome_usuario);
            rs = conn.createStatement().executeQuery(query);

            if (rs.next()) {
                dbPass = rs.getString("senha");
            }

            if (encry.checkPassword(lsenha, dbPass)) {
                TelaInicialController.setNomeUsuario(lnome_usuario);
                ControllerMethod.changeScene(event, "dados/inicial.fxml");
                return;
            }

            Notificacao.mostraNotificacao("Erro", "Erro ao realizar o login", "Usuário ou senha incorretos",
                    Alert.AlertType.WARNING);
        }
        catch (SQLException e) {
            System.out.println("Erro SQL: " + e.getMessage());
        }
        catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            try {
                assert rs != null;
                rs.close();
                conn.close();
            }catch (Exception e){
                System.out.println("Erro finally: " + e.getMessage());
            }
        }
    }
}
