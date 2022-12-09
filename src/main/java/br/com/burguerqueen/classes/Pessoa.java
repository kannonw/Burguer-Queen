package br.com.burguerqueen.classes;

public abstract class Pessoa {
    protected int id;
    protected String nome;
    protected String nome_usuario;
    protected String senha;
    protected String email;

    public Pessoa(){}

    public Pessoa(int id, String nome, String nome_usuario, String senha, String email) {
        this.id = id;
        this.nome = nome;
        this.nome_usuario = nome_usuario;
        this.senha = senha;
        this.email = email;
    }

    public Pessoa(String nome, String nome_usuario, String senha, String email) {
        this.nome = nome;
        this.nome_usuario = nome_usuario;
        this.senha = senha;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getNome_usuario() {
        return nome_usuario;
    }

    public String getSenha() {
        return senha;
    }

    public String getEmail() {
        return email;
    }
}
