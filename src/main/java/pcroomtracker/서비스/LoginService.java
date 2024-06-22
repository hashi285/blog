package pcroomtracker.서비스;

import com.mysql.cj.x.protobuf.Mysqlx;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pcroomtracker.도메인.Admin;
import pcroomtracker.도메인.PcRoom;
import pcroomtracker.레포지토리.AdminRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final AdminRepository adminRepository;


    @Transactional // 관리자 추가
    public Admin addAdmin(Admin name) {
        return adminRepository.save(name);
    }

//    @Transactional // 로그인 기능
//    public Admin login(Admin admin) {
//        Optional<Admin> byId = adminRepository.findById(admin.getId());
//        if (byId.isPresent()) {
//            //조회 결과가 있다.
//            Admin admin1 = byId.get();
//            if (admin.getPassword().equals(admin1.getPassword())) {
//            }
//            return byId.get();
//        }else { //조회 결과가 없다.
//            return null;
//        }
//
//    }


}
