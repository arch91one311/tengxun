package com.arch.core.service.student.major;

import com.arch.api.student.api.major.MajorStudentApi;
import com.arch.api.student.dto.MajorStudentInfo;
import com.arch.core.dao.MajorStudentDao;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("majorStudentApi")
public class MajorStudentApiImpl implements MajorStudentApi {

    @Resource
    private MajorStudentDao majorStudentDao;

    @Override
    public MajorStudentInfo queryMajorStudentInfo(String studentId) {
        return majorStudentDao.selectOne(Wrappers.<MajorStudentInfo>lambdaQuery().eq(MajorStudentInfo::getStudentId, studentId));
    }
}
