package com.mitrais.carrot.repositories;

import com.mitrais.carrot.models.BarnSetting;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarnSettingRepository extends CrudRepository<BarnSetting, Integer> {
}
