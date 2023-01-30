package com.l3r8y.axiotesttask.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "request")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestEntity implements Serializable {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "id_request")
    private long idRequest;

    @Basic
    @Column(name = "status")
    private boolean status;

    @Basic
    @Column(name = "period")
    private int period;

    @Basic
    @Column(name = "amount")
    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private CustomerEntity customer;

    @OneToOne
    @JoinColumn(name = "contract_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ContractEntity contract;

    @Override
    public int hashCode() {
        return Objects.hash(this.idRequest, this.status, this.period, this.amount);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        final RequestEntity that = (RequestEntity) obj;
        return this.idRequest == that.idRequest
            && this.status == that.status
            && this.period == that.period
            && Objects.equals(this.amount, that.amount);
    }
}
