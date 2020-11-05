package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.service.GroupService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {
    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }
    @GetMapping("/groupCount")
    public List<Group> randomPair(@PathVariable int groupCount){
        return groupService.randomPair(groupCount);
    }
    @PutMapping("/{id}")
    public void updateGroupName(@PathVariable int id,@RequestBody String name){
        groupService.updateGroupName(id,name);
    }
}
