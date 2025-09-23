package com.t1.springbasics.MEU.MiniPrograma;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.nio.file.Path;

public class ConsoleMessageSink implements  MessageSink{

    @Override
    public void show(String message){
        System.out.println(message);
    }



}
