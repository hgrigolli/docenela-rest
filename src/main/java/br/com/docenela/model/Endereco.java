package br.com.docenela.model;

public class Endereco {

    private Integer id;
    private String linha1;
    private String linha2;
    private String numero;
    private String CEP;
    private String bairro;
    private String cidade;
    private String estado;
    private String pais;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLinha1() {
        return linha1;
    }

    public void setLinha1(String linha1) {
        this.linha1 = linha1;
    }

    public String getLinha2() {
        return linha2;
    }

    public void setLinha2(String linha2) {
        this.linha2 = linha2;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
}
