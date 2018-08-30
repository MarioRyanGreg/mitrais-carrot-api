package com.mitrais.carrot.repositories;

import com.mitrais.carrot.models.ShareType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShareTypeRepository extends JpaRepository<ShareType, Integer> {
}
