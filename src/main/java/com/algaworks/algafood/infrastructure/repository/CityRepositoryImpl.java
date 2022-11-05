package com.algaworks.algafood.infrastructure.repository;

import com.algaworks.algafood.domain.model.City;
import com.algaworks.algafood.domain.repository.CityRepository;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class CityRepositoryImpl implements CityRepository {

  private final EntityManager entityManager;

  @Override
  public List<City> findAll() {
    return entityManager.createQuery("from City", City.class).getResultList();
  }

  @Override
  public City findById(Long id) {
    return Optional.of(entityManager.find(City.class, id))
        .orElseThrow(() -> new RuntimeException("City not found for id: " + id));
  }

  @Transactional
  @Override
  public City save(City kitchen) {
    return entityManager.merge(kitchen);
  }

  @Transactional
  @Override
  public void remove(City kitchen) {
    kitchen = findById(kitchen.getId());
    entityManager.remove(kitchen);
  }
}
