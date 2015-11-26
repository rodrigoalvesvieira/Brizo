package model;

import interfaces.DataModel;

/**
 * @author Rodrigo Alves Vieira <rav2>
 */
public class RepresentanteCliente implements DataModel {
    private static String tableName = "tb_representantes";
    private static String primaryKey = "cpf_representante";

    private String cpfRepresentante;
    private String empresaCnpj;
    private String nome;

    public RepresentanteCliente(String cpfRepresentante, String empresaCnpj, String nome) {
        this.cpfRepresentante = cpfRepresentante;
        this.empresaCnpj = empresaCnpj;
        this.nome = nome;
    }

    /* Getter methods */

    public String getCpfRepresentante() {
        return this.cpfRepresentante;
    }

    public String getEmpresaCnpj() {
        return this.empresaCnpj;
    }

    public String getNome() {
        return this.nome;
    }

    /* Setter methods */

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmpresaCnpj(String empresaCnpj) {
        this.empresaCnpj = empresaCnpj;
    }

    public void setCpfRepresentante(String cpfRepresentante) {
        this.cpfRepresentante = cpfRepresentante;
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
                "values(\'"+ this.getCpfRepresentante() +"\',\'"+ this.getEmpresaCnpj()+"\',\'"+ this.getNome() +"\')";

        return insert;
    }
}
