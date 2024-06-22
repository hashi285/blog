package pcroomtracker.컨트롤러;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pcroomtracker.도메인.Admin;
import pcroomtracker.서비스.LoginService;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Controller
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;

    @GetMapping("/1") //로그인
    public String login(Model model) {
        model.addAttribute("admin", new Admin());
        return "login";
    }


    @PostMapping("/1") //로그인
    public String login1(@Valid @ModelAttribute("admin") Admin admin,
                            BindingResult result) {
        if (result.hasErrors()) {// 로그인 실패
            return "login";
        } else {// 로그인 성공
            return "main_screen";
        }
}



    @GetMapping("/2")
    public String account1(Model model){ // 회원가입 화면 完
        model.addAttribute("admin", new Admin());
        return "make";
    }

    @PostMapping("/2") // 정보 입력 후 로그인 화면으로 이동 完
    public String account2(@ModelAttribute Admin admin) {
        loginService.addAdmin(admin);
        return "redirect:/login/1";
    }

}
