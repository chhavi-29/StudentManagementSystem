package com.RCOEM_B4.Nagpur.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RCOEM_B4.Nagpur.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	

}