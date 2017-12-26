package multiAssociation.pojo;

/**
 * Created by buwenqi on 2017/12/22.
 */
public class MaleEmployee extends Employee {
    private MaleHealthForm maleHealthForm=null;

    public MaleHealthForm getMaleHealthForm() {
        return maleHealthForm;
    }

    public void setMaleHealthForm(MaleHealthForm maleHealthForm) {
        this.maleHealthForm = maleHealthForm;
    }
}
