/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.control;


import fatec.poo.model.Instrutor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author notebook
 */
public class DaoInstrutor {

    private Connection conn;

    public DaoInstrutor(Connection conn) {
        this.conn = conn;
    }

    //Inserir
    public void inserir(Instrutor instrutor) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO tbInstrutor("
                    + "CPFInstrutor, Nome_Instrutor) VALUES(?,?)");
            ps.setString(1, instrutor.getCPF());
            ps.setString(2, instrutor.getNome());

            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    //Alterar
    public void alterar(Instrutor instrutor) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE tbInstrutor set nome_Instrutor = ?"
                    + "where CPFInstrutor = ?");

            ps.setString(1, instrutor.getNome());
            ps.setString(2, instrutor.getCPF());

            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    //Consultar

    public Instrutor consultar(String cpf) {
        Instrutor i = null;

        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * from tbInstrutor where "
                    + "CPFInstrutor = ?");

            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();

            if (rs.next() == true) {
                i = new Instrutor(cpf, rs.getString("CPFInstrutor"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return (i);
    }

    //Excluir
    public void excluir(Instrutor instrutor) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM tbInstrutor where CPFInstrutor = ?");

            ps.setString(1, instrutor.getCPF());

            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
}
