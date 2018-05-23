package com.example.demo.service;

import com.example.demo.model.BonusInfo;
import com.example.demo.model.User;
import com.example.demo.repository.BonusInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BonusInfoService {
    @Autowired
    private BonusInfoRepo bonusInfoRepo;

    public List<BonusInfo> list(){return bonusInfoRepo.findAll();}

    public void addBonusInfo(BonusInfo bonusInfo){
        bonusInfoRepo.save(bonusInfo);
    }

    public void saveBonusInfo(User user, BonusInfo bonusInfo) {
        int x = 0;
        List<BonusInfo> templist = list();
        for (int i = 0; i < templist.size(); i++) {
            if (templist.get(i).getUser() == user) {
                BonusInfo tempBonusinfo = bonusInfoRepo.findBonusInfoByUser(user);
                tempBonusinfo.setCity(bonusInfo.getCity());
                tempBonusinfo.setCountry(bonusInfo.getCountry());
                tempBonusinfo.setStreetname(bonusInfo.getStreetname());
                addBonusInfo(tempBonusinfo);
                x++;
                break;
            }
        }
        if (x == 0) {
            bonusInfo.setUser(user);
            addBonusInfo(bonusInfo);
        }
    }
}
