package com.l3r8y.axiotesttask.dto;

import com.l3r8y.axiotesttask.entity.CustomerEntity;
import com.l3r8y.axiotesttask.entity.RequestEntity;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDTO {

    private int id;

    private String fio;

    private String passport;

    private boolean marital;

    private String address;

    private String phone;

    private String employment;

    private BigDecimal creditAmount;

    private int idRequest;

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
            this.creditAmount,
            this.idRequest,
            this.requests
        );
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        final CustomerDTO that = (CustomerDTO) o;
        return this.id == that.id
            && this.marital == that.marital
            && this.idRequest == that.idRequest
            && Objects.equals(this.fio, that.fio)
            && Objects.equals(this.passport, that.passport)
            && Objects.equals(this.address, that.address)
            && Objects.equals(this.phone, that.phone)
            && Objects.equals(this.employment, that.employment)
            && Objects.equals(this.creditAmount, that.creditAmount)
            && Objects.equals(this.requests, that.requests);
    }}
