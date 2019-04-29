package studio.dayvidson.curriculoti.controller;

public class Usuario {
    private int id;
    private String nomeCompleto;
    private String usuario;
    private String phoneWhatsApp;
    private String senha;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPhoneWhatsApp() {
        return phoneWhatsApp;
    }

    public void setPhoneWhatsApp(String phoneWhatsApp) {
        this.phoneWhatsApp = phoneWhatsApp;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
