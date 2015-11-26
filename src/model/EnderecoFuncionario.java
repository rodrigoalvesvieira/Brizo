package model;

import interfaces.DataModel;

/**
 * @author Rodrigo Alves Vieira <rav2>
 */
public class EnderecoFuncionario implements DataModel {
    private static String tableName = "tb_enderecos_funcionarios";
    private static String primaryKey = "cep";

    private String funcionarioCpf;
    private String cep;
    private String descricao;

    public EnderecoFuncionario(String funcionarioCpf, String cep, String descricao) {
        this.funcionarioCpf = funcionarioCpf;
        this.cep = cep;
        this.descricao = descricao;
    }

    /* Getter methods */

    public String getFuncionarioCpf() {
        return this.funcionarioCpf;
    }

    public String getCep() {
        return this.cep;
    }

    public String getDescricao() {
        return this.descricao;
    }

    /* Setter methods */

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setFuncionarioCpf(String funcionarioCpf) {
        this.funcionarioCpf = funcionarioCpf;
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
                "values((SELECT REF(s) FROM tb_funcionarios s WHERE cpf = " + "'" + this.getFuncionarioCpf() + "')" +
                this.getCep() +"\',\'" +
                this.getDescricao() + "\')";

        return insert;
    }
}
