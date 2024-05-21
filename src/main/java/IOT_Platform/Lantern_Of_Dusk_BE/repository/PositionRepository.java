package IOT_Platform.Lantern_Of_Dusk_BE.repository;

import IOT_Platform.Lantern_Of_Dusk_BE.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PositionRepository extends JpaRepository<Position, Integer> {
    Optional<Position> findTopByDeviceIdOrderByIdDesc(int deviceId);
}
