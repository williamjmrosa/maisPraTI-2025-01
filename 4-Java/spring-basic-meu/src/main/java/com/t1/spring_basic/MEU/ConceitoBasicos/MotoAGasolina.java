package com.t1.spring_basic.MEU.ConceitoBasicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class MotoAGasolina implements  Motor {
    private Motor motor;
    public String ligar() {
        return "Motor de gasolina ligado";
    }

    @Autowired
    public void setMotor(Motor motor) {
        this.motor = motor;
    }

}
