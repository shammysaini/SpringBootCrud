package springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboot.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
List<Employee>findByName(String name); 

}
