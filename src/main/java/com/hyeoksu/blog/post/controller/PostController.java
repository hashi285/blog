package com.hyeoksu.blog.post.controller;

import com.hyeoksu.blog.post.entity.Post;
import com.hyeoksu.blog.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;


    @GetMapping("/new")
    public String newPostForm(Model model) {
        model.addAttribute("post", new Post());
        return "newPost";
    }

    @GetMapping ("/edit/{id}")// 수정 폼
    public String edit(Model model, @PathVariable Long id) {
        Post postById = postService.findPostById(id);
        model.addAttribute("post" , postById);
        return "edit";
    }


    @GetMapping
    public String listPosts(Model model) {
        List<Post> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);
        return "listPosts";
    }
    // 검색 요청을 처리하는 메서드
    @GetMapping("/search")
    public String searchPosts(@RequestParam("title") String title, Model model) {
        List<Post> posts = postService.searchPostsByTitle(title);
        model.addAttribute("posts", posts);
        return "listPosts";
    }
}