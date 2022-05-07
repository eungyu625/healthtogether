package trainproject.healthtogether.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import trainproject.healthtogether.domain.exercise.Record;
import trainproject.healthtogether.repository.RecordRepository;
import trainproject.healthtogether.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class RecordService {

    private final UserRepository userRepository;
    private final RecordRepository recordRepository;

    // 운동 기록 남기기
    public void create(Record record) {

        recordRepository.save(record);
    }

    // 달력에서 선택한 날짜의 운동 기록 조회

}