package com.products.products.service.impl;

import com.products.products.entity.Role;
import com.products.products.reference.RoleReference;
import com.products.products.repository.RoleRepository;
import com.products.products.service.ReferenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Permet de récupérer les références en base
 */
@Service
@RequiredArgsConstructor
public class ReferenceServiceImpl implements ReferenceService {

    private final RoleRepository roleRepository;

    /**
     * Récupère une entité role depuis une reférence role
     * @param reference La référence du role
     * @return Une entité role
     */
    @Override
    public Role role(RoleReference reference) {
        return roleRepository.findById(reference.asCode()).orElse(null);
    }

    /**
     * Récupère toutes les entités role
     * @return Une liste d'entités role
     */
    @Override
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }
}
