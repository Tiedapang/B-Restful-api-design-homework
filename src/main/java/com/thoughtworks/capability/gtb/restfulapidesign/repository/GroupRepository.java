package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.dto.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupRepository {
    private static Map<Integer, Group> groupMap = new HashMap<>();
    public void save(Group group) {
        groupMap.put(group.getId(),group);
    }

    public void updateGroupName(int id, String name) {
        Group group = groupMap.get(id);
        group.setName(name);
        groupMap.put(id,group);
    }

    public List<Group> getAllGroups() {
        return new ArrayList<Group>(groupMap.values());
    }
}
