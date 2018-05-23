package com.example.demo.repository;

import com.example.demo.model.BonusInfo;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BonusInfoRepo extends JpaRepository<BonusInfo, Integer> {

    @Override
    List<BonusInfo> findAll();
    BonusInfo findBonusInfoByUser(User user);
}
