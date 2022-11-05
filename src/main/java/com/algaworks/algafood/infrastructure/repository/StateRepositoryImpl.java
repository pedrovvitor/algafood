package com.algaworks.algafood.infrastructure.repository;

import com.algaworks.algafood.domain.model.State;
import com.algaworks.algafood.domain.repository.StateRepository;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class StateRepositoryImpl implements StateRepository {

  private final EntityManager entityManager;

  @Override
  public List<State> findAll() {
    return entityManager.createQuery("from State", State.class).getResultList();
  }

  @Override
  public State findById(Long id) {
    return Optional.of(entityManager.find(State.class, id))
        .orElseThrow(() -> new RuntimeException("State not found for id: " + id));
  }

  @Transactional
  @Override
  public State save(State kitchen) {
    return entityManager.merge(kitchen);
  }

  @Transactional
  @Override
  public void remove(State kitchen) {
    kitchen = findById(kitchen.getId());
    entityManager.remove(kitchen);
  }
}
