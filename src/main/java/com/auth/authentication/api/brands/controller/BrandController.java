package com.auth.authentication.api.brands.controller;

import com.auth.authentication.api.brands.model.Brand;
import com.auth.authentication.api.brands.service.BrandService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class BrandController {

    private final BrandService brandService;

    @Autowired
    public BrandController(BrandService brandService){
        this.brandService = brandService;
    }

    /**
     * method to fetch all brands from the database
     * @return ResponseEntity
     */
    @GetMapping("/brands")
    public ResponseEntity<List<Brand>> index(){
        return ResponseEntity.ok(brandService.getAll());
    }

    /**
     * to store the brand name to the database
     * @param name
     * @return ResponseEntity
     */
    @PostMapping("/brands")
    public ResponseEntity<Brand> store(@RequestBody Brand name){
        return ResponseEntity.ok(brandService.saveBrand(name));
    }

}
