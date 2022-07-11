package trainproject.healthtogether.repository.apirepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import trainproject.healthtogether.domain.group.Attend;
import trainproject.healthtogether.domain.group.ExerciseGroup;
import trainproject.healthtogether.domain.manytomany.UserGroup;
import trainproject.healthtogether.domain.user.User;
import trainproject.healthtogether.dto.AttendDto;
import trainproject.healthtogether.dto.ExerciseGroupDto;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class ExerciseGroupApiRepository {

    private final EntityManager em;

    public List<ExerciseGroupDto> findExerciseGroupAll() {

        return em.createQuery("select new trainproject.healthtogether.dto.ExerciseGroupDto(e.id, e.exerciseGroupName, e.intro, e.count, e.startDate, e.targetDay, e.video_title, e.video_url," +
                        "e.groupAttendRate)" +
                " from ExerciseGroup e", ExerciseGroupDto.class)
                .getResultList();
    }

    public List<ExerciseGroupDto> findExerciseGroup(Long exerciseGroupId) {

        return em.createQuery("select new trainproject.healthtogether.dto.ExerciseGroupDto(e.id, e.exerciseGroupName, e.intro, e.count, e.startDate, e.targetDay, " +
                "e.video_title, e.video_url, e.groupAttendRate)" +
                " from ExerciseGroup e" +
                " where e.id=:exerciseGroupId", ExerciseGroupDto.class)
                .setParameter("exerciseGroupId", exerciseGroupId)
                .getResultList();
    }

    public List<ExerciseGroupDto> findExerciseGroupListByUser(User user) {

        List<ExerciseGroup> exerciseGroupList = new ArrayList<>();

        for (UserGroup userGroup : user.getUserGroupList()) {

            exerciseGroupList.add(userGroup.getExerciseGroup());
        }


        List<ExerciseGroupDto> result = new ArrayList<>();

        for (ExerciseGroup exerciseGroup : exerciseGroupList) {
            //result.add(new ExerciseGroupDto(exerciseGroup.getId(), exerciseGroup.getExerciseGroupName(), exerciseGroup.getIntro(), exerciseGroup.getRoutineTime(), exerciseGroup.getStartDate(), exerciseGroup.getTargetDay(), exerciseGroup.getUserGroupList()));
        }

        return result;
    }

    public List<AttendDto> findAttendByExerciseGroup(ExerciseGroup exerciseGroup) {

        List<AttendDto> attendList = new ArrayList<>();

        for (Map.Entry<User, Attend> member : exerciseGroup.getAttendList().entrySet()) {
            attendList.add(new AttendDto(member.getKey(), member.getValue().getJoinDate(), member.getValue().attendanceRate()));
        }

        return attendList;
    }
}
