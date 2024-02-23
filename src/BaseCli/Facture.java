package BaseCli;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import coursSwing.Classe;

public class Facture {
    private String idFac;
    private String dateFac;

    public Facture(String idFac, String dateFac) {
        this.idFac = idFac;
        this.dateFac = dateFac;
    }

    public String getIdFac() {
        return idFac;
    }

    public void setIdFac(String idFac) {
        this.idFac = idFac;
    }

    public String getDateFac() {
        return dateFac;
    }

    public void setDateFac(String dateFac) {
        this.dateFac = dateFac;
    }


    @Override
    public String toString() {
        return "Facture [idFac=" + idFac + ", dateFac=" + dateFac + "]";
    }
}
