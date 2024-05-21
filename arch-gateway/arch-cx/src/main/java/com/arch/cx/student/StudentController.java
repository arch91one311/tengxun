package com.arch.cx.student;

import com.arch.api.student.api.major.MajorStudentApi;
import com.arch.api.student.dto.MajorStudentInfo;
import com.arch.cx.common.util.AjaxJson;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/arch/student")
public class StudentController {
    @Resource
    public MajorStudentApi majorStudentApi;

    @PostMapping("/queryMajorStudentInfo")
    public AjaxJson<MajorStudentInfo> queryMajorStudentInfo(@RequestParam(value = "id") String id) {
        return AjaxJson.okGeneric(majorStudentApi.queryMajorStudentInfo(id));
    }
}
