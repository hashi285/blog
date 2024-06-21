package org.example.hashi.도메인;

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
    private String name;

    @OneToMany(mappedBy = "pcRoom")
    private List<Ip> ips = new ArrayList<>();

    public PcRoom(String name) {
        this.name = name;
    }

    public String toString() {
        return "Admin{id=" + id + ", 피시방 이름='" + name +"'}";
    }

}
