import java.util.LinkedList;
import java.util.List;

public class SalaAula {
    private List<Aluno> alunos = new LinkedList<>();

    public void adicionarAluno(Aluno novoAluno){
        alunos.add(novoAluno);
    }

    public List<Aluno> buscarAlunoPorNome(String nome){
        List<Aluno> nameList = new LinkedList<>();
        for (Aluno a : this.alunos){
            if (a.getNome().equals(nome)){
                nameList.add(a);
            }
        }
        return nameList;
    }

}