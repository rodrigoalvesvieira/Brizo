package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;

import interfaces.DataModel;

/**
 * @author Rodrigo Alves Vieira <rav2>
 *
 */

public class Engine {
    static final String driver = "oracle.jdbc.driver.OracleDriver";
    static final String URL = "jdbc:oracle:thin:hr/hr@localhost:1521/XE";
    static final String username = "SYSTEM";
    static final String password = ""; // local password

    public static Connection connectToDatabase(String username, String password)
            throws ClassNotFoundException {

        Connection con = null;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(URL, username, password);
        } catch (ClassNotFoundException exc1) {
            exc1.printStackTrace();
        } catch (SQLException exc2) {
            exc2.printStackTrace();
        }

        return con;
    }

	/*
	 * This method allow insert, delete and update data over database
	 */
    public void insert(DataModel data) throws ClassNotFoundException, SQLException{
        Connection con = connectToDatabase(username, password);
        Statement stmt = con.createStatement();
        //String insertS = data.insert();
        stmt.executeUpdate(data.insert());
        stmt.close();
        con.close();
        System.out.println("Inserido");
    }

    /* Query Methods */

    public void queryFuncionario(String funcionarioCpf) throws SQLException, ClassNotFoundException {
        Connection con = connectToDatabase(username, password);
        Statement stmt = con.createStatement();
        stmt.executeQuery(funcionarioCpf);

        ResultSet rs = stmt.getResultSet ();
        int count = 0;
        ResultSetMetaData md =  rs.getMetaData();

        while (rs.next ()){
            //get first 5 columns

            for (int i = 1 ; i <= 10; i++) {
                String columnName = md.getColumnName(i);
                String idVal = rs.getString(columnName);
                System.out.println (columnName+" = " + idVal);
            }

            //tp_logadouro
            //tp_fones

            for(int i = 8 ; i <= 9;i++){
                String columnName = md.getColumnName(i);
                String idVal = rs.getString(columnName);
                System.out.println (columnName+" = " + idVal);
            }

            System.out.println(md.getColumnTypeName(10));

            ++count;
        }

        rs.close ();
        stmt.close();
        con.close();
    }

    public void queryCliente(String cnpj) throws SQLException, ClassNotFoundException {
        Connection con = connectToDatabase(username, password);
        Statement stmt = con.createStatement();
        stmt.executeQuery(cnpj);

        ResultSet rs = stmt.getResultSet();
        ResultSetMetaData md=  rs.getMetaData();

        while (rs.next ()){
            //get first 5 columns
            for(int i = 1 ; i <= 5;i++){
                String columnName = md.getColumnName(i);
                String idVal = rs.getString(columnName);
                System.out.println (columnName+" = " + idVal);
            }

            //tp_logadouro
            //tp_fones

            //data associacao + status
            for(int i = 8 ; i <= 9;i++){
                String columnName = md.getColumnName(i);
                String idVal = rs.getString(columnName);
                System.out.println (columnName+" = " + idVal);
            }

            //dependente_nested
            //not working
            System.out.println(md.getColumnTypeName(10));

        }

        rs.close ();
        stmt.close();
        con.close();

    }

    public void queryRepresentanteCliente(String cpfRepresentante) throws SQLException, ClassNotFoundException {
        Connection con = connectToDatabase(username, password);
        Statement stmt = con.createStatement();
        stmt.executeQuery(cpfRepresentante);

        ResultSet rs = stmt.getResultSet();
        ResultSetMetaData md = rs.getMetaData();

        while (rs.next()){

            for(int i = 1 ; i <= 3;i++){
                String columnName = md.getColumnName(i);
                String idVal = rs.getString(columnName);
                System.out.println(columnName+" = " + idVal);
            }
        }

        rs.close();
        stmt.close();
        con.close();
    }

    public void querySetor(String setorID) throws SQLException, ClassNotFoundException {

        Connection con = connectToDatabase(username, password);
        Statement stmt = con.createStatement();
        stmt.executeQuery(setorID);

        ResultSet rs = stmt.getResultSet();
        ResultSetMetaData md = rs.getMetaData();

        while (rs.next()){

            for(int i = 1 ; i <= 2;i++){
                String columnName = md.getColumnName(i);
                String idVal = rs.getString(columnName);
                System.out.println(columnName+" = " + idVal);

            }

        }

        rs.close();
        stmt.close();
        con.close();
    }

    public void queryEmbarcacao(String certificado) throws SQLException, ClassNotFoundException {
        Connection con = connectToDatabase(username, password);
        Statement stmt = con.createStatement();
        stmt.executeQuery(certificado);

        ResultSet rs = stmt.getResultSet();
        ResultSetMetaData md = rs.getMetaData();

        while (rs.next()){
            for (int i = 1 ; i <= 5; i++){
                String columnName = md.getColumnName(i);
                String idVal = rs.getString(columnName);
                System.out.println(columnName+" = " + idVal);
            }

        }

        rs.close();
        stmt.close();
        con.close();
    }

    public void queryProjeto(String projetoID) throws SQLException, ClassNotFoundException {
        Connection con = connectToDatabase(username, password);
        Statement stmt = con.createStatement();
        stmt.executeQuery(projetoID);

        ResultSet rs = stmt.getResultSet();
        ResultSetMetaData md = rs.getMetaData();

        while (rs.next()){
            for (int i = 1 ; i <= 5; i++){
                String columnName = md.getColumnName(i);
                String idVal = rs.getString(columnName);
                System.out.println(columnName+" = " + idVal);
            }

        }

        rs.close();
        stmt.close();
        con.close();
    }

    public void queryEquipamento(String equipamentoID) throws SQLException, ClassNotFoundException {
        Connection con = connectToDatabase(username, password);
        Statement stmt = con.createStatement();
        stmt.executeQuery(equipamentoID);

        ResultSet rs = stmt.getResultSet();
        ResultSetMetaData md = rs.getMetaData();

        while (rs.next()){
            for (int i = 1 ; i <= 5; i++){
                String columnName = md.getColumnName(i);
                String idVal = rs.getString(columnName);
                System.out.println(columnName+" = " + idVal);
            }
        }

        rs.close();
        stmt.close();
        con.close();
    }

    /*
     * This method creates a new table!
     */
    public void createTable(DataModel c) throws SQLException, ClassNotFoundException {
        Connection con = connectToDatabase(username, password);
        Statement stmt = con.createStatement();
        String sql = "";
        stmt.executeUpdate(sql);
    }
}
