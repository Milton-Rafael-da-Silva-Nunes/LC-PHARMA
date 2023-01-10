package Produto;

import Categoria.CategoriaDAO;
import Conexao.GenericDAO;
import Fabricante.FabricanteDAO;
import ProdutoPreco.ProdutoPreco;
import Util.Funcoes;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProdutoDAO extends GenericDAO {

//    PreparedStatement stmt = null;
//    ResultSet rs = null;
    FabricanteDAO fabricanteDAO = new FabricanteDAO();
    CategoriaDAO categoriaDAO = new CategoriaDAO();

    public void insertProduto(Produto p) throws Exception {
        PreparedStatement stmt;
        stmt = getConnection().prepareStatement("INSERT INTO produto(id_fabricante, id_categoria, substancia, codigo_ggrem, registro, ean1, ean2, ean3, produto, apresentacao, classe_terapeutica, regime_preco, restricao_hospitalar, cap, confaz_87, icms_0, lista, comercializacao_ano_anterior, tarja) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
        stmt.setInt(1, p.getId_fabricante());
        stmt.setInt(2, p.getId_categoria());
        stmt.setString(3, p.getSubstancia());
        stmt.setString(4, p.getCodigo_ggrem());
        stmt.setString(5, p.getRegistro());
        stmt.setString(6, p.getEan1());
        stmt.setString(7, p.getEan2());
        stmt.setString(8, p.getEan3());
        stmt.setString(9, p.getProduto());
        stmt.setString(10, p.getApresentacao());
        stmt.setString(11, p.getClasse_terapeutica());
        stmt.setString(12, p.getRegime_preco());
        stmt.setString(13, p.getRestricao_hospitalar());
        stmt.setString(14, p.getCap());
        stmt.setString(15, p.getConfaz_87());
        stmt.setString(16, p.getIcms_0());
        stmt.setString(17, p.getLista());
        stmt.setString(18, p.getComercializacao_ano_anterior());
        stmt.setString(19, p.getTarja());
        stmt.executeUpdate();
        stmt.close();
        p.setId(Funcoes.getUltimoId());
    }

    public void updateProduto(Produto p, String codigo_ggrem) throws Exception {
        PreparedStatement stmt;
//        stmt = getConnection().prepareStatement("update produto set id_fabricante = ? , id_categoria = ? , substancia = ? , codigo_ggrem = ? , registro = ? , ean2 = ? , ean3 = ? , produto = ? , apresentacao = ? , classe_terapeutica = ? , regime_preco = ? , restricao_hospitalar = ? , cap = ? , confaz_87 = ? , icms_0 = ? , lista = ? , comercializacao_ano_anterior = ? , tarja = ? where ean1 = '" + codigo_barras + "';");
        stmt = getConnection().prepareStatement("update produto set id_fabricante = ? , id_categoria = ? , substancia = ? , codigo_ggrem = ? , registro = ? , ean2 = ? , ean3 = ? , produto = ? , apresentacao = ? , classe_terapeutica = ? , regime_preco = ? , restricao_hospitalar = ? , cap = ? , confaz_87 = ? , icms_0 = ? , lista = ? , comercializacao_ano_anterior = ? , tarja = ? where codigo_ggrem = '" + codigo_ggrem + "';");
        stmt.setInt(1, p.getId_fabricante());
        stmt.setInt(2, p.getId_categoria());
        stmt.setString(3, p.getSubstancia());
        stmt.setString(4, p.getCodigo_ggrem());
        stmt.setString(5, p.getRegistro());
        stmt.setString(6, p.getEan2());
        stmt.setString(7, p.getEan3());
        stmt.setString(8, p.getProduto());
        stmt.setString(9, p.getApresentacao());
        stmt.setString(10, p.getClasse_terapeutica());
        stmt.setString(11, p.getRegime_preco());
        stmt.setString(12, p.getRestricao_hospitalar());
        stmt.setString(13, p.getCap());
        stmt.setString(14, p.getConfaz_87());
        stmt.setString(15, p.getIcms_0());
        stmt.setString(16, p.getLista());
        stmt.setString(17, p.getComercializacao_ano_anterior());
        stmt.setString(18, p.getTarja());
        stmt.executeUpdate();
        stmt.close();
    }

    public void insereProdutoPreco(ProdutoPreco pr, Produto produto, String atualizar) throws Exception {
        PreparedStatement stmt;
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

    public boolean isExisteProduto(String codigo_barras) throws Exception {
        PreparedStatement stmt;
        stmt = getConnection().prepareStatement("select * from produto where ean1 = '" + codigo_barras + "';");
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            stmt.close();
            rs.close();
            return true;
        } else {
            stmt.close();
            rs.close();
            return false;
        }
    }

    public Produto getProduto(String codigo_barras) throws Exception {
        PreparedStatement stmt;
        Produto p = new Produto();
        stmt = getConnection().prepareStatement("select * from produto where ean1 = '" + codigo_barras + "';");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            p.setId(rs.getInt("id"));
            p.setId_fabricante(rs.getInt("id_fabricante"));
            p.setId_categoria(rs.getInt("id_categoria"));
            p.setEan1(rs.getString("ean1"));
        }
        stmt.close();
        rs.close();

        return p;
    }

    public ArrayList<String> listaCodigoBarras() throws Exception {
        PreparedStatement stmt;
        ArrayList<String> lista = new ArrayList<>();
        stmt = getConnection().prepareStatement("select * from produto;");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
//            lista.add(rs.getString("ean1"));
            lista.add(rs.getString("codigo_ggrem"));
        }
        stmt.close();
        rs.close();

        return lista;
    }

    public ArrayList<Produto> listaProdutoBarras(String codigo_barras) throws Exception {
        PreparedStatement stmt;
        ArrayList<Produto> lista = new ArrayList<>();
        stmt = getConnection().prepareStatement("select * from produto where ean1 like '" + codigo_barras + "';");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Produto p = new Produto();
            p.setId(rs.getInt("id"));
            p.setId_fabricante(rs.getInt("id_fabricante"));
            p.setId_categoria(rs.getInt("id_categoria"));
            p.setSubstancia(rs.getString("substancia"));
            p.setCodigo_ggrem(rs.getString("codigo_ggrem"));
            p.setRegistro(rs.getString("registro"));
            p.setEan1(rs.getString("ean1"));
            p.setEan2(rs.getString("ean2"));
            p.setEan3(rs.getString("ean3"));
            p.setProduto(rs.getString("produto"));
            p.setApresentacao(rs.getString("apresentacao"));
            p.setClasse_terapeutica(rs.getString("classe_terapeutica"));
            p.setRegime_preco(rs.getString("regime_preco"));
            p.setRestricao_hospitalar(rs.getString("restricao_hospitalar"));
            p.setCap(rs.getString("cap"));
            p.setConfaz_87(rs.getString("confaz_87"));
            p.setIcms_0(rs.getString("icms_0"));
            p.setLista(rs.getString("lista"));
            p.setComercializacao_ano_anterior(rs.getString("comercializacao_ano_anterior"));
            p.setTarja(rs.getString("tarja"));
            p.setCategoria(categoriaDAO.getCategoria(rs.getInt("id_categoria")));
            p.setFabricante(fabricanteDAO.getFabricante(rs.getInt("id_fabricante")));

            lista.add(p);
        }
        stmt.close();
        rs.close();

        return lista;
    }

}
