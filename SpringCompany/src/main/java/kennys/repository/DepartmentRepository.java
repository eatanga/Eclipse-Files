package kennys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kennys.beans.Department;


@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
