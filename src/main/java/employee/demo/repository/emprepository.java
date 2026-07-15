package employee.demo.repository;

import employee.demo.entity.EmpEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface emprepository extends JpaRepository<EmpEntity,Integer> {
public List<EmpEntity> findByDepartmentAndId(String department,int id);

public List<EmpEntity> findByUserContaining(String user);
}
