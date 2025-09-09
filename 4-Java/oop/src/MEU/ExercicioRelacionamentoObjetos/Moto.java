package MEU.ExercicioRelacionamentoObjetos;

public class Moto extends Veiculo {

    public Moto(String marca, String modelo, int ano) {
        super(marca, modelo, ano);
    }

    @Override
    public void tipoVeiculo() {
        System.out.println("Tipo de veiculo: Moto");
    }

}
