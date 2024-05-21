package com.arch.api.student.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("major_student_info")
public class MajorStudentInfo implements Serializable {
    /**
     * 学生id
     */
    @TableField(value = "student_id")
    private String studentId;
    /**
     * 学生姓名
     */
    @TableField(value = "student_name")
    private String studentName;
    /**
     * 学生年龄
     */
    @TableField(value = "student_age")
    private String studentAge;
    /**
     * 学生性别
     */
    @TableField(value = "student_sex")
    private String studentSex;
    /**
     * 学生学校
     */
    @TableField(value = "student_school")
    private String studentSchool;
    /**
     * 学生年级
     */
    @TableField(value = "student_grade")
    private String studentGrade;
}
