package multiAssociation.pojo;

/**
 * Created by buwenqi on 2017/12/26.
 */
public interface MaleHealthFormMapper {
    int insertMaleHealthForm(MaleHealthForm maleHealthForm);
    MaleHealthForm getMaleHealthFormWithEmpId(long empId);
}
