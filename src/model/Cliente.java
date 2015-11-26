package model;

import interfaces.DataModel;

/**
 * @author Rodrigo Alves Vieira <rav2>
 */
public class Cliente implements DataModel {
    private static String tableName = "tb_clientes";
    private static String primaryKey = "cnpj";

    private String cnpj;
    private String nomeEmpresa;
    private String email;
    private String site;
    private String[] telefones;

    public Cliente(String nomeEmpresa, String email, String site, String cnpj, String[] telefones) {
        this.nomeEmpresa = nomeEmpresa;
        this.email = email;
        this.site = site;
        this.cnpj = cnpj;
        this.telefones = telefones;
    }

    /* Getter methods */

    public String getSite() {
        return site;
    }

    public String getEmail() {
        return email;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String[] getTelefones() {
        return this.getTelefones();
    }

    /* Setter methods */

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefones(String[] telefones) {
        this.telefones = telefones;
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
                "values(\'"+ this.getCnpj() +"\',\'"+ this.getNomeEmpresa()+"\',\'" +
                this.getEmail()+"\',\'" + this.getSite() + "\')";

        return insert;
    }

    public void insertEndereco(String cep, String descricao) {
        EnderecoCliente endereco = new EnderecoCliente(this.getCnpj(), cep, descricao);
        endereco.insert();
    }
}
