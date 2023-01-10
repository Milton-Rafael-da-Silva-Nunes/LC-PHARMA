/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

/**
 *
 * @author MIGRAÇÃO-PC
 */
public class RemoverAcentos {

    static String acentuado = "çÇáéíóúýÁÉÍÓÚÝàèìòùÀÈÌÒÙãõñäëïöüÿÄËÏÖÜÃÕÑâêîôûÂÊÎÔÛ";
    static String semAcento = "cCaeiouyAEIOUYaeiouAEIOUaonaeiouyAEIOUAONaeiouAEIOU";
    static char[] tabela;

    static {
        tabela = new char[256];
        for (int i = 0; i < tabela.length; ++i) {
            tabela[i] = (char) i;
        }
        for (int i = 0; i < acentuado.length(); ++i) {
            tabela[acentuado.charAt(i)] = semAcento.charAt(i);
        }
    }

    public static String remover(final String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch < 256) {
                sb.append(tabela[ch]);
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

}
