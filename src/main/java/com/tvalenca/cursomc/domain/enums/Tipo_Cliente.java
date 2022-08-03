package com.tvalenca.cursomc.domain.enums;

public enum Tipo_Cliente {
    
    PESSOAFISICA(1, "Pessoa Fisica"),
    PESSOAJURIDICA(2, "Pessoa Juridica");

    private int cod;
    private String descricao;

    private Tipo_Cliente(int cod, String desc){
        this.cod = cod;
        this.descricao = desc;
    }

    public int getCod(){
        return this.cod;
    }

    public String getDescricao(){
        return this.descricao;
    }

    public static Tipo_Cliente toEnum(Integer cod){

        if(cod == null){
            return null;
        }

        for(Tipo_Cliente x: Tipo_Cliente.values()){
            if(cod.equals(x.getCod())){
                return x;
            }
        }
        throw new  IllegalArgumentException("Id invalido "+cod);
    }
}
