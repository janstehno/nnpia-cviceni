package cz.upce.fei.nnpia.cviceni.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class AppRole {
    @Id
    private Long id;
    @Column
    private String name;
    @ManyToMany
    @JoinColumn(name = "users_id", nullable = false)
    @ToString.Exclude
    private List<AppUser> users;
}
