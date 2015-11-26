package model;

import interfaces.DataModel;

/**
 * @author Rodrigo Alves Vieira <rav2>
 */
public class Funcionario implements DataModel {
    private static String tableName = "tb_funcionarios";
    private static String primaryKey = "cpf";

    String type_name;

    private String cpf;
    private String nome;
    private String dataAdmissao;
    private String dataNascimento;
    private String[] telefones;
    private String cpfSuper;

    public Funcionario(String cpf, String nome, String dataAdmissao, String dataNascimento, String[] telefones, String cpfSuper) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataAdmissao = dataAdmissao;
        this.dataNascimento = dataNascimento;
        this.telefones = telefones;
        this.cpfSuper = cpfSuper;
    }

    /* Getter methods */

    public String getCpfSuper() {
        return this.cpfSuper;
    }

    public String getDataAdmissao() {
        return this.dataAdmissao;
    }

    public String getDataNascimento() {
        return this.dataNascimento;
    }

    public String[] getTelefones() {
        return this.telefones;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    /* Setter methods */

    public void setDataAdmissao(String dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setTelefones(String[] telefones) {
        this.telefones = telefones;
    }

    public void setCpfSuper(String cpfSuper) {
        this.cpfSuper = cpfSuper;
    }

    /* DataModel interface methods */

    static public String getTable(){
        return "SELECT * FROM " + tableName;
    }

    static public String searchById(String id){
        return "SELECT * FROM " + tableName + " WHERE " + primaryKey + " = \'"+id+"\'";
    }

    public String insert() {
        String statement =  "INSERT INTO " + tableName + " values(\'" +
                this.getCpf() + "\',\'" +
                this.getNome()+"\',\'"+"\'," +
                "TO_DATE(\'"+this.getDataAdmissao()+"\',\'dd/mm/yyyy\')," +
                "TO_DATE(\'"+this.getDataNascimento()+"\',\'dd/mm/yyyy\')," +
                ", tp_telefones_funcionarios(";

        String[] telefones = this.getTelefones();

        for (int i = 0; i < telefones.length; i++) {
            if (telefones[i] != null){
                statement+= "tp_telefone(\'" + telefones[i] + "\')";

                if (i < this.getTelefones().length -1) {
                    statement += ",";
                }
            }
        }

        statement += "), (SELECT REF(S) FROM " + tableName + " S WHERE " + primaryKey + " = '" + this.getCpfSuper() + "')";
        statement+=")";

        return statement;
    }

    public void insertEndereco(String cep, String descricao) {
        EnderecoFuncionario endereco = new EnderecoFuncionario(this.getCpf(), cep, descricao);
        endereco.insert();
    }
}