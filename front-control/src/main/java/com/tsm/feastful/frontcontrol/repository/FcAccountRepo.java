package com.tsm.feastful.frontcontrol.repository;

import com.tsm.feastful.frontcontrol.entity.FcAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FcAccountRepo extends JpaRepository<FcAccount,Long> {
}
