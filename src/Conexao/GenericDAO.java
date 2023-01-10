package Conexao;

import Util.Funcoes;
import com.mysql.jdbc.CommunicationsException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class GenericDAO {

    private static Connection com;
    private final String driver = "com.mysql.jdbc.Driver";
    private final String usuario = "root";
    private final String senha = "03310103";
    private final String porta = "3306";
    private static boolean podeConectar = false;

    public GenericDAO() {
    }

    public boolean isValidaConexaoServidor() {
        try {
            return com.isValid(5000);
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.GenericDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public Connection getConnection() {
        if (com == null) {
            podeConectar = true;
        } else if (!isValidaConexaoServidor()) {
            podeConectar = true;
        }
        if (podeConectar) {
            do {
                if (abrirConexao()) {
                    useLCSistemas();
                    podeConectar = false;
                    break;
                }
                JOptionPane.showMessageDialog(null, "Falha ao conectar com o servidor...");
                System.exit(0);
            } while (true);
        }
        return com;
    }

    private boolean abrirConexao() {
        try {
            String url = (new StringBuilder()).append("jdbc:mysql://").append(Funcoes.getIpServidor()).append(":").append("3306").toString();
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            com = DriverManager.getConnection(url, "root", "03310103");
            return true;
        } catch (CommunicationsException ex) {
            return false;
        } catch (SQLException ex) {
            return false;
        } catch (Exception ex) {
            return false;
        }
    }

    public void fechaConexao() {
        try {
            com.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.GenericDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean executarSql(String sql) throws Exception {
        PreparedStatement stmt = getConnection().prepareStatement(sql);
        boolean execute = stmt.execute();
        stmt.close();
        return execute;
    }

    public void useLCSistemas() {
        try {
            PreparedStatement stmt = com.prepareStatement("use lc_pharma");
            stmt.execute();
            stmt.close();
        } catch (Exception ex) {
            Logger.getLogger(Conexao.GenericDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet pesquisar(String sql) throws Exception {
        PreparedStatement statement = getConnection().prepareStatement(sql);
        ResultSet resultado = statement.executeQuery();
        return resultado;
    }
}
