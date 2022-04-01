package peaksoft.second_project_sh.apis;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.second_project_sh.dto.response.GroupDto;
import peaksoft.second_project_sh.model.Group;
import peaksoft.second_project_sh.services.CourseService;
import peaksoft.second_project_sh.services.GroupService;

import java.util.List;

@RestController
@RequestMapping("/api/groups")
@AllArgsConstructor
public class GroupApi {

    private GroupService groupService;

    @PostMapping("/save/{courseId}")
    public Group createGroup(@RequestBody GroupDto group, @PathVariable("courseId") Long courseId){
        return groupService.saveGroup(group,courseId);
    }

    @PutMapping("/update/{id}")
    public Group update(@RequestBody Group group,@PathVariable Long id){
        return  groupService.update(group,id);
    }
    @GetMapping("/get")
    public List<Group> getAllGroup(){
        return groupService.getAllGroup();
    }
    @DeleteMapping("/{id}")
    public void deleteGroupById(@PathVariable Long id){
        groupService.removeGroupById(id);
    }
    @GetMapping("/{id}")
    public Group getById(@PathVariable ("id")Long id){
        return  groupService.getById(id);
    }



}
