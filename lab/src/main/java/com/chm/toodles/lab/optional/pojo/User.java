package com.chm.toodles.lab.optional.pojo;

import lombok.ToString;

/**
 * 用户类
 *
 * @author chm141593@alibaba-inc.com
 * @date 2018-07-03 14:43
 */

@ToString(of = {"name"})
public class User {
    private String name;
    private String phone;
    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public User() {
    }

    public User(String name) {
        this.name = name;
    }
}
