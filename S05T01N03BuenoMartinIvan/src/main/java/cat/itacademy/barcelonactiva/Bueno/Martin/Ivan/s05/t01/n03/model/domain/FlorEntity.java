package cat.itacademy.barcelonactiva.Bueno.Martin.Ivan.s05.t01.n03.model.domain;

public class FlorEntity {

    private Integer pk_FlorID;
    private String nomFlor;
    private String paisFlor;

    public Integer getPk_FlorID() {
        return pk_FlorID;
    }

    public void setPk_FlorID(Integer pk_FlorID) {
        this.pk_FlorID = pk_FlorID;
    }

    public String getNomFlor() {
        return nomFlor;
    }

    public void setNomFlor(String nomFlor) {
        this.nomFlor = nomFlor;
    }

    public String getPaisFlor() {
        return paisFlor;
    }

    public void setPaisFlor(String paisFlor) {
        this.paisFlor = paisFlor;
    }
}