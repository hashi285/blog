package org.example.hashi.레포지토리;


import org.example.hashi.도메인.Ip;
import org.example.hashi.도메인.PcRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IpRepository extends JpaRepository<Ip, Long>, CrudRepository<Ip,Long>, PagingAndSortingRepository<Ip,Long> {
}
