package com.l3r8y.axiotesttask.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigInteger;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "customer", schema = "public", catalog = "postgres")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerEntity {

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
    private BigInteger creditAmount;

    @Basic
    @Column(name = "id_request")
    private int idRequest;


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
            this.creditAmount,
            this.idRequest
        );
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        final CustomerEntity that = (CustomerEntity) o;
        return this.id == that.id
            && this.marital == that.marital
            && this.idRequest == that.idRequest
            && Objects.equals(this.fio, that.fio)
            && Objects.equals(this.passport, that.passport)
            && Objects.equals(this.address, that.address)
            && Objects.equals(this.phone, that.phone)
            && Objects.equals(this.employment, that.employment)
            && Objects.equals(this.creditAmount, that.creditAmount);
    }
}
