package ProdutoPreco;

import Conexao.GenericDAO;
import Produto.Produto;
import Produto.ProdutoDAO;
import Versao.Versao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Fabrício Ventura
 */
public class ProdutoPrecoDAO extends GenericDAO {

    PreparedStatement stmt = null;
    ResultSet rs = null;

    ProdutoDAO pDao = new ProdutoDAO();

    public void insereProdutoPreco(ProdutoPreco pr, Produto produto, String atualizar) throws Exception {
        stmt = getConnection().prepareStatement("insert into produtopreco(id_versao, id_produto, precocusto_sem_imposto, precocusto_0, precocusto_12, precocusto_17, precocusto_17_5, precocusto_18, precocusto_19, precocusto_20, precocusto_21, precocusto_22, precocusto_17_alc, precocusto_17_5_alc, precocusto_18_alc, precovenda_0, precovenda_12, precovenda_17, precovenda_17_5, precovenda_18, precovenda_19, precovenda_20, precovenda_21, precovenda_22, precovenda_17_alc, precovenda_17_5_alc, precovenda_18_alc, atualizar) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
        stmt.setInt(1, pr.getId_versao());
        stmt.setInt(2, produto.getId());
        stmt.setDouble(3, pr.getPrecocusto_sem_imposto());
        stmt.setDouble(4, pr.getPrecocusto_0());
        stmt.setDouble(5, pr.getPrecocusto_12());
        stmt.setDouble(6, pr.getPrecocusto_17());
        stmt.setDouble(7, pr.getPrecocusto_17_5());
        stmt.setDouble(8, pr.getPrecocusto_18());
        stmt.setDouble(9, pr.getPrecocusto_19());
        stmt.setDouble(10, pr.getPrecocusto_20());
        stmt.setDouble(11, pr.getPrecocusto_21());
        stmt.setDouble(12, pr.getPrecocusto_22());
        stmt.setDouble(13, pr.getPrecocusto_17_alc());
        stmt.setDouble(14, pr.getPrecocusto_17_5_alc());
        stmt.setDouble(15, pr.getPrecocusto_18_alc());
        stmt.setDouble(16, pr.getPrecovenda_0());
        stmt.setDouble(17, pr.getPrecovenda_12());
        stmt.setDouble(18, pr.getPrecovenda_17());
        stmt.setDouble(19, pr.getPrecovenda_17_5());
        stmt.setDouble(20, pr.getPrecovenda_18());
        stmt.setDouble(21, pr.getPrecovenda_19());
        stmt.setDouble(22, pr.getPrecovenda_20());
        stmt.setDouble(23, pr.getPrecovenda_21());
        stmt.setDouble(24, pr.getPrecovenda_22());
        stmt.setDouble(25, pr.getPrecovenda_17_alc());
        stmt.setDouble(26, pr.getPrecovenda_17_5_alc());
        stmt.setDouble(27, pr.getPrecovenda_18_alc());
        stmt.setString(28, atualizar);
        stmt.execute();
        stmt.close();

    }

    public ProdutoPreco getProdutoPreco(Produto p, Versao v) throws Exception {
        ProdutoPreco pr = new ProdutoPreco();
        stmt = getConnection().prepareStatement("select * from produtopreco where id_produto = '" + p.getId() + "' and id_versao = '" + v.getId() + "';");
        rs = stmt.executeQuery();

        while (rs.next()) {
            pr.setId(rs.getInt("id"));
            pr.setId_versao(rs.getInt("id_versao"));
            pr.setId_produto(rs.getInt("id_produto"));
            pr.setPrecocusto_sem_imposto(rs.getDouble("precocusto_sem_imposto"));
            pr.setPrecocusto_0(rs.getDouble("precocusto_0"));
            pr.setPrecocusto_12(rs.getDouble("precocusto_12"));
            pr.setPrecocusto_17(rs.getDouble("precocusto_17"));
            pr.setPrecocusto_17_5(rs.getDouble("precocusto_17_5"));
            pr.setPrecocusto_18(rs.getDouble("precocusto_18"));
            pr.setPrecocusto_19(rs.getDouble("precocusto_19"));
            pr.setPrecocusto_20(rs.getDouble("precocusto_20"));
            pr.setPrecocusto_21(rs.getDouble("precocusto_21"));
            pr.setPrecocusto_22(rs.getDouble("precocusto_22"));
            pr.setPrecocusto_17_alc(rs.getDouble("precocusto_17_alc"));
            pr.setPrecocusto_17_5_alc(rs.getDouble("precocusto_17_5_alc"));
            pr.setPrecocusto_18_alc(rs.getDouble("precocusto_18_alc"));
            pr.setPrecovenda_0(rs.getDouble("precovenda_0"));
            pr.setPrecovenda_12(rs.getDouble("precovenda_12"));
            pr.setPrecovenda_17(rs.getDouble("precovenda_17"));
            pr.setPrecovenda_17_5(rs.getDouble("precovenda_17_5"));
            pr.setPrecovenda_18(rs.getDouble("precovenda_18"));
            pr.setPrecovenda_19(rs.getDouble("precovenda_19"));
            pr.setPrecovenda_20(rs.getDouble("precovenda_20"));
            pr.setPrecovenda_21(rs.getDouble("precovenda_21"));
            pr.setPrecovenda_22(rs.getDouble("precovenda_22"));
            pr.setPrecovenda_17_alc(rs.getDouble("precovenda_17_alc"));
            pr.setPrecovenda_17_5_alc(rs.getDouble("precovenda_17_5_alc"));
            pr.setPrecovenda_18_alc(rs.getDouble("precovenda_18_alc"));
            pr.setAtualizar(rs.getString("atualizar"));
        }
        stmt.close();
        rs.close();
        return pr;
    }

    public ArrayList<ProdutoPreco> listaProdutoPreco(int id_produto, int id_versao) throws Exception {
        ProdutoPreco pr;
        ArrayList<ProdutoPreco> listaPreco = new ArrayList<>();

        stmt = getConnection().prepareStatement("select * from produtopreco where id_produto = '" + id_produto + "' and id_versao = '" + id_versao + "';");
        rs = stmt.executeQuery();

        while (rs.next()) {
            pr = new ProdutoPreco();
            pr.setId(rs.getInt("id"));
            pr.setId_versao(rs.getInt("id_versao"));
            pr.setId_produto(rs.getInt("id_produto"));
            pr.setPrecocusto_sem_imposto(rs.getDouble("precocusto_sem_imposto"));
            pr.setPrecocusto_0(rs.getDouble("precocusto_0"));
            pr.setPrecocusto_12(rs.getDouble("precocusto_12"));
            pr.setPrecocusto_17(rs.getDouble("precocusto_17"));
            pr.setPrecocusto_17_5(rs.getDouble("precocusto_17_5"));
            pr.setPrecocusto_18(rs.getDouble("precocusto_18"));
            pr.setPrecocusto_19(rs.getDouble("precocusto_19"));
            pr.setPrecocusto_20(rs.getDouble("precocusto_20"));
            pr.setPrecocusto_21(rs.getDouble("precocusto_21"));
            pr.setPrecocusto_22(rs.getDouble("precocusto_22"));
            pr.setPrecocusto_17_alc(rs.getDouble("precocusto_17_alc"));
            pr.setPrecocusto_17_5_alc(rs.getDouble("precocusto_17_5_alc"));
            pr.setPrecocusto_18_alc(rs.getDouble("precocusto_18_alc"));
            pr.setPrecovenda_0(rs.getDouble("precovenda_0"));
            pr.setPrecovenda_12(rs.getDouble("precovenda_12"));
            pr.setPrecovenda_17(rs.getDouble("precovenda_17"));
            pr.setPrecovenda_17_5(rs.getDouble("precovenda_17_5"));
            pr.setPrecovenda_18(rs.getDouble("precovenda_18"));
            pr.setPrecovenda_19(rs.getDouble("precovenda_19"));
            pr.setPrecovenda_20(rs.getDouble("precovenda_20"));
            pr.setPrecovenda_21(rs.getDouble("precovenda_21"));
            pr.setPrecovenda_22(rs.getDouble("precovenda_22"));
            pr.setPrecovenda_17_alc(rs.getDouble("precovenda_17_alc"));
            pr.setPrecovenda_17_5_alc(rs.getDouble("precovenda_17_5_alc"));
            pr.setPrecovenda_18_alc(rs.getDouble("precovenda_18_alc"));
            listaPreco.add(pr);
        }
        stmt.close();
        rs.close();
        return listaPreco;
    }

    public ArrayList<ProdutoPreco> listaProdutoPreco(int id_versao) throws Exception {
        ProdutoPreco pr;
        ArrayList<ProdutoPreco> listaPreco = new ArrayList<>();

        stmt = getConnection().prepareStatement("select * from produtopreco where id_versao = '" + id_versao + "';");
        rs = stmt.executeQuery();

        while (rs.next()) {
            pr = new ProdutoPreco();
            pr.setId(rs.getInt("id"));
            pr.setId_versao(rs.getInt("id_versao"));
            pr.setId_produto(rs.getInt("id_produto"));
            pr.setPrecocusto_sem_imposto(rs.getDouble("precocusto_sem_imposto"));
            pr.setPrecocusto_0(rs.getDouble("precocusto_0"));
            pr.setPrecocusto_12(rs.getDouble("precocusto_12"));
            pr.setPrecocusto_17(rs.getDouble("precocusto_17"));
            pr.setPrecocusto_17_5(rs.getDouble("precocusto_17_5"));
            pr.setPrecocusto_18(rs.getDouble("precocusto_18"));
            pr.setPrecocusto_19(rs.getDouble("precocusto_19"));
            pr.setPrecocusto_20(rs.getDouble("precocusto_20"));
            pr.setPrecocusto_21(rs.getDouble("precocusto_21"));
            pr.setPrecocusto_22(rs.getDouble("precocusto_22"));
            pr.setPrecocusto_17_alc(rs.getDouble("precocusto_17_alc"));
            pr.setPrecocusto_17_5_alc(rs.getDouble("precocusto_17_5_alc"));
            pr.setPrecocusto_18_alc(rs.getDouble("precocusto_18_alc"));
            pr.setPrecovenda_0(rs.getDouble("precovenda_0"));
            pr.setPrecovenda_12(rs.getDouble("precovenda_12"));
            pr.setPrecovenda_17(rs.getDouble("precovenda_17"));
            pr.setPrecovenda_17_5(rs.getDouble("precovenda_17_5"));
            pr.setPrecovenda_18(rs.getDouble("precovenda_18"));
            pr.setPrecovenda_19(rs.getDouble("precovenda_19"));
            pr.setPrecovenda_20(rs.getDouble("precovenda_20"));
            pr.setPrecovenda_21(rs.getDouble("precovenda_21"));
            pr.setPrecovenda_22(rs.getDouble("precovenda_22"));
            pr.setPrecovenda_17_alc(rs.getDouble("precovenda_17_alc"));
            pr.setPrecovenda_17_5_alc(rs.getDouble("precovenda_17_5_alc"));
            pr.setPrecovenda_18_alc(rs.getDouble("precovenda_18_alc"));
            listaPreco.add(pr);
        }
        stmt.close();
        rs.close();
        return listaPreco;
    }
}
