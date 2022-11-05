package com.algaworks.algafood.infrastructure.repository;

import com.algaworks.algafood.domain.model.Kitchen;
import com.algaworks.algafood.domain.repository.KitchenRepository;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class KitchenRepositoryImpl implements KitchenRepository {

  private final EntityManager entityManager;

  @Override
  public List<Kitchen> findAll() {
    return entityManager.createQuery("from Kitchen", Kitchen.class).getResultList();
  }

  @Override
  public Kitchen findById(Long id) {
    return Optional.of(entityManager.find(Kitchen.class, id))
        .orElseThrow(() -> new RuntimeException("Kitchen not found for id: " + id));
  }

  @Transactional
  @Override
  public Kitchen save(Kitchen kitchen) {
    return entityManager.merge(kitchen);
  }

  @Transactional
  @Override
  public void remove(Kitchen kitchen) {
    kitchen = findById(kitchen.getId());
    entityManager.remove(kitchen);
  }
}
