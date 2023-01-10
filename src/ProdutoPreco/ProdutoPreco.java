package ProdutoPreco;

import Produto.Produto;
import Versao.Versao;

/**
 *
 * @author Fabricio Ventura
 */
public class ProdutoPreco {

    private int id;
    private int id_versao;
    private int id_produto;
    private double precocusto_sem_imposto;
    private double precocusto_0;
    private double precocusto_12;
    private double precocusto_17;
    private double precocusto_17_5;
    private double precocusto_18;
    private double precocusto_19;
    private double precocusto_20;
    private double precocusto_21;
    private double precocusto_22;
    private double precocusto_17_alc;
    private double precocusto_17_5_alc;
    private double precocusto_18_alc;
    private double precovenda_0;
    private double precovenda_12;
    private double precovenda_17;
    private double precovenda_17_5;
    private double precovenda_18;
    private double precovenda_19;
    private double precovenda_20;
    private double precovenda_21;
    private double precovenda_22;
    private double precovenda_17_alc;
    private double precovenda_17_5_alc;
    private double precovenda_18_alc;
    private String atualizar;

    private Produto produto;
    private Versao versao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_versao() {
        return id_versao;
    }

    public void setId_versao(int id_versao) {
        this.id_versao = id_versao;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public double getPrecocusto_sem_imposto() {
        return precocusto_sem_imposto;
    }

    public void setPrecocusto_sem_imposto(double precocusto_sem_imposto) {
        this.precocusto_sem_imposto = precocusto_sem_imposto;
    }

    public double getPrecocusto_0() {
        return precocusto_0;
    }

    public void setPrecocusto_0(double precocusto_0) {
        this.precocusto_0 = precocusto_0;
    }

    public double getPrecocusto_12() {
        return precocusto_12;
    }

    public void setPrecocusto_12(double precocusto_12) {
        this.precocusto_12 = precocusto_12;
    }

    public double getPrecocusto_17() {
        return precocusto_17;
    }

    public void setPrecocusto_17(double precocusto_17) {
        this.precocusto_17 = precocusto_17;
    }

    public double getPrecocusto_17_5() {
        return precocusto_17_5;
    }

    public void setPrecocusto_17_5(double precocusto_17_5) {
        this.precocusto_17_5 = precocusto_17_5;
    }

    public double getPrecocusto_18() {
        return precocusto_18;
    }

    public void setPrecocusto_18(double precocusto_18) {
        this.precocusto_18 = precocusto_18;
    }

    public double getPrecocusto_19() {
        return precocusto_19;
    }

    public void setPrecocusto_19(double precocusto_19) {
        this.precocusto_19 = precocusto_19;
    }

    public double getPrecocusto_20() {
        return precocusto_20;
    }

    public void setPrecocusto_20(double precocusto_20) {
        this.precocusto_20 = precocusto_20;
    }

    public double getPrecocusto_21() {
        return precocusto_21;
    }

    public void setPrecocusto_21(double precocusto_21) {
        this.precocusto_21 = precocusto_21;
    }

    public double getPrecocusto_22() {
        return precocusto_22;
    }

    public void setPrecocusto_22(double precocusto_22) {
        this.precocusto_22 = precocusto_22;
    }

    public double getPrecocusto_17_alc() {
        return precocusto_17_alc;
    }

    public void setPrecocusto_17_alc(double precocusto_17_alc) {
        this.precocusto_17_alc = precocusto_17_alc;
    }

    public double getPrecocusto_17_5_alc() {
        return precocusto_17_5_alc;
    }

    public void setPrecocusto_17_5_alc(double precocusto_17_5_alc) {
        this.precocusto_17_5_alc = precocusto_17_5_alc;
    }

    public double getPrecocusto_18_alc() {
        return precocusto_18_alc;
    }

    public void setPrecocusto_18_alc(double precocusto_18_alc) {
        this.precocusto_18_alc = precocusto_18_alc;
    }

    public double getPrecovenda_0() {
        return precovenda_0;
    }

    public void setPrecovenda_0(double precovenda_0) {
        this.precovenda_0 = precovenda_0;
    }

    public double getPrecovenda_12() {
        return precovenda_12;
    }

    public void setPrecovenda_12(double precovenda_12) {
        this.precovenda_12 = precovenda_12;
    }

    public double getPrecovenda_17() {
        return precovenda_17;
    }

    public void setPrecovenda_17(double precovenda_17) {
        this.precovenda_17 = precovenda_17;
    }

    public double getPrecovenda_17_5() {
        return precovenda_17_5;
    }

    public void setPrecovenda_17_5(double precovenda_17_5) {
        this.precovenda_17_5 = precovenda_17_5;
    }

    public double getPrecovenda_18() {
        return precovenda_18;
    }

    public void setPrecovenda_18(double precovenda_18) {
        this.precovenda_18 = precovenda_18;
    }

    public double getPrecovenda_19() {
        return precovenda_19;
    }

    public void setPrecovenda_19(double precovenda_19) {
        this.precovenda_19 = precovenda_19;
    }

    public double getPrecovenda_20() {
        return precovenda_20;
    }

    public void setPrecovenda_20(double precovenda_20) {
        this.precovenda_20 = precovenda_20;
    }

    public double getPrecovenda_21() {
        return precovenda_21;
    }

    public void setPrecovenda_21(double precovenda_21) {
        this.precovenda_21 = precovenda_21;
    }

    public double getPrecovenda_22() {
        return precovenda_22;
    }

    public void setPrecovenda_22(double precovenda_22) {
        this.precovenda_22 = precovenda_22;
    }

    public double getPrecovenda_17_alc() {
        return precovenda_17_alc;
    }

    public void setPrecovenda_17_alc(double precovenda_17_alc) {
        this.precovenda_17_alc = precovenda_17_alc;
    }

    public double getPrecovenda_17_5_alc() {
        return precovenda_17_5_alc;
    }

    public void setPrecovenda_17_5_alc(double precovenda_17_5_alc) {
        this.precovenda_17_5_alc = precovenda_17_5_alc;
    }

    public double getPrecovenda_18_alc() {
        return precovenda_18_alc;
    }

    public void setPrecovenda_18_alc(double precovenda_18_alc) {
        this.precovenda_18_alc = precovenda_18_alc;
    }

    public String getAtualizar() {
        return atualizar;
    }

    public void setAtualizar(String atualizar) {
        this.atualizar = atualizar;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Versao getVersao() {
        return versao;
    }

    public void setVersao(Versao versao) {
        this.versao = versao;
    }

    
}
