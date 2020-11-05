package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.dto.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.exception.GroupNotFoundException;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.GroupRepository;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class GroupService {
    private GroupRepository groupRepository = new GroupRepository();
    private StudentRepository studentRepository = new StudentRepository();

    public List<Group> randomPair(int groupCount) {
        List<Student> students = studentRepository.findAll();
        Collections.shuffle(students);
        groupCount = Math.min(groupCount,students.size());
        int round = students.size()/groupCount;
        for(int i=0;i<groupCount;i++){
            List<Student> students1 = new ArrayList<Student>();
            for(int j=0;j<= round;j++){
                students1.add(students.get(j*groupCount+i));
            }
            Group group = Group.builder()
                    .id(i)
                    .name(i+"组")
                    .students(students1)
                    .note("")
                    .build();
            groupRepository.save(group);
        }

        return groupRepository.getAllGroups();
    }

    public void updateGroupName(int id, String name) {
        if(groupRepository.getGroupById(id) == null ){
            throw new GroupNotFoundException("未找到对应分组");
        }
        groupRepository.updateGroupName(id,name);
    }

    public List<Group> checkGroup() {
        return groupRepository.getAllGroups();
    }
}
