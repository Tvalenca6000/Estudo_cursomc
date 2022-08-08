package com.tvalenca.cursomc.domain;

import javax.persistence.Entity;

import com.tvalenca.cursomc.domain.enums.Estado_Pagamento;

@Entity
public class Pagamento_Com_Cartao extends Pagamento{
    private static final long serialVersionUID = 1L;
    
    private Integer numeroDeParcelas;

    public Pagamento_Com_Cartao(){}

    public Pagamento_Com_Cartao(Integer id, Estado_Pagamento estado, Pedido pedido, Integer numeroDeParcelas) {
        super(id, estado, pedido);
        this.numeroDeParcelas = numeroDeParcelas;
    }

    public Integer getNumeroDeParcelas() {
        return numeroDeParcelas;
    }

    public void setNumeroDeParcelas(Integer numeroDeParcelas) {
        this.numeroDeParcelas = numeroDeParcelas;
    }

}
