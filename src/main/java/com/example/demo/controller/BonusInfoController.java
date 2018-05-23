package com.example.demo.controller;

import com.example.demo.model.BonusInfo;
import com.example.demo.model.User;
import com.example.demo.service.BonusInfoService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BonusInfoController {

    @Autowired
    private BonusInfoService bonusInfoService;
    @Autowired
    private UserService userService;

    @GetMapping(value= "/home/bonusInfo")
    public String edit( Model model) {
        BonusInfo bonusInfo = new BonusInfo();
        model.addAttribute("bonusInfo", bonusInfo);
        return "home/bonusInfo";
    }

    @PostMapping(value= "/home/bonusInfo/")
    public String edit(@ModelAttribute BonusInfo bonusInfo, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth.getName());
        User user = userService.findUserByEmail(auth.getName());
        bonusInfoService.saveBonusInfo(user,bonusInfo);
        return "/home/bonusInfo";
    }
}
