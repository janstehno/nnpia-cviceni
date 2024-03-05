package cz.upce.fei.nnpia.cviceni.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    @NotNull
    @NotEmpty
    @Length(max = 20)
    private String username;
    @Column
    private String password;
    @Column
    private Boolean active;
    @Column
    private LocalDateTime creation_date;
    @Column
    private LocalDateTime update_date;
    @ManyToMany(mappedBy = "users")
    private List<AppRole> roles;
    @OneToMany(mappedBy = "author")
    private List<Task> tasks;
}
