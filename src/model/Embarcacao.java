package model;

import interfaces.DataModel;

/**
 * @author Rodrigo Alves Vieira <rav2>
 */
public class Embarcacao implements DataModel {
    private static String tableName = "tb_embarcacoes";
    private static String primaryKey = "certificado";

    public static String[] TIPOS = { "Conteineiro', 'Gaseiro', 'VLCC', 'Petroleiro' "};

    private String certificado;
    private String tipo;
    private String dataFabricacao;

    public Embarcacao(String certificado, String tipo, String data_fabricacao) {
        this.certificado = certificado;
        this.tipo = tipo;
        this.dataFabricacao = data_fabricacao;
    }

    /* Getter methods */

    public String getCertificado() {
        return this.certificado;
    }

    public String getTipo() {
        return this.tipo;
    }

    public String getDataFabricacao() {
        return this.dataFabricacao;
    }

    /* Setter methods */

    public void setDataFabricacao(String data_fabricacao) {
        this.dataFabricacao = data_fabricacao;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setCertificado(String certificado) {
        this.certificado = certificado;
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
                "values(\'"+ this.getCertificado() +"\',\'"+ this.getTipo()+"\',\'"+
                "TO_DATE(\'"+this.getDataFabricacao()+"\',\'dd/mm/yyyy\')')";

        return insert;
    }

    public void insertEspecificacoes(double versao, double peso, double comprimento, double altura, int capacidadeOcupantes, double capacidadeCarga) {
        Especificacao especificacao = new Especificacao(this.getCertificado(), versao, peso, comprimento, altura, capacidadeOcupantes, capacidadeCarga);
        especificacao.insert();
    }
}
