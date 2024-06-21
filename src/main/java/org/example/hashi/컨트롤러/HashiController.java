package org.example.hashi.컨트롤러;

import lombok.RequiredArgsConstructor;
import org.example.hashi.Calculation;
import org.example.hashi.도메인.PcRoom;
import org.example.hashi.서비스.WeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Controller
@RequiredArgsConstructor
public class HashiController {
    private final WeService weService;

    @GetMapping("/1")
    public String hello(Model model) {
        model.addAttribute("calculation", new Calculation());
        return "head";
    }
    @PostMapping("/1")
    public String hello(@ModelAttribute Calculation calculation, Model model){
        InetAddress pingcheck = null;
        try {
            pingcheck = InetAddress.getByName(calculation.getNumber1());
            boolean isAlive = pingcheck.isReachable(5000);
            System.out.println(isAlive + "-----------------------------------------------+");
            model.addAttribute("result" , isAlive);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "result";
    }







    @GetMapping("/all")
    public String all(Model model) {
        model.addAttribute("calculation", new Calculation());
        return "head";
    }



    @GetMapping(value = "/{id}")
    public PcRoom getTodo(@PathVariable("id") Long id) {
        return weService.getip(id);
    }









    //---------------------------------------------------------------------------------------------------여기가 진짜다

    @GetMapping("/2") //로그인 화면
    public String login(Model model) {
        model.addAttribute("calculation", new Calculation());
        return "login";
    }

    @PostMapping("/2")
    public String login1(Model model) {
        return "login";
    }


    @GetMapping("/3")
    public String login3(Model model){ // 회원가입 화면
        return "make";
    }

    @PostMapping("/3") // 정보 입력 후 로그인 화면으로 이동
    public String login4(Model model) {
        return "redirect:/2";
    }



}