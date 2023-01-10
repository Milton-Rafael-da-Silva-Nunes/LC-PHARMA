package Fabricante;

/**
 *
 * @author Fabrício Ventura
 */
public class Fabricante {

    private int id;
    private String nome;
    private String descricao;
    private String cnpj;

    @Override
    public String toString() {
        return "Fabricante{" + "id=" + id + ", nome=" + nome + ", cnpj=" + cnpj + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
