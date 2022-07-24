package com.auth.authentication.api.brands.service;

import com.auth.authentication.api.brands.model.Brand;

import java.util.List;

public interface BrandService {
    /**
     * fetch all the brands from the database
     * @return
     */
    List<Brand> getAll();

    /**
     * save the brand name to the database
     * @param name
     * @return
     */
    Brand saveBrand(Brand name);

    /**
     * update the brand name to the database
     * @param id
     * @return
     */
    Brand update(Long id);

    /**
     * delete the brand from the database
     * @param id
     * @return
     */
    Brand delete(Long id);
}
