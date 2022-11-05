package com.algaworks.algafood.domain.repository;

import com.algaworks.algafood.domain.model.PaymentForm;
import java.util.List;

public interface PaymentFormRepository {

  List<PaymentForm> findAll();

  PaymentForm findById(Long id);

  PaymentForm save(PaymentForm kitchen);

  void remove(PaymentForm kitchen);
}
