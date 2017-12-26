package multiAssociation.pojo;

/**
 * Created by buwenqi on 2017/12/26.
 */
public interface EmployeeTaskMapper {
    int insertEmployeeTask(EmployeeTask employeeTask);
    EmployeeTask getEmployeeTaskByEmpId(long empId);
}
