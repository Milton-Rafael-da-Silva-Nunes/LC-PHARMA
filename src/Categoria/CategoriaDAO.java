package Categoria;

import Conexao.GenericDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Fabrício Ventura
 */
public class CategoriaDAO extends GenericDAO {

    PreparedStatement stmt = null;
    ResultSet rs = null;

    public void insertCategoria(Categoria c) throws Exception {
        stmt = getConnection().prepareStatement("INSERT INTO categoria(nome) VALUES(?);");
        stmt.setString(1, c.getNome());
        stmt.executeUpdate();
        stmt.close();
    }

    public void updateCategoria(Categoria c) throws Exception {
        stmt = getConnection().prepareStatement("UPDATE categoria SET nome = ? WHERE id = ?;");
        stmt.setString(1, c.getNome());
        stmt.setInt(2, c.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    public Categoria getCategoria(int id_categoria) throws Exception {
        Categoria c = new Categoria();
        stmt = getConnection().prepareStatement("SELECT * FROM categoria WHERE id = " + id_categoria + ";");
        rs = stmt.executeQuery();

        while (rs.next()) {
            c = new Categoria();
            c.setId(rs.getInt("id"));
            c.setNome(rs.getString("nome"));
        }
        stmt.close();
        rs.close();

        return c;
    }

    public ArrayList<Categoria> listaCategoria() throws SQLException {
        ArrayList<Categoria> lista = new ArrayList<>();
        Categoria c = new Categoria();

        stmt = getConnection().prepareStatement("SELECT * FROM categoria;");
        rs = stmt.executeQuery();

        while (rs.next()) {
            c = new Categoria();
            c.setId(rs.getInt("id"));
            c.setNome(rs.getString("nome"));
            lista.add(c);
        }
        stmt.close();
        rs.close();

        return lista;
    }
}
