package com.thoughtworks.capability.gtb.restfulapidesign.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Group {
    private Integer id;
    private String name;
    private String note;
    List<Student> students;
}
