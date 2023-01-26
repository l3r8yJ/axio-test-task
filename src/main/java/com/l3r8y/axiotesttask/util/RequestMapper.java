package com.l3r8y.axiotesttask.util;

import com.l3r8y.axiotesttask.dto.RequestDTO;
import com.l3r8y.axiotesttask.entity.RequestEntity;

public enum RequestMapper {
    ;

    public static RequestEntity transform(final RequestDTO dto) {
        return RequestEntity
            .builder()
            .idRequest(dto.getIdRequest())
            .amount(dto.getAmount())
            .status(dto.isStatus())
            .period(dto.getPeriod())
            .customer(dto.getCustomer())
            .build();
    }

    public static RequestDTO transform(final RequestEntity entity) {
        return RequestDTO
            .builder()
            .idRequest(entity.getIdRequest())
            .amount(entity.getAmount())
            .status(entity.isStatus())
            .period(entity.getPeriod())
            .customer(entity.getCustomer())
            .build();
    }
}
