package com.algaworks.algafood.infrastructure.repository;

import com.algaworks.algafood.domain.model.PaymentForm;
import com.algaworks.algafood.domain.repository.PaymentFormRepository;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class PaymentFormRepositoryImpl implements PaymentFormRepository {

  private final EntityManager entityManager;

  @Override
  public List<PaymentForm> findAll() {
    return entityManager.createQuery("from PaymentForm", PaymentForm.class).getResultList();
  }

  @Override
  public PaymentForm findById(Long id) {
    return Optional.of(entityManager.find(PaymentForm.class, id))
        .orElseThrow(() -> new RuntimeException("PaymentForm not found for id: " + id));
  }

  @Transactional
  @Override
  public PaymentForm save(PaymentForm kitchen) {
    return entityManager.merge(kitchen);
  }

  @Transactional
  @Override
  public void remove(PaymentForm kitchen) {
    kitchen = findById(kitchen.getId());
    entityManager.remove(kitchen);
  }
}
