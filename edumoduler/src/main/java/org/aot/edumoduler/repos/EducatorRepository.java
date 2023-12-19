package org.aot.edumoduler.repos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import org.aot.edumoduler.models.*;


@Repository
 public interface EducatorRepository extends JpaRepository<educator, String> {
	Optional<educator> findByEmail(String email);
}
