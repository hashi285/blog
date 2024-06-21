package org.example.hashi.서비스;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.hashi.도메인.Admin;
import org.example.hashi.도메인.PcRoom;
import org.example.hashi.레포지토리.AdminRepository;
import org.example.hashi.레포지토리.IpRepository;
import org.example.hashi.레포지토리.PcRoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class WeService {
    private final IpRepository ipRepository;
    private final PcRoomRepository pcRoomRepository;
    private final AdminRepository adminRepository;

    @Transactional
    public List<PcRoom> findAll() {
        return pcRoomRepository.findAll();
    }

    @Transactional // ip 가져오기
    public PcRoom getip(Long id) {
        return pcRoomRepository.findById(id).orElse(null);
    }

    @Transactional // 새로운 ip 저장
    public PcRoom addName(String name){
        return pcRoomRepository.save(new PcRoom(name));
    }

    @Transactional // ip 가져오기
    public Admin getAdmin(Long id) {
        return adminRepository.findById(id).orElse(null);
    }




}