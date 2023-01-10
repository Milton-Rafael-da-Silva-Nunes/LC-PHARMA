package Util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class Funcoes {

    public static String removeEspacos(String texto) {
        if (texto != null) {
            texto = texto.replace("                                                                                ", "");
            texto = texto.replace("                                                                               ", "");
            texto = texto.replace("                                                                              ", "");
            texto = texto.replace("                                                                             ", "");
            texto = texto.replace("                                                                            ", "");
            texto = texto.replace("                                                                           ", "");
            texto = texto.replace("                                                                          ", "");
            texto = texto.replace("                                                                         ", "");
            texto = texto.replace("                                                                        ", "");
            texto = texto.replace("                                                                       ", "");
            texto = texto.replace("                                                                      ", "");
            texto = texto.replace("                                                                     ", "");
            texto = texto.replace("                                                                    ", "");
            texto = texto.replace("                                                                   ", "");
            texto = texto.replace("                                                                  ", "");
            texto = texto.replace("                                                                 ", "");
            texto = texto.replace("                                                                ", "");
            texto = texto.replace("                                                               ", "");
            texto = texto.replace("                                                              ", "");
            texto = texto.replace("                                                             ", "");
            texto = texto.replace("                                                            ", "");
            texto = texto.replace("                                                           ", "");
            texto = texto.replace("                                                          ", "");
            texto = texto.replace("                                                         ", "");
            texto = texto.replace("                                                        ", "");
            texto = texto.replace("                                                       ", "");
            texto = texto.replace("                                                      ", "");
            texto = texto.replace("                                                     ", "");
            texto = texto.replace("                                                    ", "");
            texto = texto.replace("                                                   ", "");
            texto = texto.replace("                                                  ", "");
            texto = texto.replace("                                                 ", "");
            texto = texto.replace("                                                ", "");
            texto = texto.replace("                                               ", "");
            texto = texto.replace("                                              ", "");
            texto = texto.replace("                                             ", "");
            texto = texto.replace("                                            ", "");
            texto = texto.replace("                                           ", "");
            texto = texto.replace("                                          ", "");
            texto = texto.replace("                                         ", "");
            texto = texto.replace("                                        ", "");
            texto = texto.replace("                                       ", "");
            texto = texto.replace("                                      ", "");
            texto = texto.replace("                                     ", "");
            texto = texto.replace("                                    ", "");
            texto = texto.replace("                                   ", "");
            texto = texto.replace("                                  ", "");
            texto = texto.replace("                                 ", "");
            texto = texto.replace("                                ", "");
            texto = texto.replace("                               ", "");
            texto = texto.replace("                              ", "");
            texto = texto.replace("                             ", "");
            texto = texto.replace("                            ", "");
            texto = texto.replace("                           ", "");
            texto = texto.replace("                          ", "");
            texto = texto.replace("                         ", "");
            texto = texto.replace("                        ", "");
            texto = texto.replace("                       ", "");
            texto = texto.replace("                      ", "");
            texto = texto.replace("                     ", "");
            texto = texto.replace("                    ", "");
            texto = texto.replace("                   ", "");
            texto = texto.replace("                  ", "");
            texto = texto.replace("                 ", "");
            texto = texto.replace("                ", "");
            texto = texto.replace("               ", "");
            texto = texto.replace("              ", "");
            texto = texto.replace("             ", "");
            texto = texto.replace("            ", "");
            texto = texto.replace("           ", "");
            texto = texto.replace("          ", "");
            texto = texto.replace("         ", "");
            texto = texto.replace("        ", "");
            texto = texto.replace("       ", "");
            texto = texto.replace("      ", "");
            texto = texto.replace("     ", "");
            texto = texto.replace("    ", "");
            texto = texto.replace("   ", "");
            texto = texto.replace("  ", "");

            if (texto.length() < 0) {
                if (texto.substring(0, 1).equals(" ")) {
                    texto = texto.substring(1, texto.length());
                }
                if (texto.substring(texto.length() - 1, texto.length()).equals(" ")) {
                    texto = texto.substring(0, texto.length() - 1);
                }
            }
        } else {
            texto = "";
        }
        return texto;
    }

    public static String removeAcentos(String texto) {
        String acentuado = "çÇáéíóúýÁÉÍÓÚÝàèìòùÀÈÌÒÙãõñäëïöüÿÄËÏÖÜÃÕÑâêîôûÂÊÎÔÛ®";
        String semAcento = "cCaeiouyAEIOUYaeiouAEIOUaonaeiouyAEIOUAONaeiouAEIOU ";
        char[] tabela;

        tabela = new char[256];
        for (int i = 0; i < tabela.length; ++i) {
            tabela[i] = (char) i;
        }
        for (int i = 0; i < acentuado.length(); ++i) {
            tabela[acentuado.charAt(i)] = semAcento.charAt(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < texto.length(); ++i) {
            char ch = texto.charAt(i);
            if (ch < 256) {
                sb.append(tabela[ch]);
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static String AdicionaEspaco(String reg, String formato, int tamanho) {
        String result = reg.trim().replace(" ", "");
        String caractere = "";

        if (result.length() < tamanho) {
            while (result.length() < tamanho) {
                if (formato.equals("E")) {
                    caractere = " ";
                    result = caractere + result;
                } else if (formato.equals("D")) {
                    caractere = " ";
                    result = result + caractere;
                }
            }
        } else {
            result = result.substring(0, tamanho);
        }
        return result;
    }

    public static String formatoDoubleReal2Casas(double valor) {
        DecimalFormat df = new DecimalFormat("#0.00");
        String format = df.format(valor).replace(".", ",");
        return format;
    }

    public static String formatoDouble2Casas(double valor) {
        DecimalFormat df = new DecimalFormat("#0.00");
        String format = df.format(valor);
        return format;
    }

    public static String formatoInteiro3Digitos(int ss) {
        NumberFormat formatter = new DecimalFormat("000");
        return formatter.format(ss);
    }

    public static String formatoInteiro4Digitos(int ss) {
        NumberFormat formatter = new DecimalFormat("0000");
        return formatter.format(ss);
    }

    public static String formataData(String Data, String tipo, boolean setBarras) {
        String data = "";
        if (Data != null) {
            Data = Data.replace("-03:00", "").replace("-04:00", "").replace("-05:00", "").replaceAll("-", "").replaceAll("/", "").replaceAll("T", " ");
            if (tipo.equalsIgnoreCase("B")) {
                if (!setBarras) {
                    data = Data.substring(6, 8) + Data.substring(4, 6) + Data.substring(0, 4);
                } else {
                    data = Data.substring(6, 8) + "/" + Data.substring(4, 6) + "/" + Data.substring(0, 4);
                }
            } else {
                if (!setBarras) {
                    data = Data.substring(4, 8) + Data.substring(2, 4) + Data.substring(0, 2);
                    if (Data.length() == 17) {
                        data += Data.substring(Data.indexOf(" "), Data.length());
                        data = data.replaceAll(":", "");
                        data = data.replaceAll(" ", "");
                    }
                } else {
                    data = Data.substring(4, 8) + "-" + Data.substring(2, 4) + "-" + Data.substring(0, 2);
                }
            }
        }
        data = data.trim();
        if (data.length() == 0) {
            data = null;
        }
        return data;
    }

    public static String formataDataHora(String Data, String tipo, boolean setBarras, boolean setHora) {
        String data = "";
        if (Data != null && !Data.isEmpty()) {
            Data = Data.replace("-03:00", "").replace("-04:00", "").replace("-05:00", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "").replaceAll(" ", "").replaceAll("T", " ");
            if (tipo.equalsIgnoreCase("B")) {
                if (!setBarras) {
                    if (!setHora) {
                        data = Data.substring(6, 8) + Data.substring(4, 6) + Data.substring(0, 4);
                    } else {
                        data = Data.substring(6, 8) + Data.substring(4, 6) + Data.substring(0, 4) + Data.substring(8, 10) + Data.substring(10, 12) + Data.substring(12, 14);
                    }
                } else {
                    if (!setHora) {
                        data = Data.substring(6, 8) + "/" + Data.substring(4, 6) + "/" + Data.substring(0, 4);
                    } else {
                        data = Data.substring(6, 8) + "/" + Data.substring(4, 6) + "/" + Data.substring(0, 4) + " " + Data.substring(8, 10) + ":" + Data.substring(10, 12) + ":" + Data.substring(12, 14);
                    }
                }
            } else {
                if (!setBarras) {
                    if (!setHora) {
                        data = Data.substring(4, 8) + Data.substring(2, 4) + Data.substring(0, 2);
                    } else {
                        data = Data.substring(4, 8) + Data.substring(2, 4) + Data.substring(0, 2) + Data.substring(8, 10) + Data.substring(10, 12) + Data.substring(12, 14);
                    }

                    if (Data.length() == 17) {
                        data += Data.substring(Data.indexOf(" "), Data.length());
                        data = data.replaceAll(":", "");
                        data = data.replaceAll(" ", "");
                    }
                } else {
                    if (!setHora) {
                        data = Data.substring(4, 8) + "-" + Data.substring(2, 4) + "-" + Data.substring(0, 2);
                    } else {
                        data = Data.substring(4, 8) + "-" + Data.substring(2, 4) + "-" + Data.substring(0, 2) + " " + Data.substring(8, 10) + ":" + Data.substring(10, 12) + ":" + Data.substring(12, 14);
                    }
                }
            }
        }
        data = data.trim();
        if (data.length() == 0) {
            data = null;
        }

        return data;
    }

    public static String getIpServidor() throws Exception {
        String linha = "";
        BufferedReader reader = new BufferedReader(new FileReader("rede.txt"));
        linha = reader.readLine();
        if (linha == null) {
            JOptionPane.showMessageDialog(null, "Endereço do Servidor Inválido");
            System.exit(1);
        } else if (linha.trim().length() == 0 || linha.trim().length() < 7) {
            JOptionPane.showMessageDialog(null, " IP do Servidor Inválido !!!\n Verifique (rede.txt)");
            System.exit(1);
        }
        return linha;
    }

    public static String dataHoraAtual() {
        String dt = "";
        Date data = new Date();
        dt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(data);
        return dt;
    }

    public static int getUltimoId() throws Exception {
        int id = 0;

        Connection connection = new Conexao.GenericDAO().getConnection();
        PreparedStatement stmt = connection.prepareStatement("select LAST_INSERT_ID() as id;");
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            id = rs.getInt("id");
        }

        rs.close();
        stmt.close();

        return id;
    }

    public static String cnpjBase(String texto) {
        if (texto.length() > 0) {
            String cnpj;
            cnpj = texto.replaceAll("\\D", "");
            return cnpj.substring(0, 8);
        } else {
            return "";
        }
    }

}
