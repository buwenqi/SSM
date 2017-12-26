package multiAssociation.pojo;

/**
 * Created by buwenqi on 2017/12/26.
 */
public interface WorkCardMapper {
    int insertWorkCard(WorkCard workCard);
    WorkCard getWorkCardByEmpId(long empId);
}
