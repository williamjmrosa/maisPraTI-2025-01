package Meu.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MinhaThread extends Thread{

    @Override
    public void run(){
        System.out.println("Minha thread está executando");
    }

    public static void main(String[] args){
        ExecutorService executor = Executors.newFixedThreadPool(5);

        for(int i = 0; i < 5; i++){
            executor.submit(() ->{
                System.out.println("Minha tarefa executando na " + Thread.currentThread().getName());
            });
        }
        executor.shutdown();

        MinhaThread minhaThread = new MinhaThread();
        minhaThread.start();
        System.out.println("Main Thread continua executando");
    }
}
