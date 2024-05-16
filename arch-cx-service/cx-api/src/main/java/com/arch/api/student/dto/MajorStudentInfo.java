package com.arch.api.student.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MajorStudentInfo implements Serializable {
    /**
     * 学生id
     */
    private String studentId;
    /**
     * 学生姓名
     */
    private String studentName;
    /**
     * 学生年龄
     */
    private String studentAge;
    /**
     * 学生性别
     */
    private String studentSex;
    /**
     * 学生学校
     */
    private String studentSchool;
    /**
     * 学生年级
     */
    private String studentGrade;
}
