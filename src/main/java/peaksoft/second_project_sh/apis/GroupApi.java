package peaksoft.second_project_sh.apis;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.second_project_sh.dto.GroupDto;
import peaksoft.second_project_sh.model.Group;
import peaksoft.second_project_sh.services.GroupService;

import java.util.List;

@RestController
@RequestMapping("/api/groups")
@AllArgsConstructor
public class GroupApi {

    private GroupService groupService;

    @Operation(method = "postMethod", description = "create group")
    @PostMapping("/save/{courseId}")
    public Group createGroup(@RequestBody GroupDto group, @PathVariable("courseId") Long courseId) {
        return groupService.saveGroup(group, courseId);
    }

    @Operation(method = "patchMethod", description = "update group with id")
    @PatchMapping("/update/{id}")
    public GroupDto update(@RequestBody GroupDto group, @PathVariable Long id) {
        return groupService.update(group, id);
    }

    @Operation(method = "getMethod", description = "gel all groups")
    @GetMapping("/get")
    public List<Group> getAllGroup() {
        return groupService.getAllGroup();
    }

    @Operation(method = "getMethod", description = "get from id")
    @DeleteMapping("/{id}")
    public void deleteGroupById(@PathVariable Long id) {
        groupService.removeGroupById(id);
    }

    @Operation(method = "getMethod", description = "get with id")
    @GetMapping("/{id}")
    public Group getById(@PathVariable("id") Long id) {
        return groupService.getById(id);
    }


}
