package multiAssociation.pojo;

/**
 * Created by buwenqi on 2017/12/17.
 */
public enum SexEnum {
    FEMALE("女"),MALE("男");
    private String sexName;
    SexEnum(String sexName){
        this.sexName=sexName;
    }

    public String getSexName() {
        return sexName;
    }

    public void setSexName(String sexName) {
        this.sexName = sexName;
    }
}
