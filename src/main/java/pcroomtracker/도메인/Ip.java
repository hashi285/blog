package pcroomtracker.도메인;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ips")
@Getter
@Setter
public class Ip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique=false)
    private String ip;

    @ManyToOne
    @JoinColumn(name = "pcRoom_id")
    private PcRoom pcRoom;
}
