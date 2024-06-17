package com.fonyou.test_manager.repository;
	
import com.fonyou.test_manager.model.Examen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamenRepository extends JpaRepository<Examen, Long> {
}