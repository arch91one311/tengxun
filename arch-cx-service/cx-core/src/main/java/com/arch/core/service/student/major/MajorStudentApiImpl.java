package com.arch.core.service.student.major;

import com.arch.api.student.api.major.MajorStudentApi;
import com.arch.api.student.dto.MajorStudentInfo;
import org.springframework.stereotype.Service;

@Service("majorStudentApi")
public class MajorStudentApiImpl implements MajorStudentApi {
    @Override
    public MajorStudentInfo queryMajorStudentInfo(String studentId) {
        //mock
        return new MajorStudentInfo("10086","超人不会飞","18","男","清华大学","大一");
    }
}
