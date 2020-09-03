package com.tsm.feastful.frontcontrol.repository;

import com.tsm.feastful.frontcontrol.entity.FcSysParam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FcSysParamRepo extends JpaRepository<FcSysParam,Long> {

    FcSysParam getByParamIndex(String ParamIndex);

    FcSysParam saveAndFlush(FcSysParam fcSysparam);

}
