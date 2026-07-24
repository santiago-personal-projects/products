package com.santiago.learning.projects.webscrapping.products.dto.request;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDTO {
    @NotEmpty
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String url;
}
