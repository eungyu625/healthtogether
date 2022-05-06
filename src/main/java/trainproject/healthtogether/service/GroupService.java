package trainproject.healthtogether.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import trainproject.healthtogether.domain.group.Group;
import trainproject.healthtogether.repository.GroupRepository;

@Service
@RequiredArgsConstructor
public class GroupService {

    private final GroupRepository groupRepository;

    public void setGroup(Group group) {

        groupRepository.save(group);
    }

}
