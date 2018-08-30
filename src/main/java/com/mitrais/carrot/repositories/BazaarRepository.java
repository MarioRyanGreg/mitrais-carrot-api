package com.mitrais.carrot.repositories;

import com.mitrais.carrot.models.Bazaar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BazaarRepository extends JpaRepository<Bazaar, Integer> {
}
