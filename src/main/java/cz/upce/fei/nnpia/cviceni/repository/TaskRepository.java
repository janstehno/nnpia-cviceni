package cz.upce.fei.nnpia.cviceni.repository;

import cz.upce.fei.nnpia.cviceni.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
