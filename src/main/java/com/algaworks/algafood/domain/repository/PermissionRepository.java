package com.algaworks.algafood.domain.repository;

import com.algaworks.algafood.domain.model.Permission;
import java.util.List;

public interface PermissionRepository {

  List<Permission> findAll();

  Permission findById(Long id);

  Permission save(Permission kitchen);

  void remove(Permission kitchen);
}
