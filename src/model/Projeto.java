package model;

import interfaces.DataModel;

/**
 * @author Rodrigo Alves Vieira <rav2>
 */
public class Projeto implements DataModel {
    private int id;

    String nome;
    String descricao;
    double orcamento;
    String dataInicio;
    String dataPrevisaoTermino;
    String dataTermino;

    public Projeto(int id, String nome, String descricao, double orcamento, String dataInicio, String dataPrevisaoTermino, String dataTermino) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.orcamento = orcamento;
        this.dataInicio = dataInicio;
        this.dataPrevisaoTermino = dataPrevisaoTermino;
        this.dataTermino = dataTermino;
    }

    /* Getter methods */

    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public double getOrcamento() {
        return this.orcamento;
    }

    public String getDataInicio() {
        return this.dataInicio;
    }

    public String getDataPrevisaoTermino() {
        return this.dataPrevisaoTermino;
    }

    public String getDataTermino() {
        return this.dataTermino;
    }

    /* Setter methods */

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setOrcamento(double orcamento) {
        this.orcamento = orcamento;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDataPrevisaoTermino(String dataPrevisaoTermino) {
        this.dataPrevisaoTermino = dataPrevisaoTermino;
    }

    public void setDataTermino(String dataTermino) {
        this.dataTermino = dataTermino;
    }

    /* DataModel interface methods */

    public String insert(){
        return null;
    }
}
