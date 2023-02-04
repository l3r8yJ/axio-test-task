package com.l3r8y.axiotesttask.entity;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

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
