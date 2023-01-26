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
public class RequestDTO {

    private long idRequest;

    private boolean status;

    private int period;

    private BigDecimal amount;

    private CustomerEntity customer;

    @Override
    public int hashCode() {
        return Objects.hash(
            this.idRequest,
            this.status,
            this.period,
            this.amount,
            this.customer
        );
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        final RequestDTO that = (RequestDTO) obj;
        return this.idRequest == that.idRequest
            && this.status == that.status
            && this.period == that.period
            && this.customer == that.customer
            && Objects.equals(this.amount, that.amount);
    }
}
