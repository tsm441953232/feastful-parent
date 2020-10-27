package com.tsm.feastful.rmsmain.repository;

import com.tsm.feastful.rmsmain.entity.RmsPolicySelection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RmsPolicySelectionRepo extends JpaRepository<RmsPolicySelection, Long> {

    List<RmsPolicySelection> findByNodeCodeAndBusinessTypeOrderBySequenceAsc(String nodeCode,String businessType);

}
