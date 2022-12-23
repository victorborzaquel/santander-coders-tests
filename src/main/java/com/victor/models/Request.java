package com.victor.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Request {
    private Long id;
    private String client;
    private Integer quantProducts;
    private Double totalValue;
    private String status;
}
