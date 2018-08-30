package com.mitrais.carrot.repositories;

import com.mitrais.carrot.models.Rewards;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RewardsRepository extends JpaRepository<Rewards, Integer> {
}
