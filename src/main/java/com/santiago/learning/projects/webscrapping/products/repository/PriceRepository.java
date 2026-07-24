package com.santiago.learning.projects.webscrapping.products.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santiago.learning.projects.webscrapping.products.model.Price;

public interface PriceRepository extends JpaRepository<Price, UUID> {

}
