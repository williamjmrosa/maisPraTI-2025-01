package MEU.ExercicioRelacionamentoObjetos;

import java.util.ArrayList;
import java.util.List;

public class Oficina {
    private List<Servico> servicos;
    public Oficina() {
        this.servicos = new ArrayList<>();
    }

    public void adicionarServico(Servico servico) {
        this.servicos.add(servico);
    }

    public void exibirServicos() {
        System.out.println("Servicos: ");
        for (Servico servico : this.servicos) {
            servico.exibirServico();
            System.out.println();
        }
    }
}
