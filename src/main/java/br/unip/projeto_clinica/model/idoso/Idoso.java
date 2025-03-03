package br.unip.projeto_clinica.model.idoso;

import br.unip.projeto_clinica.model.idoso.subclasses.Medicacao;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;

@Document("idosos")
public class Idoso {

    @Id
    private String id;
    private String cpf;
    private String nome;
    private String[] familiares;
    private Medicacao[] medicacoes;

    public Idoso(String id, String cpf, String nome, String[] familiares, Medicacao[] medicacoes) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.familiares = familiares;
        this.medicacoes = medicacoes;
    }

    public Idoso() { }

    public String getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String[] getFamiliares() {
        return familiares;
    }

    public void setFamiliares(String[] familiares) {
        this.familiares = familiares;
    }

    public Medicacao[] getMedicacoes() {
        return medicacoes;
    }

    public void setMedicacoes(Medicacao[] medicacoes) {
        this.medicacoes = medicacoes;
    }

    @Override
    public String toString() {
        return "Idoso{" +
                "id='" + id + '\'' +
                ", cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", familiares=" + Arrays.toString(familiares) +
                ", medicacoes=" + Arrays.toString(medicacoes) +
                '}';
    }

}
