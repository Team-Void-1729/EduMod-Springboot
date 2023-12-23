package org.aot.edumoduler.repos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import org.aot.edumoduler.models.*;

 
@Repository
public interface CourseRepository extends JpaRepository<course, String> {
	Optional<course> findByTitle(String title);
}
