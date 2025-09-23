package com.t1.springbasics.MEU.MiniPrograma;

import java.math.BigDecimal;

public interface TotalStore {

    BigDecimal read();

    void write(BigDecimal newTotal);

}
