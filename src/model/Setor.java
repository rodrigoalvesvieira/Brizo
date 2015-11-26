package model;

import interfaces.DataModel;

/**
 * @author Rodrigo Alves Vieira <rav2>
 */
public class Setor implements DataModel {
    private static String tableName = "tb_setores";
    private static String primaryKey = "id";

    private int id;
    private String nomeSetor;
    private String descricao;

    public Setor(int id, String nomeSetor, String descricao) {
        this.id = id;
        this.nomeSetor = nomeSetor;
        this.descricao = descricao;
    }

    /* Getter methods */

    public String getDescricao() {
        return this.descricao;
    }

    public String getNomeSetor() {
        return this.nomeSetor;
    }

    public int getId() {
        return this.id;
    }

    /* Setter methods */

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setNomeSetor(String nomeSetor) {
        this.nomeSetor = nomeSetor;
    }

    public void setId(int id) {
        this.id = id;
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
                "values(\'"+ this.getId() +"\',\'"+ this.getNomeSetor()+"\',\'"+ this.getDescricao() +"\')";

        return insert;
    }
}
