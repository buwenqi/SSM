package multiAssociation.pojo;

/**
 * Created by buwenqi on 2017/12/22.
 */
public interface TaskMapper {
    Task getTaskById(long id);
    int insertTask(Task task);
}
