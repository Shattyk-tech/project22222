package peaksoft.second_project_sh.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import peaksoft.second_project_sh.dto.GroupDto;
import peaksoft.second_project_sh.dto.mapper.GroupMapper;
import peaksoft.second_project_sh.model.Group;
import peaksoft.second_project_sh.repositories.GroupRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;
    private final GroupMapper groupMapper;
    private final CourseService courseService;

    @Override
    public Group saveGroup(GroupDto groupDto, Long groupId) {
        Group group = groupMapper.create(groupDto);
        group.setCourse(courseService.getById(groupId));
        return groupRepository.save(group);
    }

    @Override
    public void removeGroupById(Long id) {
        groupRepository.deleteById(id);
    }

    @Override
    public Group getById(Long id) {
        return groupRepository.getById(id);
    }

    @Override
    public List<Group> getAllGroup() {
        return groupRepository.findAll();
    }

    @Override
    @Transactional
    public GroupDto update(GroupDto group, Long id) {
        Group group1 = groupRepository.findById(id)
                .orElseThrow(() -> {
                    throw new NotFoundException(
                            String.format("group with id = %s  does not exist", id)
                    );
                });

        String currentName = group1.getGroupName();
        String newName = group.getGroupName();
        if (!Objects.equals(currentName, newName)) {
            group1.setGroupName(newName);
        }

        String dateOfStart = group1.getDateOfStart();
        String newDateOfStart = group.getGroupName();
        if (!Objects.equals(dateOfStart, newDateOfStart)) {
            group1.setDateOfStart(newDateOfStart);
        }

        String dateOfFinish = group1.getDateOfFinish();
        String newDateOfFinish = group.getDateOfFinish();
        if (!Objects.equals(dateOfFinish, newDateOfFinish)) {
            group1.setDateOfFinish(newDateOfFinish);
        }
        return group;
    }

}
