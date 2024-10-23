package com.vsr.spring_batch_job.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vsr.spring_batch_job.entity.Student;
@Repository
public interface SourceRepository extends JpaRepository<Student, Integer>{

}
