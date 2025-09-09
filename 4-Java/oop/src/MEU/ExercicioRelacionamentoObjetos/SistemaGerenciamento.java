package MEU.ExercicioRelacionamentoObjetos;

public class SistemaGerenciamento {

    public static void main(String[] args) {

        Veiculo carro = new Carro("Chevrolet", "Onix", 2022);
        Veiculo moto = new Moto("Yamaha", "Fazer", 2012);

        Proprietario proprietario = new Proprietario("William", "Rua dos Bobos, 0");

        proprietario.adicionarVeiculo(carro);
        proprietario.adicionarVeiculo(moto);

        proprietario.exibirVeiculos();

        Servico servico = new Servico("Troca de óleo", 100.0);
        Servico servico2 = new Servico("Revisão Geral de 10 mil km", 500.0);

        Oficina oficina = new Oficina();
        oficina.adicionarServico(servico);
        oficina.adicionarServico(servico2);

        oficina.exibirServicos();

    }

}
