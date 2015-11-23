package model;


import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;
import java.util.Date;

/**
 * @author Rodrigo Alves Vieira <rav2>
 */
public class Funcionario implements SQLData {
    String type_name;

    private String cpf;
    private String nome;
    private Date dataAdmissao;
    private Date dataNascimento;
    private String cpfSuper;

    public Funcionario(String cpf, String nome, Date dataAdmissao, Date dataNascimento, String cpfSuper) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataAdmissao = dataAdmissao;
        this.dataNascimento = dataNascimento;
        this.cpfSuper = cpfSuper;
    }

    @Override
    public String getSQLTypeName() throws SQLException {
        return this.type_name;
    }

    @Override
    public void readSQL(SQLInput stream, String typeName) throws SQLException {

    }

    @Override
    public void writeSQL(SQLOutput stream) throws SQLException {

    }
}