package model;

import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

/**
 * @author Rodrigo Alves Vieira <rav2>
 */
public class ProjetoCriacao extends Projeto implements SQLData {
    private static String tableName = "tb_projetos_criacoes";
    private static String primaryKey = "id";

    String type_name;

    private String modelagem;

    public ProjetoCriacao(int id, String nome, String descricao, double orcamento, String dataInicio, String dataPrevisaoTermino, String dataTermino) {
        super(id, nome, descricao, orcamento, dataInicio, dataPrevisaoTermino, dataTermino);
    }

    public ProjetoCriacao(String modelagem, int id, String nome, String descricao, double orcamento, String dataInicio, String dataPrevisaoTermino, String dataTermino) {
        super(id, nome, descricao, orcamento, dataInicio, dataPrevisaoTermino, dataTermino);
        this.modelagem = modelagem;
    }

    /* Getter methods */

    public String getModelagem() {
        return this.modelagem;
    }

    /* Setter methods */

    public void setModelagem(String modelagem) {
        this.modelagem = modelagem;
    }

    public String insert() {
        String statement =  "INSERT INTO " + tableName + " values(\'"+ this.getId() + "\',\'" +
                this.getNome() + "\',\'" +
                this.getDescricao() +"\'," +
                this.getOrcamento()+ ", " +
                "TO_DATE(\'"+ this.getDataInicio() + "\',\'dd/mm/yyyy\')," +
                "TO_DATE(\'"+ this.getDataPrevisaoTermino() + "\',\'dd/mm/yyyy\')," +
                "TO_DATE(\'"+ this.getDataTermino() + "\',\'dd/mm/yyyy\')," +
                this.getModelagem() +"\',\'";

        statement += ")";

        return statement;
    }

    static public String getTable(){
        return "SELECT * FROM " + tableName;
    }

    static public String searchById(String id){
        return "SELECT * FROM " + tableName + " WHERE " + primaryKey + " = \'" + id + "\'";
    }

    /* SQLData interface methods */

    @Override
    public String getSQLTypeName() throws SQLException {
        return this.type_name;
    }

    @Override
    public void readSQL(SQLInput arg0, String arg1) throws SQLException {
        this.type_name = arg1;
        nome = arg0.readString();
        descricao = arg0.readString();
        orcamento = arg0.readDouble();
        dataInicio = arg0.readDate().toString();
        dataPrevisaoTermino = arg0.readDate().toString();
        dataTermino = arg0.readDate().toString();
    }

    @Override
    public void writeSQL(SQLOutput arg0) throws SQLException {
    }
}