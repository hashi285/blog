package Blog.레포지토리;


import Blog.도메인.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByName(String name);
}