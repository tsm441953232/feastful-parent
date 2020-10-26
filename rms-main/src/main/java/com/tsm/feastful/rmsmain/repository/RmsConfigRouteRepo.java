package com.tsm.feastful.rmsmain.repository;

import com.tsm.feastful.rmsmain.entity.RmsConfigRoute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RmsConfigRouteRepo extends JpaRepository<RmsConfigRoute,Long> {

    RmsConfigRoute getByRouteCode(String routeCode);
}
