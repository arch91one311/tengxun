package com.arch.core.dao;

import com.arch.api.student.dto.MajorStudentInfo;
import com.arch.boot.base.annotation.ArchSqlDao;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

@ArchSqlDao
public interface MajorStudentDao extends BaseMapper<MajorStudentInfo> {

}
