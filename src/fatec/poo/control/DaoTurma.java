/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.control;

import fatec.poo.model.Turma;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author notebook
 */
public class DaoTurma {

    private Connection conn;

    public DaoTurma(Connection conn) {
        this.conn = conn;
    }

    //Inserir
    public void inserir(Turma turma) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO tbTurma("
                    + "dataInicio, SiglaCTurma) VALUES(?,?)");
            ps.setString(1, turma.getDataInicio());
            ps.setString(2, turma.getSiglaTurma());

            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    //Alterar
    public void alterar(Turma turma) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE tbTurma set dataInicio = ?"
                    + "where SiglaCTurma = ?");

            ps.setString(1, turma.getDataInicio());
            ps.setString(2, turma.getSiglaTurma());

            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    //Consultar

    public Turma consultar(String sigla) {
        Turma c = null;

        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * from tbTurma where "
                    + "SiglaCTurma = ?");

            ps.setString(1, sigla);
            ResultSet rs = ps.executeQuery();

            if (rs.next() == true) {
                c = new Turma(sigla, rs.getString("SiglaCTurma"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return (c);
    }

    //Excluir
    public void excluir(Turma turma) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM tbTurma where  SiglaCTurma= ?");

            ps.setString(1, turma.getSiglaTurma());

            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
}
