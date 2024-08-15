import java.util.*;
import java.util.stream.Collectors;

public class Testes {
    public static void main(String[] args) {

        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new Pessoa("João", "123456789", 30));
        pessoas.add(new Pessoa("João", "123456789", 30));
        pessoas.add(new Pessoa("Ana", "987654321", 25));
        pessoas.add(new Pessoa("Carlos", "456789123", 40));

        // Adicionando uma nova pessoa na lista
        Pessoa novaPessoa = new Pessoa("Maria", "321654987", 28);
        pessoas = PessoaAdicionar.adicionarPessoa(pessoas, novaPessoa); // Update the list reference

        // Remover duplicados
        List<Pessoa> pessoasSemDuplicados = PessoaLimpa.removerDuplicados(pessoas);

        // Criando e imprimindo mapa de pessoas
        PessoaLista PessoaLista = new PessoaLista();
        Pessoa pessoaMapa = new Pessoa("Maria", "321654987", 28);
        PessoaLista.adicionarEImprimirPessoa(pessoaMapa);

        // Ordenar em ordem crescente pelo nome
        List<Pessoa> pessoasCrescente = PessoaLista.ordenarPessoas(pessoasSemDuplicados, true);
        System.out.println("Ordenado em ordem crescente pelo nome:");
        pessoasCrescente.forEac"h(p -> System.out.println(p.getNome() + ", Idade: " + p.getIdade()));

        // Ordenar em ordem decrescente pelo nome
        List<Pessoa> pessoasDecrescente = PessoaLista.ordenarPessoas(pessoasSemDuplicados, false);
        System.out.println("Ordenado em ordem decrescente pelo nome:");
        pessoasDecrescente.forEach(p -> System.out.println(p.getNome() + ", Idade: " + p.getIdade()));
    }

    // Classe estática para adicionar pessoa
    static class PessoaAdicionar {
        public static List<Pessoa> adicionarPessoa(List<Pessoa> lista, Pessoa pessoa) {
            lista.add(pessoa);
            return lista;
        }
    }

    // Classe estática para remover duplicados
    static class PessoaLimpa {
        public static List<Pessoa> removerDuplicados(List<Pessoa> lista) {
            Set<Pessoa> set = new HashSet<>(lista);
            return new ArrayList<>(set);
        }
    }

    // Classe para utilidades relacionadas à pessoa
    static class PessoaLista {
        private Map<String, Pessoa> mapaPessoas = new HashMap<>();

        public void adicionarEImprimirPessoa(Pessoa pessoa) {
            mapaPessoas.put(pessoa.getCpf(), pessoa);
            System.out.println("Adicionando Pessoa: " + pessoa.getNome() + ", CPF: " + pessoa.getCpf() + ", Idade: " + pessoa.getIdade());
        }

        public static List<Pessoa> ordenarPessoas(List<Pessoa> lista, boolean crescente) {
            if (crescente) {
                return lista.stream()
                        .sorted(Comparator.comparing(Pessoa::getNome, String.CASE_INSENSITIVE_ORDER))
                        .collect(Collectors.toList());
            } else {
                return lista.stream()
                        .sorted(Comparator.comparing(Pessoa::getNome, String.CASE_INSENSITIVE_ORDER).reversed())
                        .collect(Collectors.toList());
            }
        }
    }
}
