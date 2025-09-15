package Meu.Thread;

public class TarefaParalela extends Thread{

    private String nome;

    public TarefaParalela(String nome){
        this.nome = nome;
    }

    @Override
    public void run(){
        for(int i = 0; i < 5; i++){
            System.out.println(this.nome + " está executando a tarefa " + (i + 1));
        }
    }

    public static void main(String[] args){
        TarefaParalela tarefa1 = new TarefaParalela("Tarefa 1");
        TarefaParalela tarefa2 = new TarefaParalela("Tarefa 2");

        tarefa1.start();
        tarefa2.start();
    }

}
