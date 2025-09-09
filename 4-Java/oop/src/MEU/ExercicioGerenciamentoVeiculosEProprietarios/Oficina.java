package MEU.ExercicioGerenciamentoVeiculosEProprietarios;

import java.util.ArrayList;
import java.util.List;

public class Oficina {

    private String nome;
    private List<Servico> servicos;

    public Oficina(String nome) {
        this.nome = nome;
        this.servicos = new ArrayList<>();
    }

    public void adicionarServico(Servico servico) {
        this.servicos.add(servico);
    }

    public void removerServico(Servico servico) {
        this.servicos.remove(servico);
    }

    public List<Servico> getServicos() {
        return this.servicos;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void exibirDados() {
        System.out.println("\nNome: " + this.nome);
        System.out.println("Servicos: ");
        for (Servico servico : this.servicos) {
            System.out.println(servico.toString());
        }
    }
}
