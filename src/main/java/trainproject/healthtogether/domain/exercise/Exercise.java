package trainproject.healthtogether.domain.exercise;

import lombok.Getter;
import trainproject.healthtogether.domain.user.User;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Exercise {
    @Id
    @GeneratedValue
    @Column(name = "exercise_id")
    private Long id;

    @OneToMany(mappedBy = "exercise")
    private List<Record> records = new ArrayList<>();

    private String name; // 운동 이름
    private Long count; // 운동 횟수
    private Long time;  // 소요 시간
    private String video_url; // 영상 링크

}
