package br.com.burguerqueen.classes;

import br.com.burguerqueen.DB.Conexao;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class Funcionario {

    private String nome;
    private Date dataNasc;
    private String cpf;
    private String cep;
    private String email;

    public Funcionario(String nome, Date dataNasc, String cpf, String cep, String email) {
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.cpf = cpf;
        this.cep = cep;
        this.email = email;
    }

    public static Boolean CadastrarCandidato(Funcionario f) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = Conexao.conectaBD();

            pstmt = conn.prepareStatement("insert into candidatos values (null,?,?,?,?,?)");
            pstmt.setDate(1,f.getDataNasc());
            pstmt.setString(2,f.getNome());
            pstmt.setString(3,f.getCpf());
            pstmt.setString(4,f.getCep());
            pstmt.setString(5,f.getEmail());
            pstmt.execute();

            Notificacao.mostraNotificacao("Cadastro", "Cadastro realizado com sucesso", "O seu formulário foi enviado" +
                    " ao nosso servidor!", Alert.AlertType.CONFIRMATION);

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
         Notificacao.mostraNotificacao("Cadastro", "Erro ao enviar o formulário", "Ocorreu um erro ao enviar o seu " +
                 "formulário ao nosso servidor.", Alert.AlertType.ERROR);
        }
        return false;
    }

    public String getNome() {
        return nome;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public String getCpf() {
        return cpf;
    }

    public String getCep() {
        return cep;
    }

    public String getEmail() {
        return email;
    }
}
