package cz.upce.fei.nnpia.cviceni.repository;

import cz.upce.fei.nnpia.cviceni.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    @Query("SELECT u FROM AppUser u WHERE u.active = :active")
    List<AppUser> findAppUsersByActive(@Param("active") boolean active);

    @Query("SELECT DISTINCT u FROM AppUser u JOIN u.roles r ON r.name = :name")
    List<AppUser> findAppUsersByRoleName(@Param("name") String name);
}
