package com.algaworks.algafood.api.controller;

import com.algaworks.algafood.domain.model.State;
import com.algaworks.algafood.domain.repository.StateRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/states")
@RequiredArgsConstructor
public class StateController {

  private final StateRepository kitchenRepository;

  @GetMapping
  public List<State> findAll() {
    return kitchenRepository.findAll();
  }
}
