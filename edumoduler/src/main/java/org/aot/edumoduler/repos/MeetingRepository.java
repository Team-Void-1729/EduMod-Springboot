package org.aot.edumoduler.repos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import org.aot.edumoduler.models.*;


@Repository
 public interface MeetingRepository extends JpaRepository<meeting, String> {
	
	Optional<meeting> findById(String id);
}
