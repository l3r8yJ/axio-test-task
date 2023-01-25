package com.l3r8y.axiotesttask.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "request")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestEntity implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_request")
    private int idRequest;

    @Basic
    @Column(name = "status")
    private boolean status;

    @Basic
    @Column(name = "period")
    private int period;

    @Basic
    @Column(name = "amount")
    private BigDecimal amount;

    @Override
    public int hashCode() {
        return Objects.hash(this.idRequest, this.status, this.period, this.amount);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        final RequestEntity that = (RequestEntity) o;
        return this.idRequest == that.idRequest
            && this.status == that.status
            && this.period == that.period
            && Objects.equals(this.amount, that.amount);
    }
}
