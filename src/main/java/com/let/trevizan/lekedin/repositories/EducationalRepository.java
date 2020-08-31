package com.let.trevizan.lekedin.repositories;

import com.let.trevizan.lekedin.models.Educational;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface EducationalRepository extends JpaRepository<Educational, Long> {
}