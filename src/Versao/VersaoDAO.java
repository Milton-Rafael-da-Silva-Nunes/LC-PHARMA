package Versao;

import Conexao.GenericDAO;
import Util.Funcoes;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VersaoDAO extends GenericDAO {

    ResultSet rs = null;
    PreparedStatement stmt = null;

    public void insert(Versao v) throws Exception {

        stmt = getConnection().prepareStatement("INSERT INTO versao(versao, data_vigencia, data_hora) VALUES (?, ?, ?);");
        stmt.setInt(1, v.getVersao());
        stmt.setString(2, v.getData_vigencia());
        stmt.setString(3, v.getData_hora());
        stmt.executeUpdate();

        Funcoes.getUltimoId();

        stmt.close();
    }

    public Versao getVersaoAnterior(Integer versao) throws Exception {
        stmt = getConnection().prepareStatement("select * from versao where versao = " + versao + ";");
        rs = stmt.executeQuery();

        Versao v = new Versao();
        while (rs.next()) {
            v.setId(rs.getInt("id"));
            v.setVersao(rs.getInt("versao"));
            v.setData_vigencia(rs.getString("data_vigencia"));
            v.setData_hora(rs.getString("data_hora"));
        }
        return v;
    }

    public ArrayList<Versao> listaVersao() throws SQLException {
        ArrayList<Versao> lista = new ArrayList<>();

        stmt = getConnection().prepareStatement("select * from versao;");
        rs = stmt.executeQuery();

        while (rs.next()) {
            Versao v = new Versao();

            v.setId(rs.getInt("id"));
            v.setVersao(rs.getInt("versao"));
            v.setData_vigencia(rs.getString("data_vigencia"));
            v.setData_hora(rs.getString("data_hora"));

            lista.add(v);
        }

        stmt.close();
        rs.close();

        return lista;
    }

}
