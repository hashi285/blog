package com.hyeoksu.blog.post.service;

import com.hyeoksu.blog.post.entity.Post;
import com.hyeoksu.blog.post.entity.User;
import com.hyeoksu.blog.post.repository.PostRepository;
import com.hyeoksu.blog.post.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Transactional(readOnly = true)
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Transactional
    public Page<Post> findAllPost(Pageable pageable) {
        Pageable sortedByDescId = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(),
                Sort.by(Sort.Direction.DESC, "id"));
        return postRepository.findAll(sortedByDescId);
    }


    @Transactional(readOnly = true)
    public Post findPostById(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    @Transactional
    public Post createPost(String username, Post post) {
        User user = userRepository.findByUsername(username);
        post.setUser(user);
        return postRepository.save(post);

    }


    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    // 제목을 검색하는 메서드
    public List<Post> searchPostsByTitle(String title) {
        return postRepository.findByTitleContainingIgnoreCase(title);
    }

}