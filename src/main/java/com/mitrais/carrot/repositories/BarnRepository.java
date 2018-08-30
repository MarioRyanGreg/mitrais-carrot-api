package com.mitrais.carrot.repositories;

import com.mitrais.carrot.models.Barn;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarnRepository extends JpaRepository<Barn, Integer> {
}
