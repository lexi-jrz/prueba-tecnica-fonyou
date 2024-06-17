package com.fonyou.test_manager.repository;

import com.fonyou.test_manager.model.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreguntaRepository extends JpaRepository<Pregunta, Long> {
}
