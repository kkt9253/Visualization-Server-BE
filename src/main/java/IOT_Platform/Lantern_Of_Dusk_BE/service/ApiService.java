package IOT_Platform.Lantern_Of_Dusk_BE.service;

import IOT_Platform.Lantern_Of_Dusk_BE.entity.Connection;
import IOT_Platform.Lantern_Of_Dusk_BE.repository.ConnectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApiService {

    private final ConnectionRepository connectionRepository;

    @Autowired
    public ApiService(ConnectionRepository connectionRepository) {
        this.connectionRepository = connectionRepository;
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
}
