package MEU.ExercicioGerenciamentoVeiculosEProprietarios;

import java.util.ArrayList;
import java.util.List;

public class Proprietario {

    private String nome;
    private String endereco;
    private List<Veiculo> veiculos;

    public Proprietario(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.veiculos = new ArrayList<>();
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        this.veiculos.add(veiculo);
    }

    public void removerVeiculo(Veiculo veiculo) {
        this.veiculos.remove(veiculo);
    }

    public List<Veiculo> getVeiculos() {
        return this.veiculos;
    }

    public String getNome() {
        return this.nome;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void exibirDados() {
        System.out.println("Nome: " + this.nome);
        System.out.print("Endereco: " + this.endereco);
        System.out.print("\nVeiculos:");
        for (Veiculo veiculo : this.veiculos) {
            System.out.print(veiculo.toString());
        }
    }
}
