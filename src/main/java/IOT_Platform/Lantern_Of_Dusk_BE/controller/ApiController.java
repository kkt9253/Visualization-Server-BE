package IOT_Platform.Lantern_Of_Dusk_BE.controller;

import IOT_Platform.Lantern_Of_Dusk_BE.entity.Connection;
import IOT_Platform.Lantern_Of_Dusk_BE.entity.Position;
import IOT_Platform.Lantern_Of_Dusk_BE.service.ApiService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/device")
public class ApiController {

    private final ApiService apiService;

    // GET /api/device/connection/list ⇒ 모든 연결 정보 / X
    @GetMapping("/connection/list")
    public List<Connection> getConnectionAll() {
        return apiService.findAll();
    }

    // GET /api/device/connection/:id ⇒ 특정 아이디의 연결 정보 / (int id)
    @GetMapping("/connection/{id}")
    public ResponseEntity<Connection> getConnection(@PathVariable int id) {

        try {
            Connection connection = apiService.findById(id);
            if (connection != null) {
                return new ResponseEntity<>(connection, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // POST /api/device/connection ⇒ 연결 정보 생성 / json {id, name, applicationEntity}
    @PostMapping("/connection")
    public ResponseEntity<Connection> postConnection(@RequestBody Connection connectionContext) {

        try {
            if (apiService.findById(connectionContext.getId()) == null) {
                apiService.save(connectionContext);
                return new ResponseEntity<>(apiService.findById(connectionContext.getId()), HttpStatus.CREATED);
            } else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // PUT /api/device/connection/{id} ⇒ 연결 정보 업데이트 / (int id), json {id, name, applicationEntity}
    @PutMapping("/connection/{id}")
    public ResponseEntity<Connection> updateConnection(@PathVariable int id, @RequestBody Connection updatedConnection) {

        try {
            if (apiService.findById(id) != null) {
                Connection pastConnection = apiService.findById(id);
                pastConnection.setId(updatedConnection.getId());
                pastConnection.setName(updatedConnection.getName());
                pastConnection.setApplicationEntity(updatedConnection.getApplicationEntity());
                apiService.save(pastConnection);
                return new ResponseEntity<>(apiService.findById(id), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // DELETE /api/device/connection/:id ⇒ 연결 정보 삭제 / (int id)
    @DeleteMapping("/connection/{id}")
    public ResponseEntity<String> deleteConnection(@PathVariable int id) {

        try {
            if (apiService.findById(id) != null) {
                apiService.deleteById(id);
                return new ResponseEntity<>("ID의 ae가 삭제되었습니다", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("요청에 문제가 있습니다.", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("서버에 오류 발생했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // DELETE /api/device/connection ⇒ 연결 정보 삭제 / (int id)
    @DeleteMapping("/connection")
    public ResponseEntity<String> deleteAllConnection() {

        apiService.deleteAll();
        return new ResponseEntity<>("전체 connection-ae가 삭제되었습니다.", HttpStatus.OK);
    }

    // GET /api/device/position/:deviceId ⇒ deviceId 위치정보 / (int deviceId)
    @GetMapping("/position/{deviceId}")
    public ResponseEntity<Position> getPositionByDeviceId(@PathVariable int deviceId) {

        try {
            if (apiService.findById(deviceId) != null && apiService.getApplicationEntityByDeviceId(deviceId) != null) {
                Position position = apiService.getApplicationEntityByDeviceId(deviceId);
                return new ResponseEntity<>(position, HttpStatus.OK);
            } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
