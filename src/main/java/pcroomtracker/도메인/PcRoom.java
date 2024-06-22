package pcroomtracker.도메인;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pcRooms")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class PcRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name; // 매장명
    @Column(nullable = false)
    private String area; // 지역
    @Column
    private String etc; //기타
    @Column
    private String rateplan; //요금제
    @Column
    private String telecom; //통신사
    @Column
    private String specification; // 사양
    @Column(nullable = false)
    private String ip; //마지막 . 앞자리까지의 값
    @Column(nullable = false)
    private int how_pc; // 컴퓨터 양

}


