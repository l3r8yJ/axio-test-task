package com.l3r8y.axiotesttask.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerEntity implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "fio")
    private String fio;

    @Basic
    @Column(name = "passport")
    private String passport;

    @Basic
    @Column(name = "marital")
    private boolean marital;

    @Basic
    @Column(name = "address")
    private String address;

    @Basic
    @Column(name = "phone")
    private String phone;

    @Basic
    @Column(name = "employment")
    private String employment;

    @Basic
    @Column(name = "credit_amount")
    private BigDecimal creditAmount;

    @OneToMany(mappedBy = "customer")
    private Set<RequestEntity> requests;

    @Override
    public int hashCode() {
        return Objects.hash(
            this.id,
            this.fio,
            this.passport,
            this.marital,
            this.address,
            this.phone,
            this.employment,
            this.creditAmount
        );
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        final CustomerEntity that = (CustomerEntity) o;
        return this.id == that.id
            && this.marital == that.marital
            && Objects.equals(this.fio, that.fio)
            && Objects.equals(this.passport, that.passport)
            && Objects.equals(this.address, that.address)
            && Objects.equals(this.phone, that.phone)
            && Objects.equals(this.employment, that.employment)
            && Objects.equals(this.creditAmount, that.creditAmount);
    }
}
