package com.l3r8y.axiotesttask.util;

import com.l3r8y.axiotesttask.dto.CustomerDTO;
import com.l3r8y.axiotesttask.entity.CustomerEntity;

public enum CustomerMapper {
    ;

    public static CustomerEntity transform(final CustomerDTO dto) {
        return CustomerEntity.builder()
            .id(dto.getId())
            .address(dto.getAddress())
            .creditAmount(dto.getCreditAmount())
            .employment(dto.getEmployment())
            .marital(dto.isMarital())
            .passport(dto.getPassport())
            .phone(dto.getPhone())
            .fio(dto.getFio())
            .build();
    }

    public static CustomerDTO transform(final CustomerEntity entity) {
        return CustomerDTO.builder()
            .id(entity.getId())
            .address(entity.getAddress())
            .creditAmount(entity.getCreditAmount())
            .employment(entity.getEmployment())
            .marital(entity.isMarital())
            .passport(entity.getPassport())
            .phone(entity.getPhone())
            .fio(entity.getFio())
            .build();
    }
}
