package Blog.서비스;

import Blog.도메인.Post;
import Blog.도메인.User;
import Blog.레포지토리.PostRepository;
import Blog.레포지토리.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        if (user != null) {
            post.setUser(user);
            return postRepository.save(post);
        } else {
            throw new RuntimeException("User not found");
        }
    }
}
