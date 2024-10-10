package com.api.helpdesk.domain.enums;

public enum Status {

    ABERTO(0, "STATUS_ABERTO"),
    ENCERRADO(1, "STATUS_FECHADO"),
    ANDAMENTO(2, "STATUS_ANDAMENTO");

    private Integer codigo;
    private String descricao;

    Status(Integer codigo, String descricao) {
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

    public static Status toEnum(Integer cod) {
        if(cod == null) {
            return null;
        }

        for(Status status : Status.values()) {
            if(cod.equals(status.getCodigo())) {
                return status;
            }
        }

        throw new IllegalArgumentException("Status inválido");
    }
}
