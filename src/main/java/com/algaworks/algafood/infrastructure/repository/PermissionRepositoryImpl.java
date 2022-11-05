package com.algaworks.algafood.infrastructure.repository;

import com.algaworks.algafood.domain.model.Permission;
import com.algaworks.algafood.domain.repository.PermissionRepository;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class PermissionRepositoryImpl implements PermissionRepository {

  private final EntityManager entityManager;

  @Override
  public List<Permission> findAll() {
    return entityManager.createQuery("from Permission", Permission.class).getResultList();
  }

  @Override
  public Permission findById(Long id) {
    return Optional.of(entityManager.find(Permission.class, id))
        .orElseThrow(() -> new RuntimeException("Permission not found for id: " + id));
  }

  @Transactional
  @Override
  public Permission save(Permission kitchen) {
    return entityManager.merge(kitchen);
  }

  @Transactional
  @Override
  public void remove(Permission kitchen) {
    kitchen = findById(kitchen.getId());
    entityManager.remove(kitchen);
  }
}
