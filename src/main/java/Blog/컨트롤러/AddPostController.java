package Blog.컨트롤러;



import Blog.도메인.Post;
import Blog.서비스.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/posts")
@RequiredArgsConstructor
public class AddPostController {
    private final PostService postService;

    @GetMapping("/new")
    public String newPostForm(Model model) {
        model.addAttribute("post", new Post());
        return "newPost";
    }

    @PostMapping
    public String createPost(Post post) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        postService.createPost(username, post);
        return "redirect:/list";
    }
}