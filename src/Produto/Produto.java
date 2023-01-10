package Produto;

import Categoria.Categoria;
import Fabricante.Fabricante;

public class Produto {

    private int id;
    private int id_fabricante;
    private int id_categoria;
    private String substancia; //principio ativo
    private String codigo_ggrem;
    private String registro; //RMS
    private String ean1; //codigo de barras primario
    private String ean2; //codigo de barras secundário
    private String ean3; //codigo de barras terciário
    private String produto; //nome do produto
    private String apresentacao;
    private String classe_terapeutica;
    private String regime_preco; //O campo "Regime de Preço" destina-se a prestar informações sobre os medicamentos regulados e os liberados dos critérios de estabelecimento e ajuste de PF, mas sujeito ao monitoramento do PMC, nos termos da Resolução CMED nº 02, de 20 de março de 2019.
    private String restricao_hospitalar; //Medicamentos em embalagens hospitalares e de uso restrito a hospitais e clínicas não podem ser comercializados pelo Preço Máximo ao Consumidor, nos termos da Resolução CMED nº 03, de 04 de maio de 2009.
    private String cap;
    private String confaz_87;
    private String icms_0;
    private String lista;
    private String comercializacao_ano_anterior;
    private String tarja; //Os registros da coluna "Tarja" marcados com (*) contém informação proveniente diretamente dos registros da ANVISA (Datavisa).
//    private double precocusto_sem_imposto;
//    private double precocusto_0;
//    private double precocusto_12;
//    private double precocusto_17;
//    private double precocusto_17_5;
//    private double precocusto_18;
//    private double precocusto_20;
//    private double precocusto_17_alc;
//    private double precocusto_17_5_alc;
//    private double precocusto_18_alc;
//    private double precovenda_0;
//    private double precovenda_12;
//    private double precovenda_17;
//    private double precovenda_17_5;
//    private double precovenda_18;
//    private double precovenda_20;
//    private double precovenda_17_alc;
//    private double precovenda_17_5_alc;
//    private double precovenda_18_alc;

    private Categoria categoria;
    private Fabricante fabricante;
    
    public Produto(){
        id = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_fabricante() {
        return id_fabricante;
    }

    public void setId_fabricante(int id_fabricante) {
        this.id_fabricante = id_fabricante;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getSubstancia() {
        return substancia;
    }

    public void setSubstancia(String substancia) {
        this.substancia = substancia;
    }

    public String getCodigo_ggrem() {
        return codigo_ggrem;
    }

    public void setCodigo_ggrem(String codigo_ggrem) {
        this.codigo_ggrem = codigo_ggrem;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public String getEan1() {
        return ean1;
    }

    public void setEan1(String ean1) {
        this.ean1 = ean1;
    }

    public String getEan2() {
        return ean2;
    }

    public void setEan2(String ean2) {
        this.ean2 = ean2;
    }

    public String getEan3() {
        return ean3;
    }

    public void setEan3(String ean3) {
        this.ean3 = ean3;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getApresentacao() {
        return apresentacao;
    }

    public void setApresentacao(String apresentacao) {
        this.apresentacao = apresentacao;
    }

    public String getClasse_terapeutica() {
        return classe_terapeutica;
    }

    public void setClasse_terapeutica(String classe_terapeutica) {
        this.classe_terapeutica = classe_terapeutica;
    }

    public String getRegime_preco() {
        return regime_preco;
    }

    public void setRegime_preco(String regime_preco) {
        this.regime_preco = regime_preco;
    }

    public String getRestricao_hospitalar() {
        return restricao_hospitalar;
    }

    public void setRestricao_hospitalar(String restricao_hospitalar) {
        this.restricao_hospitalar = restricao_hospitalar;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public String getConfaz_87() {
        return confaz_87;
    }

    public void setConfaz_87(String confaz_87) {
        this.confaz_87 = confaz_87;
    }

    public String getIcms_0() {
        return icms_0;
    }

    public void setIcms_0(String icms_0) {
        this.icms_0 = icms_0;
    }

    public String getLista() {
        return lista;
    }

    public void setLista(String lista) {
        this.lista = lista;
    }

    public String getComercializacao_ano_anterior() {
        return comercializacao_ano_anterior;
    }

    public void setComercializacao_ano_anterior(String comercializacao_ano_anterior) {
        this.comercializacao_ano_anterior = comercializacao_ano_anterior;
    }

    public String getTarja() {
        return tarja;
    }

    public void setTarja(String tarja) {
        this.tarja = tarja;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

}
