package MEU.ExercicioGerenciamentoVeiculosEProprietarios;

public class Carro extends Veiculo{

    public Carro(String marca, String modelo, int ano) {
        super(marca, modelo, ano);
    }

    @Override
    public String tipoDeVeiculo() {
        return "Tipo de veiculo: Carro";
    }
}
