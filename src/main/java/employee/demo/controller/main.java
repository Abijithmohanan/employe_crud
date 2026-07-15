package employee.demo.controller;

import employee.demo.entity.EmpEntity;
import employee.demo.repository.emprepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/login")
public class main {
    @Autowired
    emprepository emprepository;
@PostMapping("/register")
public ResponseEntity<?> register(@RequestBody EmpEntity empEntity){
    return new ResponseEntity<>(emprepository.save(empEntity),HttpStatus.OK);
}
@GetMapping("/emp/{id}")
    public ResponseEntity<?> findById(@PathVariable int id){
    EmpEntity entity=emprepository.findById(id).orElse(null);
    if(entity==null){
        return new ResponseEntity<>("NOT FOUND",HttpStatus.EXPECTATION_FAILED);
    }
    return new ResponseEntity<>(entity,HttpStatus.OK);

}
@DeleteMapping("/emp/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id){
    EmpEntity entity=emprepository.findById(id).orElse(null);
    if(entity==null){
        return new ResponseEntity<>("NOT FOUND",HttpStatus.EXPECTATION_FAILED);
    }
    emprepository.delete(entity);
    return new ResponseEntity<>("DELETED",HttpStatus.OK);
}
@PutMapping("/emp/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody EmpEntity empEntity){
    EmpEntity entity=emprepository.findById(id).orElse(null);
entity.setAge(empEntity.getAge());
entity.setPass(empEntity.getPass());
entity.setUser(empEntity.getUser());
entity.setSalary(empEntity.getSalary());
entity.setPhone_no(empEntity.getPhone_no());
entity.setDepartment(empEntity.getDepartment());
return new ResponseEntity<>(emprepository.save(entity),HttpStatus.OK);
}
@GetMapping("/emp/{dept}/{id}")
    public ResponseEntity<?>getEmp(@PathVariable String dept, @PathVariable int id ){
    List<EmpEntity>Result=emprepository.findByDepartmentAndId(dept, id);
    return new ResponseEntity<>(Result,HttpStatus.OK);

}
@GetMapping("/emp/contain")
    public ResponseEntity<?> getContain(@RequestParam String user){

      List<EmpEntity>Result=emprepository.findByUserContaining(user);
      return  new ResponseEntity<>(Result,HttpStatus.OK);
}



}

