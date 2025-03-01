package br.unip.projeto_clinica.model.idoso.subclasses;

import java.util.Arrays;

public class Medicacao {

    private String nome;
    private int dosagem;
    private String medicao;
    private int estoque;
    private String receita;
    private String[] dias;
    private Aplicacao aplicacao;

    public Medicacao(String nome, int dosagem, String medicao, int estoque, String receita, String[] dias, Aplicacao aplicacao) {
        this.nome = nome;
        this.dosagem = dosagem;
        this.medicao = medicao;
        this.estoque = estoque;
        this.receita = receita;
        this.dias = dias;
        this.aplicacao = aplicacao;
    }

    public Medicacao() { }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDosagem() {
        return dosagem;
    }

    public void setDosagem(int dosagem) {
        this.dosagem = dosagem;
    }

    public String getMedicao() {
        return medicao;
    }

    public void setMedicao(String medicao) {
        this.medicao = medicao;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public String getReceita() {
        return receita;
    }

    public void setReceita(String receita) {
        this.receita = receita;
    }

    public String[] getDias() {
        return dias;
    }

    public void setDias(String[] dias) {
        this.dias = dias;
    }

    public Aplicacao getAplicacao() {
        return aplicacao;
    }

    public void setAplicacao(Aplicacao aplicacao) {
        this.aplicacao = aplicacao;
    }

    @Override
    public String toString() {
        return "Medicacao{" +
                "nome='" + nome + '\'' +
                ", dosagem=" + dosagem +
                ", medicao='" + medicao + '\'' +
                ", estoque=" + estoque +
                ", receita='" + receita + '\'' +
                ", dias=" + Arrays.toString(dias) +
                ", aplicacao=" + aplicacao +
                '}';
    }

}
