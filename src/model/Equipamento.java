package model;

import interfaces.DataModel;

/**
 * @author Rodrigo Alves Vieira <rav2>
 */
public class Equipamento implements DataModel {
    private static String tableName = "tb_equipamentos";
    private static String primaryKey = "id";

    private int id;
    private String nomeEquipamento;
    private String tipo;
    private String dataUsoInicio;
    private String dataUsoTermino;

    public Equipamento(int id, String nomeEquipamento, String tipo, String dataUsoInicio, String dataUsoTermino) {
        this.id = id;
        this.nomeEquipamento = nomeEquipamento;
        this.tipo = tipo;
        this.dataUsoInicio = dataUsoInicio;
        this.dataUsoTermino = dataUsoTermino;
    }

    /* Getter methods */

    public String getDataUsoTermino() {
        return this.dataUsoTermino;
    }

    public String getNomeEquipamento() {
        return this.nomeEquipamento;
    }

    public int getId() {
        return this.id;
    }

    public String getTipo() {
        return this.tipo;
    }

    public String getDataUsoInicio() {
        return this.dataUsoInicio;
    }

    /* Setter methods */

    public void setDataUsoTermino(String dataUsoTermino) {
        this.dataUsoTermino = dataUsoTermino;
    }

    public void setDataUsoInicio(String dataUsoInicio) {
        this.dataUsoInicio = dataUsoInicio;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setNomeEquipamento(String nomeEquipamento) {
        this.nomeEquipamento = nomeEquipamento;
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
                "values(\'"+ this.getId() + "\',\'" +
                this.getNomeEquipamento() + "\',\'" +
                this.getTipo() + "\',\'" +
                "TO_DATE(\'"+this.getDataUsoInicio()+"\',\'dd/mm/yyyy\')," +
                "TO_DATE(\'"+this.getDataUsoTermino()+"\',\'dd/mm/yyyy\')')";

        return insert;
    }
}
