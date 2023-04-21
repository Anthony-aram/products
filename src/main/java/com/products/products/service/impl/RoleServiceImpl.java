package com.products.products.service.impl;

import com.products.products.entity.Role;
import com.products.products.repository.RoleRepository;
import com.products.products.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service pour les rôles
 */
@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    /**
     * Récupère tous les rôles
     * @return La liste des rôles
     */
    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }
}
