package com.algaworks.algafood.api.controller;

import com.algaworks.algafood.domain.model.Kitchen;
import com.algaworks.algafood.domain.repository.KitchenRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kitchens")
@RequiredArgsConstructor
public class KitchenController {

  private final KitchenRepository kitchenRepository;

  @GetMapping
  public List<Kitchen> findAll() {
    return kitchenRepository.findAll();
  }
}
