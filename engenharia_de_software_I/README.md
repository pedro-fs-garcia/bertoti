# trecho 1
We see three critical differences between programming and software engineering: time, scale, and the trade-offs at play. On a software engineering project, engineers need to be more concerned with the passage of time and the eventual need for change. In a software engineering organization, we need to be more concerned about scale and efficiency, both for the software we produce as well as for the organization that is producing it. Finally, as software engineers, we are asked to make more complex decisions with higher-stakes outcomes, often based on imprecise estimates of time and growth.
## comentário
Engenharia de software difere de programação em sua visão mais abrangete, que vai desde a preocupação com escala e tempo até a consideração da empresa que está desenvolvendo o software, além de uma visão mais estratégica de como esses aspectos se organizam e se relacionam.

# trecho 2
Within Google, we sometimes say, “Software engineering is programming integrated over time.” Programming is certainly a significant part of software engineering: after all, programming is how you generate new software in the first place. If you accept this distinction, it also becomes clear that we might need to delineate between programming tasks (development) and software engineering tasks (development, modification, maintenance). The addition of time adds an important new dimension to programming. Cubes aren’t squares, distance isn’t velocity. Software engineering isn’t programming.
## comentário
Engenharia de software como uma integral de programação no tempo. Ou seja, um somatório de pequenas partes de código em um dado espaço de tempo. Em engenharia, não se deve considerar a programação em isolado, mas em um contexto multidimensional de componentes

# Trade-offs: Java vs Python
### Desempenho
Python oferece uma sintaxe mais simples e é amplamente utilizado em desenvolvimento rápido. Em situações onde o tempo de resposta não é crítico, Python pode ser uma escolha preferida por sua facilidade de uso. Contudo, Java geralmente oferece um desempenho superior em termos de tempo de resposta e eficiência, especialmente em aplicações que exigem alta performance, como processamento intensivo de dados ou sistemas de tempo real.
### Confiabilidade
A tipagem dinâmica de Python oferece flexibilidade, mas pode introduzir maior risco de erros que só se manifestam em tempo de execução, impactando a confiabilidade. Esse trade-off é relevante em aplicações onde a detecção precoce de erros é fundamental. Por outro lado, a tipagem estática e a verificação em tempo de compilação tornam o código Java mais confiável em ambientes críticos, pois erros de tipo são identificados antes da execução. Isso é particularmente importante em sistemas que não podem abrir mão de robustez e minimização de erros em produção.
### Escalabilidade
Em escala, Python pode enfrentar desafios de desempenho devido à sua menor eficiência em multithreading e ao interpretador Global Interpreter Lock (GIL). Enquanto isso, Java é amplamente utilizado em sistemas de grande escala devido à sua capacidade de lidar eficientemente com múltiplas threads e a facilidade de gerenciar grandes volumes de dados.

# Trade-offs: SQL vs NoSQL
###  Consistência vs. Escalabilidade:
SQL oferece forte consistência e integridade de dados com o modelo ACID, mas é limitado em escalabilidade horizontal. NoSQL escala horizontalmente de forma eficiente, mas pode adotar consistência eventual, o que nem sempre é adequado para todas as aplicações.
### Estrutura de Dados Rígida vs. Flexível:
SQL utiliza esquemas rígidos que garantem a integridade dos dados, mas são menos adaptáveis a mudanças. NoSQL oferece esquemas flexíveis, ideais para dados variados e em evolução, mas com desafios na manutenção da integridade.
### Suporte a Consultas Complexas vs. Simplicidade de Consultas:
SQL suporta consultas complexas e detalhadas, mas pode ser menos eficiente em performance com grandes volumes de dados. NoSQL otimiza operações básicas para alta performance, mas torna consultas complexas mais difíceis e menos eficientes.
### Amadurecimento Tecnológico vs. Inovação:
SQL é uma tecnologia madura com padrões bem estabelecidos, ideal para ambientes empresariais. NoSQL é mais inovador e flexível, mas pode ter menos padrões e maturidade, aumentando o risco em alguns contextos.

# Trade-offs: Windows vs Linux
### Facilidade de Uso vs. Personalização:
Windows é fácil de usar e ideal para iniciantes, com uma interface intuitiva e consistente. Em contrapartida, oferece menos opções de personalização. Linux permite ampla personalização do sistema, mas pode ser mais desafiador para quem está começando.
### Compatibilidade de Software vs. Controle de Sistema:
Windows oferece ampla compatibilidade com softwares, jogos e drivers, sendo a escolha padrão para muitos usuários. No entanto, limita o controle que o usuário tem sobre o sistema. Linux proporciona maior controle e configuração do sistema, mas pode ter menos suporte para software proprietário.
### Custo vs. Suporte Comercial:
Windows é um sistema pago, com suporte comercial robusto e atualizações automáticas. Linux é geralmente gratuito e de código aberto, mas o suporte comercial pode ser limitado, exceto em distribuições empresariais.
### Segurança vs. Familiaridade:
Windows, sendo popular, é um alvo maior para malwares, mas é familiar para a maioria dos usuários. Linux é mais seguro e menos vulnerável a ataques, mas pode exigir adaptação para usuários que vêm de Windows.


# Comparação entre arquiteturas: Youtube vs Netflix



# Classes Filme e BibliotecaFilmes
## classe: Filme
### Atributos:
 - \- nome: String
 - \- ano: int
 - \- diretor: String
### Métodos:
 - \+ getNome(): String
 - \+ getAno(): int
 - \+ getDiretor(): String
 - \+ setNome(String)
 - \+ setAno(int)
 - \+ setDiretor(String)

```
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
```
## classe: BibliotecaFilmes
### atributos:
 - \- Filmes: List
### métodos:
 - \+ adicionarFilme(Filme)
 - \+ removerFilme(Filme)
 - \+ getSize(): int
 - \+ getFilmesPorNome(String): List
 - \+ getFilmesPorAno(int): List
 - \+ getFilmesPorDiretor(String): List
 - \+ getFilme(String, String, int): Filme

```
import java.util.LinkedList;
import java.util.List;

public class BibliotecaFilmes{
    private List<Filme> filmes = new LinkedList<>();

    public void adicionarFilme(Filme filme){
        this.filmes.add(filme);
    }

    public void reomverFilme (Filme filme){
        this.filmes.remove(filme);
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
```