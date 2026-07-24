package com.santiago.learning.projects.webscrapping.products.model;

import java.sql.Timestamp;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString
@Table(schema = "webscrapping", name = "price")
@AllArgsConstructor
public class Price {
    @Id
    @GeneratedValue
    @Column(name = "price_id")
    private UUID id;
    
    @CreationTimestamp
    @Column(name = "price_date", nullable = false)
    private Timestamp date;
    
    @Column(nullable = false)
    private String price;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Price(String price, Product product) {
        this.price = price;
        this.product = product;
    }   
    
}
