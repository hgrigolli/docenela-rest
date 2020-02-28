package br.com.docenela.model;

public class Dominio {

    private Integer id;
    private Integer codigoGrupo;
    private String nomeGrupo;
    private Integer codigoElemento;
    private String nomeElemento;

    public Dominio(Integer codigoGrupo){
        this.codigoGrupo = codigoGrupo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCodigoGrupo() {
        return codigoGrupo;
    }

    public String getNomeGrupo() {
        return nomeGrupo;
    }

    public void setNomeGrupo(String nomeGrupo) {
        this.nomeGrupo = nomeGrupo;
    }

    public Integer getCodigoElemento() {
        return codigoElemento;
    }

    public void setCodigoElemento(Integer codigoElemento) {
        this.codigoElemento = codigoElemento;
    }

    public String getNomeElemento() {
        return nomeElemento;
    }

    public void setNomeElemento(String nomeElemento) {
        this.nomeElemento = nomeElemento;
    }
}
