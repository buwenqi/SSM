package multiAssociation.pojo;

/**
 * Created by buwenqi on 2017/12/26.
 */
public interface FemaleHealthFormMapper {
    int insertFemaleHealthForm(FemaleHealthForm femaleHealthForm);
    FemaleHealthForm getFemaleHealthFormWithEmpId(long empId);
}
