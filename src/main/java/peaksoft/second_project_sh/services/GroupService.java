package peaksoft.second_project_sh.services;

import peaksoft.second_project_sh.dto.GroupDto;
import peaksoft.second_project_sh.model.Group;

import java.util.List;

public interface GroupService {

    Group saveGroup(GroupDto groupDto,Long groupId);

    void removeGroupById(Long id) ;

    Group getById(Long id);

    List<Group> getAllGroup();

    GroupDto update(GroupDto group,Long id);
}
