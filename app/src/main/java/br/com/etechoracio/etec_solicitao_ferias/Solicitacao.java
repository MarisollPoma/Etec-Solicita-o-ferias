package br.com.etechoracio.etec_solicitao_ferias;



import java.util.Date;

public class Solicitacao {

    private Date datainicio;
    private Date datafim;

    public Date getDatafim() {
        return datafim;
    }

    public void setDataFim(Date dataFim) {
        this.datafim = dataFim;
    }

    public Date getData() {
        return datainicio;
    }

    public void setData(Date data) {
        this.datainicio = data;
    }
}


