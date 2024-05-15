package IOT_Platform.Lantern_Of_Dusk_BE.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import IOT_Platform.Lantern_Of_Dusk_BE.entity.Connection;
import IOT_Platform.Lantern_Of_Dusk_BE.repository.ConnectionRepository;

@Service
public class MobiusService {

    private final RestTemplate restTemplate;
    private final ConnectionRepository connectionRepository;

    @Autowired
    public MobiusService(RestTemplateBuilder restTemplateBuilder, ConnectionRepository connectionRepository) {
        this.restTemplate = restTemplateBuilder.build();
        this.connectionRepository = connectionRepository;
    }

    /**
     * Mobius로부터 데이터를 가져오는 메서드입니다.
     * 이 메서드는 데이터베이스에서 AE를 가져와 Mobius에 요청을 보내 데이터를 받아옵니다.
     * @return Mobius로부터 받은 데이터
     */
    public String fetchDataFromMobius() {
        // 데이터베이스에서 connection 정보를 가져옵니다.
        Connection connection = connectionRepository.findById(1).orElse(null);
        if (connection != null) {
            // connection에서 applicationEntity 값을 얻습니다.
            String aeName = connection.getApplicationEntity();
            // Mobius에 요청을 보내 데이터를 받아옵니다.
            String mobiusData = fetchDataFromMobiusForAE(aeName);
            return "Data received from Mobius for AE: " + mobiusData;
        } else {
            return "Connection not found";
        }
    }

    /**
     * 특정 AE에 해당하는 데이터를 Mobius로부터 가져오는 메서드입니다.
     * @param aeName 가져올 AE의 이름
     * @return Mobius로부터 받은 데이터
     */
    private String fetchDataFromMobiusForAE(String aeName) {
        // 여기에 Mobius에 요청을 보내 데이터를 받아오는 로직을 구현합니다.
        return "Data for AE: " + aeName;
    }
}
