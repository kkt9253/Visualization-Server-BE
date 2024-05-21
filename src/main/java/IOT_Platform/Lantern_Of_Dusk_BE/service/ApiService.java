package IOT_Platform.Lantern_Of_Dusk_BE.service;

import IOT_Platform.Lantern_Of_Dusk_BE.entity.Connection;
import IOT_Platform.Lantern_Of_Dusk_BE.entity.Position;
import IOT_Platform.Lantern_Of_Dusk_BE.repository.ConnectionRepository;
import IOT_Platform.Lantern_Of_Dusk_BE.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApiService {

    private final ConnectionRepository connectionRepository;
    private final PositionRepository positionRepository;

    @Autowired
    public ApiService(ConnectionRepository connectionRepository, PositionRepository positionRepository) {
        this.connectionRepository = connectionRepository;
        this.positionRepository = positionRepository;
    }

    public void save(Connection connection) {
        connectionRepository.save(connection);
    }

    public Connection findById(int id) {
        return connectionRepository.findById(id).orElse(null);
    }

    public List<Connection> findAll() {
        return connectionRepository.findAll();
    }

    public void deleteById(int id) {
        connectionRepository.deleteById(id);
    }

    public void deleteAll() {
        connectionRepository.deleteAll();
    }

    public Position getApplicationEntityByDeviceId(int deviceId) {
        return positionRepository.findTopByDeviceIdOrderByIdDesc(deviceId).orElse(null);
    }
}