package com.l3r8y.axiotesttask.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerSearch {

    private String fio;

    private String passport;

    private String phone;

}
