package com.book1.book1.entity;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "users")
public class users {
    private List<user> userList;

    public List<user> getUserList() {
        return userList;
    }

    @XmlElement(name = "user")
    public void setUserList(List<user> userList) {
        this.userList = userList;
    }
}
