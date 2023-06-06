package com.med.calculator.repos;

import com.med.calculator.models.InfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InfoEntityRepository extends JpaRepository<InfoEntity, Long> {
}
