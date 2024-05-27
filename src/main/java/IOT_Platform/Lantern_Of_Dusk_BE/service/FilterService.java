package IOT_Platform.Lantern_Of_Dusk_BE.service;

import IOT_Platform.Lantern_Of_Dusk_BE.entity.Data;
import org.springframework.stereotype.Service;

import java.util.Queue;

@Service
public class FilterService {

    /**
     * 데이터 큐를 받아 필터링하고 위치 정보를 생성하는 메서드.
     *
     * @param aeName AE의 이름
     * @param queue  데이터 큐
     */
    public void processDataQueue(String aeName, Queue<Data> queue) {
        // 데이터 큐를 처리하고 필터링 및 위치 정보 생성 작업 수행
        while (!queue.isEmpty()) {
            Data data = queue.poll();
            // 필터링 및 위치 정보 생성 작업 수행
            // 예: Position position = filterAndCreatePosition(data);
            //     repository.save(position);
        }
    }

    // 필터링 및 위치 정보 생성에 필요한 추가 메서드들을 여기에 추가할 수 있습니다.

}
