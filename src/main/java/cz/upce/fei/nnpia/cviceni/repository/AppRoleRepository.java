package cz.upce.fei.nnpia.cviceni.repository;

import cz.upce.fei.nnpia.cviceni.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRoleRepository extends JpaRepository<AppRole, Long> {
}
