package com.web.assgiment.dormitory.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillServiceDto {
    private String studentCode;
    private String serviceCode;
    private String serviceName;
    private double total;
}
