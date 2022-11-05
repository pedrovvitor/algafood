package com.algaworks.algafood.domain.repository;

import com.algaworks.algafood.domain.model.City;
import java.util.List;

public interface CityRepository {

  List<City> findAll();

  City findById(Long id);

  City save(City kitchen);

  void remove(City kitchen);
}
