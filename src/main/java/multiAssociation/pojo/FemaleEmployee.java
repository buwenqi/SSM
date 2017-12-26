package multiAssociation.pojo;

/**
 * Created by buwenqi on 2017/12/22.
 */
public class FemaleEmployee extends Employee{
    private FemaleHealthForm femaleHealthForm=null;

    public FemaleHealthForm getFemaleHealthForm() {
        return femaleHealthForm;
    }

    public void setFemaleHealthForm(FemaleHealthForm femaleHealthForm) {
        this.femaleHealthForm = femaleHealthForm;
    }
}
