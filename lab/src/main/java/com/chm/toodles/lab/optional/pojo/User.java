package com.chm.toodles.lab.optional.pojo;

/**
 * 用户类
 *
 * @author chm141593@alibaba-inc.com
 * @date 2018-07-03 14:43
 */

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
}
