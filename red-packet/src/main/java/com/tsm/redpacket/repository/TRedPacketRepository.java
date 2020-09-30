package com.tsm.redpacket.repository;

import com.tsm.redpacket.entity.TRedPacket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TRedPacketRepository extends JpaRepository<TRedPacket,Integer> {

    @Modifying
    @Query(nativeQuery = true , value = "update T_RED_PACKET set stock = stock - 1 where id =:id")
    int decreaseRedPacket(@Param("id") Integer id);

    /*@Query(nativeQuery = true , value = "update T_RED_PACKET set stock = stock - 1 where id = :id")
    int decreaseRedPacketForUpdate(@Param("id") Integer id);

    @Query(nativeQuery = true , value = "update T_RED_PACKET set stock = stock - 1 where id = :id")
    int decreaseRedPacket(@Param("id") Integer id);*/
}
