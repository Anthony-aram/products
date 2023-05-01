package com.products.products.service.impl;

import com.products.products.dto.BrandDto;
import com.products.products.mapper.BrandMapper;
import com.products.products.repository.BrandRepository;
import com.products.products.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;
    private final BrandMapper brandMapper;

    /**
     * Get all brands
     * @return Return all brands
     */
    @Override
    public List<BrandDto> getAllBrands() {
        return brandRepository.findAll().stream().map(brandMapper::mapToDto).collect(Collectors.toList());
    }
}
