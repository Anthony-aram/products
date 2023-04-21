package com.products.products.controller;

import com.products.products.entity.Role;
import com.products.products.service.ReferenceService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller pour la gestion des références
 */
@RestController
@RequestMapping("api/references")
@Tag(name = "References", description = "Endpoints for managing references")
@RequiredArgsConstructor
public class ReferenceController {

    private final ReferenceService referenceService;

    /**
     * Récupère toutes les références role
     * @return Une liste d'entités role
     */
    @GetMapping("/roles")
    public ResponseEntity<List<Role>> getAllRoles() {
        return ResponseEntity.ok(referenceService.getRoles());
    }
}
