package peaksoft.second_project_sh.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import peaksoft.second_project_sh.dto.mapper.GroupMapper;
import peaksoft.second_project_sh.dto.response.GroupDto;
import peaksoft.second_project_sh.model.Group;
import peaksoft.second_project_sh.repositories.GroupRepository;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;
    private final GroupMapper groupMapper;
    private  final  CourseService courseService;

    @Override
    public Group saveGroup(GroupDto groupDto,Long groupId) {
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
    public Group update(Group group, Long id) {
        Group group1 = getById(id);

        String currentName = group1.getGroupName();
        String newName = group1.getGroupName();
        if (!Objects.equals(currentName, newName)) {
            group1.setGroupName(newName);


            String dateOfStart = group.getDateOfStart();
            String newDateOfStart = group1.getGroupName();
            if (!Objects.equals(dateOfStart, newDateOfStart)) {
                group.setDateOfStart(newDateOfStart);
                log.info("Group with id = {} changed name from {} to {}",
                        id, dateOfStart, newDateOfStart);
            }
            String dateOfFinish = group.getDateOfFinish();
            String newDateOfFinish = group1.getDateOfFinish();
            if (!Objects.equals(dateOfFinish, newDateOfFinish)) {
                group.setDateOfFinish(newDateOfFinish);
                log.info("Group with id = {} changed name from {} to {}",
                        id, dateOfFinish, newDateOfFinish);
            }
            String message = String.format("Group with groupId = %s has successfully updated", id);
        }
        return group1;
    }

}
