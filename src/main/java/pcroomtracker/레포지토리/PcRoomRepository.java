package pcroomtracker.레포지토리;

import pcroomtracker.도메인.PcRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PcRoomRepository extends JpaRepository<PcRoom, Long>, CrudRepository<PcRoom,Long>, PagingAndSortingRepository<PcRoom,Long> {
}
