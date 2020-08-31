package com.let.trevizan.lekedin.repositories;

import com.let.trevizan.lekedin.models.ProfessionalInterest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessionalInterestRepository extends JpaRepository<ProfessionalInterest, Long> {
}