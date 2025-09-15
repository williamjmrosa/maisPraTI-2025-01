package Meu.Thread;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TarefaConcorrente extends Thread{

    private String nome;

    public TarefaConcorrente(String nome){
        this.nome = nome;
    }

    @Override
    public void run(){
        for(int i = 0; i < 5; i++){
            System.out.println(this.nome + " está executando a tarefa " + (i + 1));
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){

        System.out.println("Main Thread continua executando");

        TarefaConcorrente tarefa1 = new TarefaConcorrente("Tarefa 1");
        TarefaConcorrente tarefa2 = new TarefaConcorrente("Tarefa 2");
        TarefaConcorrente tarefa3 = new TarefaConcorrente("Tarefa 3");
        TarefaConcorrente tarefa4 = new TarefaConcorrente("Tarefa 4");
        TarefaConcorrente tarefa5 = new TarefaConcorrente("Tarefa 5");

        tarefa1.start();
        tarefa2.start();
        tarefa3.start();
        tarefa4.start();
        tarefa5.start();
    }
}

