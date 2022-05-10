package trainproject.healthtogether.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import trainproject.healthtogether.domain.group.Group;
import trainproject.healthtogether.domain.user.User;
import trainproject.healthtogether.repository.GroupRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class GroupService {

    private final GroupRepository groupRepository;

    public void newGroup(Group group) {

        groupRepository.save(group);
    }

    public Optional<Group> findGroupById(Long id) {

        return groupRepository.findById(id);
    }

    public List<Group> findAll() {
        return groupRepository.findAll();
    }
}
