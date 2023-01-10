package Util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;

public class LerXlsEscreverTxt {

    // sheet = folha
    //   row = linha
    //colunm = coluna
    public void gerar(String icms, String vigencia) {
        System.out.println(icms + " " + vigencia);
        try {
            File fileXLS = new File(".\\arquivo\\teste.xls");

            File fileTXT = new File(".\\arquivo\\PROBARRA_NEW17.txt");
            fileTXT.delete();

            WorkbookSettings conf = new WorkbookSettings();
            conf.setEncoding("ISO-8859-1");

            Workbook workbook = Workbook.getWorkbook(fileXLS, conf);
            Sheet sheet = workbook.getSheet(0);

            FileWriter arq = new FileWriter(fileTXT, true);

            PrintWriter gravarArq = new PrintWriter(fileTXT, "ISO-8859-1");

            String codigo = null;
            String digito = null;
            Cell nome = null; //8
            String codigoFab = null;
            Cell nomeFab = null; //2
            Cell apresentacao = null;
            Cell precoVenda = null;
            String precoFracao = null;
            String qtd_fracionada = null;
            Cell tabela = null; // verificar
            String portaria = null;
            String edicao = null;
            String dataVigencia = null;
            Cell precoCusto = null;
            Cell codigoBarras = null;
            String alicotaICMS = null;
            String tipo = null;
            Cell principioAtivo = null; //0

            //validacao
            Cell restricao_hospitalar; //0
            Cell icms_zero; //0

            int linhas = sheet.getRows();

            String escreva;

            for (int i = 1; i < linhas; i++) {

                restricao_hospitalar = sheet.getCell(38, i);
                icms_zero = sheet.getCell(41, i);

                codigo = "";
                digito = " ";
                nome = sheet.getCell(8, i);
                codigoFab = "";
                nomeFab = sheet.getCell(2, i);
                apresentacao = sheet.getCell(9, i);
                precoFracao = "";
                qtd_fracionada = "0";
                tabela = sheet.getCell(12, i);
                portaria = "";
                edicao = "284";
                dataVigencia = Funcoes.formataData(vigencia, "E", false);
                codigoBarras = sheet.getCell(5, i);
                alicotaICMS = "";
                tipo = "0";
                principioAtivo = sheet.getCell(0, i);

                if (icms_zero.getContents().equals("Sim")) {
                    precoCusto = sheet.getCell(14, i);
                    precoVenda = sheet.getCell(26, i);
                    alicotaICMS = "0,00";

                } else {
                    switch (icms) {
                        case "12,00":
                            precoCusto = sheet.getCell(15, i);
                            precoVenda = sheet.getCell(27, i);
                            alicotaICMS = "12";
                            break;
                        case "17,00":
                            precoCusto = sheet.getCell(16, i);
                            precoVenda = sheet.getCell(28, i);
                            alicotaICMS = "17,00";
                            break;
                        case "17,50":
                            precoCusto = sheet.getCell(18, i);
                            precoVenda = sheet.getCell(30, i);
                            alicotaICMS = "17,50";
                            break;
                        case "18,00":
                            precoCusto = sheet.getCell(20, i);
                            precoVenda = sheet.getCell(32, i);
                            alicotaICMS = "18,00";
                            break;
                        case "19,00":
                            precoCusto = sheet.getCell(22, i);
                            precoVenda = sheet.getCell(34, i);
                            alicotaICMS = "19,00";
                            break;
                        case "20,00":
                            precoCusto = sheet.getCell(22, i);
                            precoVenda = sheet.getCell(31, i);
                            alicotaICMS = "20,00";
                            break;
                        case "21,00":
                            precoCusto = sheet.getCell(24, i);
                            precoVenda = sheet.getCell(36, i);
                            alicotaICMS = "21,00";
                            break;
                        case "22,00":
                            precoCusto = sheet.getCell(25, i);
                            precoVenda = sheet.getCell(37, i);
                            alicotaICMS = "22,00";
                            break;
                        /*case "12,00_alc":
                            precoCusto = sheet.getCell(15, i);
                            precoVenda = sheet.getCell(24, i);
                            alicotaICMS = "12,00";
                            break;*/
                        case "17,00_alc":
                            precoCusto = sheet.getCell(17, i);
                            precoVenda = sheet.getCell(29, i);
                            alicotaICMS = "17,00";
                            break;
                        case "17,50_alc":
                            precoCusto = sheet.getCell(19, i);
                            precoVenda = sheet.getCell(31, i);
                            alicotaICMS = "17,50";
                            break;
                        case "18,00_alc":
                            precoCusto = sheet.getCell(21, i);
                            precoVenda = sheet.getCell(33, i);
                            alicotaICMS = "18,00";
                            break;
                        /*case "20,00_alc":
                            precoCusto = sheet.getCell(22, i);
                            precoVenda = sheet.getCell(31, i);
                            alicotaICMS = "20,00";
                            break;*/
                        default:
                            break;
                    }
                }

                if (!restricao_hospitalar.getContents().equals("Sim") && !nome.getContents().equals("")) {
                    escreva = Funcoes.removeAcentos(Funcoes.AdicionaEspaco(codigo, "E", 6) + Funcoes.AdicionaEspaco(digito, "E", 1) + Funcoes.AdicionaEspaco(nome.getContents().replaceFirst(" ", "").replace("™ ", " "), "D", 16) + Funcoes.AdicionaEspaco(codigoFab, "E", 10) + Funcoes.AdicionaEspaco(nomeFab.getContents(), "D", 10) + Funcoes.AdicionaEspaco(apresentacao.getContents(), "D", 15) + Funcoes.AdicionaEspaco(precoVenda.getContents().replace(",", "."), "E", 10) + Funcoes.AdicionaEspaco(precoFracao, "E", 10) + Funcoes.AdicionaEspaco(qtd_fracionada, "E", 3) + (tabela.getContents().equals("Regulado") ? Funcoes.AdicionaEspaco("0", "E", 1) : Funcoes.AdicionaEspaco("1", "E", 1)) + Funcoes.AdicionaEspaco(portaria, "E", 3) + Funcoes.AdicionaEspaco(edicao, "E", 3) + Funcoes.AdicionaEspaco(dataVigencia, "E", 8) + Funcoes.AdicionaEspaco(precoCusto.getContents().replace(",", "."), "E", 10) + Funcoes.AdicionaEspaco(codigoBarras.getContents(), "E", 14) + Funcoes.AdicionaEspaco(alicotaICMS, "E", 2) + Funcoes.AdicionaEspaco(tipo, "E", 1) + Funcoes.AdicionaEspaco(principioAtivo.getContents(), "D", 52));
                    System.out.println(escreva);
                    gravarArq.println(escreva);
                }

            }

            arq.close();
            workbook.close();

        } catch (IOException | BiffException ex) {
            Logger.getLogger(LerXlsEscreverTxt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void gerarArquivo(String icms, String vigencia, String versao) {
        System.out.println(icms + " " + vigencia + " " + versao);
        try {
            File fileXLS = new File(".\\arquivo\\teste.xls");
            File fileTXT = new File(".\\arquivo\\PROBARRA_NEW17.txt");
            fileTXT.delete();

            WorkbookSettings conf = new WorkbookSettings();
            conf.setEncoding("ISO-8859-1");

            Workbook workbook = Workbook.getWorkbook(fileXLS, conf);
            Sheet sheet = workbook.getSheet(0);

            FileWriter arq = new FileWriter(fileTXT, true);

            PrintWriter gravarArq = new PrintWriter(fileTXT, "ISO-8859-1");

            Cell principioAtivo = null;
            Cell nomeFabricante = null;
            Cell registroMS = null;
            Cell codigoBarras = null;
            Cell nomeProduto = null;
            Cell descricaoProduto = null;
            Cell nomeCategoria = null;
            Cell tipoPreco = null;
            Cell precoCusto = null;
            Cell precoVenda = null;
            Cell tipoLista = null;
            String dataVigencia = vigencia;
            String versaoArquivo = versao;
            String aliquotaICMS = "";

            //validacao
            Cell restricao_hospitalar; //0
            Cell icms_zero; //0

            //controle
            int linhas = sheet.getRows();
            String escreva;

            for (int i = 1; i < linhas; i++) {

                restricao_hospitalar = sheet.getCell(38, i);
                icms_zero = sheet.getCell(41, i);

                //
                //
                principioAtivo = sheet.getCell(0, i); //ok
                nomeFabricante = sheet.getCell(2, i); //ok
                registroMS = sheet.getCell(4, i); //ok
                codigoBarras = sheet.getCell(5, i); //ok
                nomeProduto = sheet.getCell(8, i); //ok
                descricaoProduto = sheet.getCell(9, i); //ok
                nomeCategoria = sheet.getCell(11, i); //ok
                tipoPreco = sheet.getCell(12, i); //ok
                tipoLista = sheet.getCell(43, i); //ok
                //
                //

                if (icms_zero.getContents().equals("Sim")) {
                    precoCusto = sheet.getCell(14, i);
                    precoVenda = sheet.getCell(26, i);
                    aliquotaICMS = "0,00";

                } else {
                    switch (icms) {
                        case "12,00":
                            precoCusto = sheet.getCell(15, i);
                            precoVenda = sheet.getCell(27, i);
                            aliquotaICMS = "12,00";
                            break;
                        case "17,00":
                            precoCusto = sheet.getCell(16, i);
                            precoVenda = sheet.getCell(28, i);
                            aliquotaICMS = "17,00";
                            break;
                        case "17,50":
                            precoCusto = sheet.getCell(18, i);
                            precoVenda = sheet.getCell(30, i);
                            aliquotaICMS = "17,50";
                            break;
                        case "18,00":
                            precoCusto = sheet.getCell(20, i);
                            precoVenda = sheet.getCell(32, i);
                            aliquotaICMS = "18,00";
                            break;
                        case "19,00":
                            precoCusto = sheet.getCell(22, i);
                            precoVenda = sheet.getCell(34, i);
                            aliquotaICMS = "19,00";
                            break;
                        case "20,00":
                            precoCusto = sheet.getCell(23, i);
                            precoVenda = sheet.getCell(35, i);
                            aliquotaICMS = "20,00";
                            break;
                        case "21,00":
                            precoCusto = sheet.getCell(24, i);
                            precoVenda = sheet.getCell(36, i);
                            aliquotaICMS = "21,00";
                            break;
                        case "22,00":
                            precoCusto = sheet.getCell(25, i);
                            precoVenda = sheet.getCell(37, i);
                            aliquotaICMS = "22,00";
                            break;
                        /*case "12,00_alc":
                            precoCusto = sheet.getCell(15, i);
                            precoVenda = sheet.getCell(24, i);
                            aliquotaICMS = "12,00";
                            break;*/
                        case "17,00_alc":
                            precoCusto = sheet.getCell(17, i);
                            precoVenda = sheet.getCell(29, i);
                            aliquotaICMS = "17,00";
                            break;
                        case "17,50_alc":
                            precoCusto = sheet.getCell(19, i);
                            precoVenda = sheet.getCell(31, i);
                            aliquotaICMS = "17,50";
                            break;
                        case "18,00_alc":
                            precoCusto = sheet.getCell(21, i);
                            precoVenda = sheet.getCell(33, i);
                            aliquotaICMS = "18,00";
                            break;
                        /*case "20,00_alc":
                            precoCusto = sheet.getCell(22, i);
                            precoVenda = sheet.getCell(31, i);
                            aliquotaICMS = "20,00";
                            break;*/
                        default:
                            break;
                    }
                }

                if (!restricao_hospitalar.getContents().equals("Sim") && !nomeProduto.getContents().equals("")) {
                    escreva = Funcoes.removeAcentos(
                            Funcoes.AdicionaEspaco(codigoBarras.getContents(), "D", 13) + " "
                            + Funcoes.AdicionaEspaco(registroMS.getContents(), "E", 13) + " "
                            + Funcoes.AdicionaEspaco(nomeProduto.getContents(), "D", 50) + " "
                            + Funcoes.AdicionaEspaco(descricaoProduto.getContents(), "D", 25) + " "
                            + Funcoes.AdicionaEspaco(principioAtivo.getContents(), "D", 50) + " "
                            + Funcoes.AdicionaEspaco(nomeFabricante.getContents(), "D", 25) + " "
                            + Funcoes.AdicionaEspaco(nomeCategoria.getContents(), "D", 25) + " "
                            + Funcoes.AdicionaEspaco(tipoPreco.getContents().equals("Regulado") ? "MONITORADO" : "LIBERADO", "D", 11) + " "
                            + Funcoes.AdicionaEspaco(tipoLista.getContents(), "D", 11) + " "
                            + Funcoes.AdicionaEspaco(aliquotaICMS.replace(",", "."), "E", 10) + " "
                            + Funcoes.AdicionaEspaco(precoCusto.getContents().replace(",", "."), "E", 10) + " "
                            + Funcoes.AdicionaEspaco(precoVenda.getContents().replace(",", "."), "E", 10) + " "
                            + Funcoes.AdicionaEspaco(versaoArquivo, "E", 3) + " "
                            + Funcoes.AdicionaEspaco(vigencia, "E", 8));

                    System.out.println(escreva);
                    gravarArq.println(escreva);
                }

            }

            arq.close();
            workbook.close();

        } catch (IOException | BiffException ex) {
            Logger.getLogger(LerXlsEscreverTxt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
