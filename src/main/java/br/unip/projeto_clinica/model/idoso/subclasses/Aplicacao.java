package br.unip.projeto_clinica.model.idoso.subclasses;

import java.time.LocalDateTime;

public class Aplicacao {

    private LocalDateTime data;
    private boolean aplicado;
    private String justificativa;

    public Aplicacao(LocalDateTime data, boolean aplicado, String justificativa) {
        this.data = data;
        this.aplicado = aplicado;
        this.justificativa = justificativa;
    }

    public Aplicacao() { }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public boolean isAplicado() {
        return aplicado;
    }

    public void setAplicado(boolean aplicado) {
        this.aplicado = aplicado;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    @Override
    public String toString() {
        return "Aplicacao{" +
                "data=" + data +
                ", aplicado=" + aplicado +
                ", justificativa='" + justificativa + '\'' +
                '}';
    }

}
