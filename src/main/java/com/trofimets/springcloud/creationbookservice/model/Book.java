package com.trofimets.springcloud.creationbookservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {

    private int id;
    private String name;
    private String description;
    private String status = "unchecked";
    private double price;
}
