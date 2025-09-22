package com.t1.spring_basic.MEU.ConceitoBasicos;

import org.springframework.stereotype.Service;

@Service
public class MotorEletrico implements Motor {
    public String ligar() {
        return "Motor elétrico ligado";}
}