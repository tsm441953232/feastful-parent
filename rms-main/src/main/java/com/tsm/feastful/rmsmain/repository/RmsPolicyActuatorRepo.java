package com.tsm.feastful.rmsmain.repository;

import com.tsm.feastful.rmsmain.entity.RmsPolicyActuator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RmsPolicyActuatorRepo extends JpaRepository<RmsPolicyActuator, Long> {

    List<RmsPolicyActuator> findByRuleSetCode(String ruleSetCode);
}
