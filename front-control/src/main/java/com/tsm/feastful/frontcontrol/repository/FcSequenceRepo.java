package com.tsm.feastful.frontcontrol.repository;

import com.tsm.feastful.frontcontrol.entity.FcSequence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FcSequenceRepo extends JpaRepository<FcSequence,Long> {
    FcSequence getBySequenceName(String sequenceName);
}
