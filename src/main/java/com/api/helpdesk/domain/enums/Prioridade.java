package com.api.helpdesk.domain.enums;

public enum Prioridade {
    BAIXA(0, "PRIORIDADE_BAIXA"),
    MEDIA(1, "PRIORIDADE_MEDIA"),
    ALTA(2, "PRIORIDADE_ALTA");

    private Integer codigo;
    private String descricao;

    Prioridade(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static Prioridade toEnum(Integer cod) {
        if(cod == null) {
            return null;
        }

        for(Prioridade prioridade : Prioridade.values()) {
            if(cod.equals(prioridade.getCodigo())) {
                return prioridade;
            }
        }

        throw new IllegalArgumentException("Prioridade inválida");
    }



}
