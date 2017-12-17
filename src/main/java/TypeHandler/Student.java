package TypeHandler;

/**
 * Created by buwenqi on 2017/12/16.
 */
public class Student
{
    private int id;
    private String name;
    private int age;
    private SexEnum sex;
    private String[] interests;

    @Override
    public String toString(){
        StringBuilder builder=new StringBuilder();
        builder.append("id:"+id);
        builder.append(",name:"+name);
        builder.append(",age:"+age);
        builder.append(",sex:"+sex.getSexName());
        builder.append(",interests:"+interests.toString());
        return builder.toString();
    }

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String[] getInterests() {
        return interests;
    }

    public void setInterests(String[] interests) {
        this.interests = interests;
    }
}
