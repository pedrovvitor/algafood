package com.algaworks.algafood.infrastructure.repository;

import com.algaworks.algafood.domain.model.Restaurant;
import com.algaworks.algafood.domain.repository.RestaurantRepository;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Repository
public class RestaurantRepositoryImpl implements RestaurantRepository {

  private final EntityManager entityManager;

  @Override
  public List<Restaurant> findAll() {
    return entityManager.createQuery("from Restaurant", Restaurant.class).getResultList();
  }

  @Override
  public Restaurant findById(Long id) {
    return Optional.of(entityManager.find(Restaurant.class, id))
        .orElseThrow(() -> new RuntimeException("Restaurant not found for id: " + id));
  }

  @Transactional
  @Override
  public Restaurant save(Restaurant kitchen) {
    return entityManager.merge(kitchen);
  }

  @Transactional
  @Override
  public void remove(Restaurant kitchen) {
    kitchen = findById(kitchen.getId());
    entityManager.remove(kitchen);
  }
}
