package com.tvalenca.cursomc.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.tvalenca.cursomc.domain.enums.Estado_Pagamento;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Pagamento implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    private Integer id;
    private Integer estado;

    @OneToOne
    @JoinColumn(name="pedido_id")
    @MapsId
    private Pedido pedido;

    public Pagamento(){}

    public Pagamento(Integer id, Estado_Pagamento estado, Pedido pedido) {
        this.id = id;
        this.estado = estado.getCod();
        this.pedido = pedido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Estado_Pagamento getEstado() {
        return Estado_Pagamento.toEnum(estado);
    }

    public void setEstado(Estado_Pagamento estado) {
        this.estado = estado.getCod();
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pagamento other = (Pagamento) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
