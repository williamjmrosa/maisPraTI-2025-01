package com.t1.spring_basic.MEU.ConceitoBasicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Carrinho {

    @Autowired
    private Motor motor;

    public Carrinho(Motor motor) {
        this.motor = motor;
    }

    @Autowired
    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    String andar() {
        return "E o carrinho andando";
    }
}
