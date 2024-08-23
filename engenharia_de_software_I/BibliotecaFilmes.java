import java.util.LinkedList;
import java.util.List;

public class BibliotecaFilmes{
    private List<Filme> filmes = new LinkedList<Filme>();

    public void adicionarFilme(Filme filme){
        this.filmes.add(filme);
    }

    public void reomverFilme (Filme filme){
        this.filmes.remove(filme);
    }

    public int getSize(){
        return this.filmes.size();
    }

    public List<Filme> getFilmesPorNome(String nome){
        List<Filme> encontrados = new LinkedList<>(); 
        for (Filme f : this.filmes){
            if (f.getNome().equals(nome)){
                encontrados.add(f);
            }
        }
        return encontrados;
    }

    public List<Filme> getFilmesPorAno(int ano){
        List<Filme> encontrados = new LinkedList<>();
        for (Filme f : this.filmes){
            if (f.getAno() == ano){
                encontrados.add(f);
            }
        }
        return encontrados;
    }

    public List<Filme> getFilmesPorDiretor(String diretor){
        List<Filme> encontrados = new LinkedList<>();
        for (Filme f : this.filmes){
            if (f.getDiretor().equals(diretor)){
                encontrados.add(f);
            }
        }
        return encontrados;
    }

    public Filme getFilme(String nome, String diretor, int ano){
        for (Filme f : this.filmes){
            if (f.getNome().equals(nome) && f.getAno()==ano && f.getDiretor().equals(diretor)){
                return f;
            }
        }
        return null;
    }
}