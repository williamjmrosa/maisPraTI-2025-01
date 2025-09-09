package MEU.ExercicioGerenciamentoVeiculosEProprietarios;

// Implemente um sistema de gerenciamento de veículos e seus proprietários. O sistema deve utilizar os conceitos de associação, agregação, composição, herança, polimorfismo e dependência.
//
// O sistema deve ter uma classe abstrata chamada Veiculo, com atributos básicos como marca, modelo e ano, e um método para exibir essas informações. Além disso, o método tipoDeVeiculo() deverá ser implementado nas subclasses Carro e Moto, que devem herdar de Veiculo. Cada tipo de veículo deve exibir seu tipo específico.
//
// Crie uma classe Proprietario, que possui informações como nome e endereço, e que pode ter múltiplos veículos associados a ele. A relação entre proprietário e veículos deve ser uma dependência.
//
// Implemente uma classe Servico, que tem informações sobre a descrição e o preço dos serviços realizados, e uma classe Oficina, que é responsável por adicionar e listar serviços realizados.
//
// Entre as classes, estabeleça as relações necessárias, como agregação entre oficina e serviços e dependência entre proprietário e veículos. Utilize herança e polimorfismo para organizar e expandir o sistema de forma eficiente.



public class SistemaGerenciamentoVeiculos {

    public static void main(String[] args) {

        Proprietario proprietario = new Proprietario("William", "Rua 1");
        Carro carro1 = new Carro("Chevrolet", "Camaro", 2022);
        Moto moto1 = new Moto("Honda", "CBR", 2022);

        proprietario.adicionarVeiculo(carro1);
        proprietario.adicionarVeiculo(moto1);

        System.out.println("Oficina: ");

        Oficina oficina = new Oficina("Mequanica WJ");
        Servico servico1 = new Servico("Tunagem", 100);
        Servico servico2 = new Servico("Pintura", 200);
        Servico servico3 = new Servico("Revisao", 300);

        oficina.adicionarServico(servico1);
        oficina.adicionarServico(servico2);
        oficina.adicionarServico(servico3);

        proprietario.exibirDados();
        oficina.exibirDados();

    }

}
