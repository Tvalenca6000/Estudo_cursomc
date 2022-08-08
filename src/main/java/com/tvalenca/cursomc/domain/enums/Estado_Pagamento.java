package com.tvalenca.cursomc.domain.enums;

public enum Estado_Pagamento {
    
    PENDENTE(1,"Pendente"),
    QUITADO(2,"Quitado"),
    CANCELADO(3, "Cancelado");

    private int cod;
    private String descricao;

    private Estado_Pagamento(int cod, String desc){
        this.cod = cod;
        this.descricao = desc;
    }

    public int getCod(){
        return this.cod;
    }

    public String getDescricao(){
        return this.descricao;
    }

    public static Estado_Pagamento toEnum(Integer cod){

        if(cod == null){
            return null;
        }

        for(Estado_Pagamento x: Estado_Pagamento.values()){
            if(cod.equals(x.getCod())){
                return x;
            }
        }
        throw new  IllegalArgumentException("Id invalido "+cod);
    }

}
