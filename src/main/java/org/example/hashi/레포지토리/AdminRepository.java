package org.example.hashi.레포지토리;

import org.example.hashi.도메인.Admin;
import org.example.hashi.도메인.Ip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AdminRepository extends JpaRepository<Admin, Long>, CrudRepository<Admin,Long>, PagingAndSortingRepository<Admin,Long> {
}
