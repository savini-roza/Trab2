/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.control;

import fatec.poo.model.Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author notebook
 */
public class DaoCurso {

    private Connection conn;

    public DaoCurso(Connection conn) {
        this.conn = conn;
    }

    //Inserir
    public void inserir(Curso curso) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO tbCurso("
                    + "nomeCurso, siglaCurso) VALUES(?,?)");
            ps.setString(1, curso.getNome());
            ps.setString(2, curso.getSigla());

            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    //Alterar
    public void alterar(Curso turma) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE tbCurso set nomeCurso = ?"
                    + "where siglaCurso = ?");

            ps.setString(1, turma.getNome());
            ps.setString(2, turma.getSigla());

            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    //Consultar

    public Curso consultar(String sigla) {
        Curso c = null;

        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * from tbCurso where "
                    + "siglaCurso = ?");

            ps.setString(1, sigla);
            ResultSet rs = ps.executeQuery();

            if (rs.next() == true) {
                c = new Curso(sigla, rs.getString("siglaCurso"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return (c);
    }

    //Excluir
    public void excluir(Curso curso) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM tbCurso where  siglaCurso= ?");

            ps.setString(1, curso.getSigla());

            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
}
