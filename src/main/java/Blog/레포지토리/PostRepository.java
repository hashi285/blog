package Blog.레포지토리;

import Blog.도메인.Post;
import Blog.도메인.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository <Post, Long>, PagingAndSortingRepository<Post,Long> {

}
