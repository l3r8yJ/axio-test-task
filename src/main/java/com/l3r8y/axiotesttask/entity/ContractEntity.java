package com.l3r8y.axiotesttask.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import java.sql.Date;
import java.time.Instant;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "contract", schema = "public", catalog = "postgres")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic
    @Column(name = "id_contract")
    private int idContract;

    @Basic
    @Column(name = "date_signature")
    private Date dateSignature;

    @Basic
    @Column(name = "signed")
    private Boolean signed;

    @OneToOne
    @JoinColumn(name = "id_request")
    private RequestEntity request;

    @Override
    public int hashCode() {
        return Objects.hash(
            this.idContract,
            this.dateSignature,
            this.signed,
            this.request
        );
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        final ContractEntity that = (ContractEntity) o;
        return this.idContract == that.idContract && this.request == that.request && Objects.equals(this.dateSignature, that.dateSignature) && Objects.equals(this.signed, that.signed);
    }
}
