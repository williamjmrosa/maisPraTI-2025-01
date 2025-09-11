package Meu.ExercicioCollection;

//Crie uma classe chamada Funcionario com os seguintes atributos: nome (String), salario (double), cargo (String) e idade (int). Implemente o construtor, os métodos getters e setters necessários.

// Em seguida, crie uma lista de 10 funcionários, com valores variados para os atributos, e realize as seguintes operações utilizando Collections e Streams:

//Filtre e exiba os nomes e cargos dos funcionários com mais de 30 anos.

//Ordene os funcionários por salário em ordem crescente e exiba os nomes e salários.

//Calcule e exiba a média salarial dos funcionários.

//Exiba o total de funcionários com salário superior a R$ 4.000,00.

//Crie uma lista com os nomes dos funcionários e a exiba.

//Utilize os recursos de Streams para realizar as operações de forma concisa e eficiente.

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GerenciarFuncionarios {

    public static void main(String[] args) {

        Funcionario funcionario1 = new Funcionario("Jucilei", 13000, "Gerente", 30);
        Funcionario funcionario2 = new Funcionario("Gertrudes", 9000, "Coordenador", 25);
        Funcionario funcionario3 = new Funcionario("João", 8000, "Coordenador", 35);
        Funcionario funcionario4 = new Funcionario("Maria", 6000, "Contador", 40);
        Funcionario funcionario5 = new Funcionario("Pedro", 7000, "Contador", 45);
        Funcionario funcionario6 = new Funcionario("Clara", 2500, "Limpeza", 25);
        Funcionario funcionario7 = new Funcionario("Carlos", 3000, "Atendente", 45);
        Funcionario funcionario8 = new Funcionario("Juliana", 3000, "Caixa", 40);
        Funcionario funcionario9 = new Funcionario("Pedro", 3000, "Caixa", 35);
        Funcionario funcionario10 = new Funcionario("Ana", 2000, "Secretaria", 40);

        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(funcionario1);
        funcionarios.add(funcionario2);
        funcionarios.add(funcionario3);
        funcionarios.add(funcionario4);
        funcionarios.add(funcionario5);
        funcionarios.add(funcionario6);
        funcionarios.add(funcionario7);
        funcionarios.add(funcionario8);
        funcionarios.add(funcionario9);
        funcionarios.add(funcionario10);

        System.out.println("Funcionários com mais de 30 anos:");

        funcionarios.stream().filter(funcionario -> funcionario.getIdade() > 30).forEach(funcionario -> System.out.println(funcionario.getNome() + " - " + funcionario.getCargo()));

        System.out.println("Funcionários ordenados por salário:");

        funcionarios.stream().sorted(Comparator.comparing(Funcionario::getSalario)).forEach(funcionario -> System.out.println(funcionario.getNome() + " - " + funcionario.getSalario()));

        System.out.println("Media salarial dos funcionarios: " +  funcionarios.stream().mapToDouble(Funcionario::getSalario).average().orElse(0));

         Number quantidadeFuncionariosSalarioMaior4000 = funcionarios.stream().filter(funcionario -> funcionario.getSalario() > 4000).count();

        System.out.println("Quantidade de Funcionários com salário superior a R$ 4.000,00: " + quantidadeFuncionariosSalarioMaior4000);

        List<String> nomesFuncionarios = funcionarios.stream().map(Funcionario::getNome).toList();

        System.out.println("Nomes dos funcionarios:");
        nomesFuncionarios.forEach(System.out::println);

        System.out.println("Original");
    }

}
