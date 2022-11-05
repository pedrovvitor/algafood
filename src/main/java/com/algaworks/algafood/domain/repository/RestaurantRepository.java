package com.algaworks.algafood.domain.repository;

import com.algaworks.algafood.domain.model.Restaurant;
import java.util.List;

public interface RestaurantRepository {

  List<Restaurant> findAll();

  Restaurant findById(Long id);

  Restaurant save(Restaurant kitchen);

  void remove(Restaurant kitchen);
}
