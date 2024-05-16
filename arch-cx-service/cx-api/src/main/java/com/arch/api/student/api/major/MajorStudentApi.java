package com.arch.api.student.api.major;

import com.arch.api.student.dto.MajorStudentInfo;

/**
 * @author chenkun
 * @description 高中生api
 */
public interface MajorStudentApi {
    /**
     * 查询高中生信息
     *
     * @param studentId 学生id
     * @return 高中生信息
     */
    MajorStudentInfo queryMajorStudentInfo(String studentId);
}
