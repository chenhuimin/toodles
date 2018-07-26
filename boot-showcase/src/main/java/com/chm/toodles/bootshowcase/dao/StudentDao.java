package com.chm.toodles.bootshowcase.dao;

import com.chm.toodles.bootshowcase.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 学生信息dao
 *
 * @author chenhuimin66@gmail.com
 */
public interface StudentDao extends JpaRepository<Student, Long> {

}
