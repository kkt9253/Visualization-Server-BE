package IOT_Platform.Lantern_Of_Dusk_BE.repository;

import IOT_Platform.Lantern_Of_Dusk_BE.entity.position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface positionRepository extends JpaRepository<position, Integer> {
}