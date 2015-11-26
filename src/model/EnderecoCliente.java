package model;

import interfaces.DataModel;

/**
 * @author Rodrigo Alves Vieira <rav2>
 */
public class EnderecoCliente implements DataModel {
    private static String tableName = "tb_enderecos_clientes";
    private static String primaryKey = "cep";

    private String clienteCnpj;
    private String cep;
    private String descricao;

    public EnderecoCliente(String clienteCnpj, String cep, String descricao) {
        this.clienteCnpj = clienteCnpj;
        this.cep = cep;
        this.descricao = descricao;
    }

    /* Getter methods */

    public String getClienteCnpj() {
        return this.clienteCnpj;
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

    public void setClienteCnpj(String clienteCnpj) {
        this.clienteCnpj = clienteCnpj;
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
                "values((SELECT REF(C) FROM tb_clientes C WHERE cnpj = " + "'" + this.getClienteCnpj() + "')" +
                this.getCep() +"\',\'" +
                this.getDescricao() + "\')";

        return insert;
    }
}
