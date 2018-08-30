package com.mitrais.carrot.repositories;

import com.mitrais.carrot.models.SharingLevel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SharingLevelRepository extends JpaRepository<SharingLevel, Integer> {

    @Override
    public void delete(SharingLevel deleted);

}
