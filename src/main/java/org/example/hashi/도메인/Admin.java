package org.example.hashi.도메인;


import lombok.*;
import jakarta.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "admins")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int password;

    public Admin(String name){
        this.name = name;
    }

    public String toString() {
        return "Admin{id=" + id + ", name='" + name +"'}";
    }

}