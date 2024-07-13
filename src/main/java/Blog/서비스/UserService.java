package Blog.서비스;

import Blog.도메인.Post;
import Blog.도메인.Role;
import Blog.도메인.User;
import Blog.레포지토리.PostRepository;
import Blog.레포지토리.RoleRepository;
import Blog.레포지토리.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PostRepository postRepository;
    private final PasswordEncoder passwordEncoder;

    //회원가입
    @Transactional
    public User registUser(User user){
        //role 추가
        Role userRole = roleRepository.findByName("USER");
        user.setRoles(Collections.singleton(userRole));
        //password 암호화해서 넣어줘야한다.
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        // user에서 password를 가져온 뒤 인코드를 하고 password를 DB에 저장을 한다.

        return  userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }


    @Transactional
    //페이징 처리된 친구 목록 조회
    public Page<Post> findAllPost(Pageable pageable){
        Pageable sortedByDescId =  PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(),
                Sort.by(Sort.Direction.DESC,"id"));

        return postRepository.findAll(sortedByDescId);
    }
    //id에 해당하는 친구정보조회
    @Transactional(readOnly = true)
    public Post findPostById(Long id){
        return postRepository.findById(id).orElse(null);
    }
}