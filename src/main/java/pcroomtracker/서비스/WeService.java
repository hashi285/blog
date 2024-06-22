package pcroomtracker.서비스;

import pcroomtracker.도메인.PcRoom;
import pcroomtracker.레포지토리.AdminRepository;
import pcroomtracker.레포지토리.PcRoomRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class WeService {
    private final PcRoomRepository pcRoomRepository;
    private final AdminRepository adminRepository;

    @Transactional
    public List<PcRoom> findAll() {
        return pcRoomRepository.findAll();
    }

};