package com.mitrais.carrot.repositories;

import com.mitrais.carrot.models.BazaarItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BazaarItemRepository extends JpaRepository<BazaarItem, Integer> {
}
