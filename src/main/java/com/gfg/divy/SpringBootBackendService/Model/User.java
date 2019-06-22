package com.gfg.divy.SpringBootBackendService.Model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class User {
    @Getter @Setter @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Getter @Setter
    private String first_name;
    @Getter @Setter
    private String last_name;

    public User(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
    }
}
