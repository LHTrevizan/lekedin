package com.let.trevizan.lekedin.repositories;

import com.let.trevizan.lekedin.models.Hobbie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HobbieRepository extends JpaRepository<Hobbie, Long>{

}
