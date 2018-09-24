package com.chm.toodles.bootshowcase.web;

import com.chm.toodles.bootshowcase.dto.StudentDTO;
import com.chm.toodles.bootshowcase.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 学生信息controller
 *
 * @author chenhuimin66@gmail.com
 */
@Api(tags = {"学生信息接口"})
@RestController
public class StudentController {

  @Autowired
  private StudentService studentService;

  @ApiOperation(value = "添加学生信息")
  @ApiImplicitParam(name = "student", value = "StudentDTO对象", dataType = "StudentDTO")
  @PostMapping("/v1/student")
  public StudentDTO addStudent(@RequestBody StudentDTO student) {
    return null;
  }

}
