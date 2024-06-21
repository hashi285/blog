package pcroomtracker.레포지토리;

import pcroomtracker.도메인.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AdminRepository extends JpaRepository<Admin, Long>, CrudRepository<Admin,Long>, PagingAndSortingRepository<Admin,Long> {
}
