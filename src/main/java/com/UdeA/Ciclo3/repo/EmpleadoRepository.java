package com.UdeA.Ciclo3.repo;

import com.UdeA.Ciclo3.modelos.Empleado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends CrudRepository<Empleado, Integer> {
}
