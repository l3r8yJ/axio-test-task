package com.l3r8y.axiotesttask.util;

import com.l3r8y.axiotesttask.dto.CustomerDTO;
import com.l3r8y.axiotesttask.entity.CustomerEntity;

public enum CustomerMapper {
    ;

    public static CustomerEntity toEntity(final CustomerDTO dto) {
        return CustomerEntity.builder()
            .id(dto.getId())
            .address(dto.getAddress())
            .creditAmount(dto.getCreditAmount())
            .employment(dto.getEmployment())
            .idRequest(dto.getIdRequest())
            .marital(dto.isMarital())
            .passport(dto.getPassport())
            .phone(dto.getPhone())
            .fio(dto.getFio())
            .build();
    }

    public static CustomerDTO toDTO(final CustomerEntity entity) {
        return CustomerDTO.builder()
            .id(entity.getId())
            .address(entity.getAddress())
            .creditAmount(entity.getCreditAmount())
            .employment(entity.getEmployment())
            .idRequest(entity.getIdRequest())
            .marital(entity.isMarital())
            .passport(entity.getPassport())
            .phone(entity.getPhone())
            .fio(entity.getFio())
            .build();
    }
}
