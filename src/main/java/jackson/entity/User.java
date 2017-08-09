/*
 * �ļ�����User.java
 * ��Ȩ��Copyright by www.bonc.com.cn
 * ������
 * �޸��ˣ�HCN
 * �޸�ʱ�䣺2017��7��31��
 */

package jackson.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;

//@JsonIgnoreProperties(value={"birthday","age"})
//@JsonPropertyOrder(value={"age","name","mail"})
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class User
{
    private String name;
    private Integer age;
    @JsonIgnore
    //@JsonFormat(pattern = "yyyy��MM��dd��")
    private Date birthday;
    //@JsonProperty("mail")
    private String email;
    
    private Boolean sex;

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                '}';
    }
}
