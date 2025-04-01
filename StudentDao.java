package com.tka.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public abstract class StudentDao {
	
	 @Query("FROM Student")
	abstract
	    List<com.tka.entity.Student> getAllStudents();

	    @Query("FROM Student s WHERE s.course = :course")
	    void getStudentsByCourse(@Param("course") String course) {
		}

	    @Query("SELECT s FROM Student s WHERE s.age > :age")
		abstract
	    List<com.tka.dao.StudentDao> getStudentsOlderThan(@Param("age") int age);

	    @Transactional
	    @Modifying
	    @Query("UPDATE Student s SET s.name = :name, s.age = :age, s.course = :course WHERE s.id = :id")
		abstract
	    int updateStudent(@Param("id") Long id, @Param("name") String name, @Param("age") int age, @Param("course") String course);

	    @Transactional
	    @Modifying
	    @Query("DELETE FROM Student s WHERE s.id = :id")
		abstract
	    int deleteStudent(@Param("id") Long id);
	}


