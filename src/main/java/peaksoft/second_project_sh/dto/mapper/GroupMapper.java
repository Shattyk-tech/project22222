package peaksoft.second_project_sh.dto.mapper;

import org.springframework.stereotype.Component;
import peaksoft.second_project_sh.dto.response.GroupDto;
import peaksoft.second_project_sh.model.Group;

@Component
public class GroupMapper {

    public Group create(GroupDto groupDto){
        if (groupDto == null){
            return  null;
        }
        Group group = new Group();
        group.setGroupName(groupDto.getGroupName());
        group.setDateOfStart(groupDto.getDateOfStart());
        group.setDateOfFinish(groupDto.getDateOfFinish());
        return group;
    }



}
