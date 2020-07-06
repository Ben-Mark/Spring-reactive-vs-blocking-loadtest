package com.olympus.blocking.couchbase.service;


import com.olympus.blocking.couchbase.model.Building;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

public interface BuildingService {

    Building save(@Valid Building building);

    Optional<Building> findById(String buildingId);

    List<Building> findByCompanyId(String companyId);

    Building findByCompanyAndAreaId(String companyId, String areaId);

    List<Building> findByCompanyIdAndNameLike(String companyId, String name, int page);

    List<Building> findByPhoneNumber(String telephoneNumber);

    Long countBuildings(String companyId);

}