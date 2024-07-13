package Blog.컨트롤러;

import Blog.도메인.Post;
import Blog.도메인.User;
import Blog.서비스.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/make")
    public String userregform(){
        return "login_register/make";
    }
    
    @PostMapping("/make")
    public String userreg(@ModelAttribute("user") User user, BindingResult result){
        if(result.hasErrors()){
            return "login_register/make";
        }
        User byUsername = userService.findByUsername(user.getUsername());
        if(byUsername != null){
            result.rejectValue("username",null,"이미 사용중인 아이디입니다.");
            return "login_register/make";
        }

        userService.registUser(user);
        return "redirect:/login_register/login";
    }

    @GetMapping("/main")
    public String welcome(){
        return "main_screen/main";
    }

    @PostMapping("/main")
    public String wecome(){
        return "main_screen/main";
    }

    @GetMapping("/login")
    public String loginform(){
        return "login_register/login";
    }


    @GetMapping("/list")
    public String friends(Model model, User user, @RequestParam(defaultValue = "1") int page,
                          @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page - 1, size);

        Page<Post> post = userService.findAllPost(pageable);
        model.addAttribute("posts", post.getContent()); // 수정: 실제 포스트 리스트를 전달
        model.addAttribute("currentPage", page);
        String name = user.getUsername();
        model.addAttribute("name", name);
        // other attributes and logic
        return "list";
    }


    @GetMapping("title/{id}")
    public String detailPost(@PathVariable Long id, Model model) {

        Post post = userService.findPostById((Long) id);
        model.addAttribute("post", post);
        return "title";
    }//


}