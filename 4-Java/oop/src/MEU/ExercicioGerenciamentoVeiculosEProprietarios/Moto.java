package MEU.ExercicioGerenciamentoVeiculosEProprietarios;

public class Moto extends Veiculo{

    public Moto(String marca, String modelo, int ano) {
        super(marca, modelo, ano);
    }

    @Override
    public String tipoDeVeiculo() {
        return "Tipo de veiculo: Moto";
    }
}
