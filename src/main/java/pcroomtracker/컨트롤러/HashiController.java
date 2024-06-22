package pcroomtracker.컨트롤러;

import lombok.RequiredArgsConstructor;
import pcroomtracker.Calculation;
import pcroomtracker.도메인.PcRoom;
import pcroomtracker.서비스.WeService;
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
    public String hello(@ModelAttribute Calculation calculation, Model model) {
        InetAddress pingcheck = null;
        try {
            pingcheck = InetAddress.getByName(calculation.getNumber1());
            boolean isAlive = pingcheck.isReachable(5000);
            System.out.println(isAlive + "-----------------------------------------------+");
            model.addAttribute("result", isAlive);
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




    //---------------------------------------------------------------------------------------------------여기가 진짜다

    @GetMapping("/300")
    public String mainscreen(Model model) {
        model.addAttribute("hashi", new Object());
        return "main_screen";
    }



    //---------------------------------------------------

    @GetMapping("/1") // 현재 사용량 테이블로 나타내기
    public String m1(Model model) {
        weService.findAll();
        return "main_screen";
    }

}