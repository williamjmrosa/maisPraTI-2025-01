package Meu.ExercicioCollection;

//Crie uma classe chamada Funcionario com os seguintes atributos: nome (String), salario (double), cargo (String) e idade (int). Implemente o construtor, os métodos getters e setters necessários.

// Em seguida, crie uma lista de 10 funcionários, com valores variados para os atributos, e realize as seguintes operações utilizando Collections e Streams:

//Filtre e exiba os nomes e cargos dos funcionários com mais de 30 anos.

//Ordene os funcionários por salário em ordem crescente e exiba os nomes e salários.

//Calcule e exiba a média salarial dos funcionários.

//Exiba o total de funcionários com salário superior a R$ 4.000,00.

//Crie uma lista com os nomes dos funcionários e a exiba.

//Utilize os recursos de Streams para realizar as operações de forma concisa e eficiente.

public class Funcionario {

    private String nome;
    private double salario;
    private String cargo;
    private int idade;

    public Funcionario(String nome, double salario, String cargo, int idade) {
        this.nome = nome;
        this.salario = salario;
        this.cargo = cargo;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
