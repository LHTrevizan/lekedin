package com.let.trevizan.lekedin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.let.trevizan.lekedin.models.Profile;

@Repository

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}