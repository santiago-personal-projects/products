package com.santiago.learning.projects.webscrapping.products.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santiago.learning.projects.webscrapping.products.dto.request.PriceRequestDTO;
import com.santiago.learning.projects.webscrapping.products.dto.request.ProductRequestDTO;
import com.santiago.learning.projects.webscrapping.products.service.ScraperServiceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/scrapper")
@RequiredArgsConstructor
public class ScraperController {

    private final ScraperServiceImpl scraperService;

    @PostMapping("/product")
    public ResponseEntity<String> saveProduct(@RequestBody ProductRequestDTO entity) {
        scraperService.saveProduct(entity);
        return new ResponseEntity<>("OK", HttpStatus.CREATED);
    }

    @PostMapping("/price")
    public ResponseEntity<String> savePrice(@RequestBody PriceRequestDTO entity) {
        scraperService.savePrice(entity);
        return new ResponseEntity<>("OK", HttpStatus.CREATED);
    }
}