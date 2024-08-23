public class Filme{
    private String nome;
    private int ano;
    private String diretor;

    public String getNome(){
        return this.nome;
    }

    public int getAno(){
        return this.ano;
    }

    public String getDiretor(){
        return this.diretor;
    }

    public void setNome(String nomeFilme){
        this.nome = nomeFilme;
    }

    public void setAno(int anoFilme){
        this.ano = anoFilme;
    }

    public void setDiretor(String diretorNome){
        this.diretor = diretorNome;
    }
}