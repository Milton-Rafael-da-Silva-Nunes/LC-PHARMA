package Fabricante;

import Conexao.GenericDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Fabrício Ventura
 */
public class FabricanteDAO extends GenericDAO {

    PreparedStatement stmt = null;
    ResultSet rs = null;

    public void insertFabricante(Fabricante f) throws Exception {
        stmt = getConnection().prepareStatement("INSERT INTO fabricante(nome, descricao, cnpj) VALUES(?, ?, ?);");
        stmt.setString(1, f.getNome());
        stmt.setString(2, f.getDescricao());
        stmt.setString(3, f.getCnpj());
        stmt.executeUpdate();
        stmt.close();
    }

    public void updateFabricante(Fabricante f) throws Exception {
        stmt = getConnection().prepareStatement("UPDATE fabricante SET nome = ?, descricao = ?, cnpj = ? WHERE id = ?;");
        stmt.setString(1, f.getNome());
        stmt.setString(2, f.getDescricao());
        stmt.setString(3, f.getCnpj());
        stmt.setInt(4, f.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    public Fabricante getFabricante(int id_fabricante) throws Exception {
        Fabricante f = new Fabricante();
        stmt = getConnection().prepareStatement("SELECT * FROM fabricante WHERE id = " + id_fabricante + ";");
        rs = stmt.executeQuery();

        while (rs.next()) {
            f = new Fabricante();
            f.setId(rs.getInt("id"));
            f.setNome(rs.getString("nome"));
            f.setDescricao(rs.getString("descricao"));
            f.setCnpj(rs.getString("cnpj"));
        }
        stmt.close();
        rs.close();
        return f;
    }

    public ArrayList<Fabricante> listaFabricante() throws Exception {
        ArrayList<Fabricante> lista = new ArrayList<Fabricante>();
        Fabricante f = new Fabricante();
        stmt = getConnection().prepareStatement("SELECT * FROM fabricante;");
        rs = stmt.executeQuery();

        while (rs.next()) {
            f = new Fabricante();
            f.setId(rs.getInt("id"));
            f.setNome(rs.getString("nome"));
            f.setDescricao(rs.getString("descricao"));
            f.setCnpj(rs.getString("cnpj"));
            lista.add(f);
        }
        stmt.close();
        rs.close();
        return lista;
    }

}
