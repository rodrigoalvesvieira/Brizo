package model;

import interfaces.DataModel;

/**
 * @author Rodrigo Alves Vieira <rav2>
 */
public class Especificacao implements DataModel {
    private static String tableName = "tb_especificacoes";
    private static String primaryKey = "versao";

    private String certificadoEmbarcacao;
    private double versao, peso, comprimento, altura;
    private int capacidadeOcupantes;
    private double capacidadeCarga;

    public Especificacao(String certificadoEmbarcacao, double versao, double peso, double comprimento, double altura, int capacidade_ocupantes, double capacidade_carga) {
        this.certificadoEmbarcacao = certificadoEmbarcacao;
        this.versao = versao;
        this.peso = peso;
        this.comprimento = comprimento;
        this.altura = altura;
        this.capacidadeOcupantes = capacidade_ocupantes;
        this.capacidadeCarga = capacidade_carga;
    }

    /* Getter methods */

    public double getCapacidadeCarga() {
        return this.capacidadeCarga;
    }

    public int getCapacidadeOcupantes() {
        return this.capacidadeOcupantes;
    }

    public double getAltura() {
        return this.altura;
    }

    public double getComprimento() {
        return this.comprimento;
    }

    public double getPeso() {
        return this.peso;
    }

    public String getCertificadoEmbarcacao() {
        return this.certificadoEmbarcacao;
    }

    public double getVersao() {
        return this.versao;
    }

    /* Setter methods */

    public void setCertificadoEmbarcacao(String certificadoEmbarcacao) {
        this.certificadoEmbarcacao = certificadoEmbarcacao;
    }

    public void setVersao(double versao) {
        this.versao = versao;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setComprimento(double comprimento) {
        this.comprimento = comprimento;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setCapacidadeOcupantes(int capacidadeOcupantes) {
        this.capacidadeOcupantes = capacidadeOcupantes;
    }

    public void setCapacidadeCarga(double capacidadeCarga) {
        this.capacidadeCarga = capacidadeCarga;
    }

    /* DataModel interface methods */

    static public String getTable(){
        return "SELECT * FROM " + tableName;
    }

    static public String searchById(String id){
        return "SELECT * FROM " + tableName + " WHERE " + primaryKey + " = \'"+id+"\'";
    }

    @Override
    public String insert() {
        String insert =  "INSERT INTO " + tableName +
                "values((SELECT REF(M) FROM tb_embarcacoes M WHERE certificado = " + "'" + this.getCertificadoEmbarcacao() + "')" +
                this.getVersao() + ", " + this.getPeso() + ", " + this.getComprimento() + ", " +
                this.getAltura() + ", " + this.getCapacidadeOcupantes() + ", " + this.getCapacidadeCarga() + ")";

        return insert;
    }
}
