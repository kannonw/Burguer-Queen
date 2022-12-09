package br.com.burguerqueen.classes;

import br.com.burguerqueen.DB.Conexao;

import java.sql.Connection;
import java.sql.ResultSet;

public class Produto {
    private int id;
    private String nome;
    private Float preco;

    public Produto(int id, String nome, Float preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public static Produto BuscarProduto(int id) {
        Produto produtobd = null;
        Float precobd = null;
        String nomebd = null;

        String query = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            conn = Conexao.conectaBD();

            query = String.format("select nome, preco from produto where id = %d;", id);
            rs = conn.createStatement().executeQuery(query);

            if (rs.next()) {
                precobd = rs.getFloat("preco");
                nomebd = rs.getString("nome");
            }
            produtobd = new Produto(id, nomebd, precobd);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return produtobd;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Float getPreco() {
        return preco;
    }
}
