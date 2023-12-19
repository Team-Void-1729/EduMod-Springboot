package org.aot.edumoduler.repos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.aot.edumoduler.models.*;


@Repository
 public interface CurriculumRepository extends JpaRepository<curriculum, String> {
	
}
