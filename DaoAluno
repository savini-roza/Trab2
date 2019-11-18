/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.control;

import fatec.poo.model.Aluno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author notebook
 */
public class DaoAluno {

    private Connection conn;

    public DaoAluno(Connection conn) {
        this.conn = conn;
    }

    //Inserir
    public void inserir(Aluno aluno) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO tbAluno("
                    + "CPFAluno, Nome_Aluno) VALUES(?,?)");
            ps.setString(1, aluno.getCPF());
            ps.setString(2, aluno.getNome());

            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    //Alterar
    public void alterar(Aluno aluno) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE tbAluno set Nome_Aluno = ?"
                    + "where CPFAluno = ?");

            ps.setString(1, aluno.getNome());
            ps.setString(2, aluno.getCPF());

            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    //Consultar

    public Aluno consultar(String cpf) {
        Aluno a = null;

        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * from tbAluno where "
                    + "CPFAluno = ?");

            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();

            if (rs.next() == true) {
                a = new Aluno(cpf, rs.getString("CPFAluno"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return (a);
    }

    //Excluir
    public void excluir(Aluno aluno) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM tbdepartamento where CPFAluno = ?");

            ps.setString(1, aluno.getCPF());

            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
}
