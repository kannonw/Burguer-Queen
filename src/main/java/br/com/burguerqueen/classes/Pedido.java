package br.com.burguerqueen.classes;

import br.com.burguerqueen.DB.Conexao;
import javafx.scene.control.Alert;

import javax.crypto.AEADBadTagException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Pedido {
    private String endereco;
    private String telefone;
    private String nomeUsuario;
    private String codigoRetirada;
    private Float valorTotal;

    public Pedido(String endereco, String telefone, String nomeUsuario, String codigoRetirada, Float valorTotal) {
        this.endereco = endereco;
        this.telefone = telefone;
        this.nomeUsuario = nomeUsuario;
        this.codigoRetirada = codigoRetirada;
        this.valorTotal = valorTotal;
    }

    public static Boolean PedidoBD(Pedido p) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = Conexao.conectaBD();

            pstmt = conn.prepareStatement("insert into pedido values (null,?,?,?,?,?)");
            pstmt.setString(1,p.codigoRetirada);
            pstmt.setString(2,p.nomeUsuario);
            pstmt.setString(3,p.endereco);
            pstmt.setString(4,p.telefone);
            pstmt.setFloat(5,p.valorTotal);
            pstmt.execute();

            return true;
        } catch (Exception e) {
            Notificacao.mostraNotificacao("Pedido", "Pedido não pode ser realizado", "Falha ao enviar o relatório ao " +
                    "servidor!", Alert.AlertType.ERROR);
        }
        return false;
    }

    public static Boolean AtendimentoBD(String tempo, String estado, String recomendaria, String sugestoes) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = Conexao.conectaBD();

            pstmt = conn.prepareStatement("insert into atendimento values (null,?,?,?,?)");
            pstmt.setString(1,tempo);
            pstmt.setString(2,estado);
            pstmt.setString(3,recomendaria);
            pstmt.setString(4,sugestoes);
            pstmt.execute();

            Notificacao.mostraNotificacao("Atendimento", "Formulário enviado com sucesso", "O formulário foi enviado " +
                    "ao nosso servidor, somos gratos pela sua cooperação!", Alert.AlertType.CONFIRMATION);

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Notificacao.mostraNotificacao("Atendimento", "Erro ao enviar o formulário", "Não foi possível o envio do " +
                    "formulário ao nosso servidor, tente novamente.", Alert.AlertType.ERROR);
        }
        return false;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public String getCodigoRetirada() {
        return codigoRetirada;
    }

    public Float getValorTotal() {
        return valorTotal;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public void setCodigoRetirada(String codigoRetirada) {
        this.codigoRetirada = codigoRetirada;
    }

    public void setValorTotal(Float valorTotal) {
        this.valorTotal = valorTotal;
    }
}