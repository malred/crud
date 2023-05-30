package org.malred.repository;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import org.malred.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student,Integer> {
}
