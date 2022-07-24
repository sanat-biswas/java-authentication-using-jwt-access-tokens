package com.auth.authentication.api.brands.service;

import com.auth.authentication.api.brands.model.Brand;
import com.auth.authentication.api.brands.repository.BrandRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
public class BrandServiceImpl implements BrandService{

    private final BrandRepository brandRepository;

    @Autowired
    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public List<Brand> getAll() {
        return brandRepository.findAll();
    }

    @Override
    public Brand saveBrand(Brand brand) {
        log.info("saving brands {} to the database", brand.getName());
        return brandRepository.save(brand);
    }

    @Override
    public Brand update(Long id) {
        return null;
    }

    @Override
    public Brand delete(Long id) {
        return null;
    }
}
