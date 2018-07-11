package com.chm.toodles.lab.optional.api;

import com.chm.toodles.lab.optional.pojo.Address;
import com.chm.toodles.lab.optional.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Optional;

/**
 * OptionalTest
 *
 * @author chm141593@alibaba-inc.com
 * @date 2018-07-03 14:50
 */

@Slf4j
public class OptionalTest {
    @Test
    public void orElseAndorElseGet() throws Exception {
        User user = createUser();
        user = Optional.ofNullable(user).orElse(createUser());
        user = Optional.ofNullable(user).orElseGet(() -> createUser());
        user = Optional.ofNullable(user).orElseThrow(() -> new Exception("用户不存在"));

    }

    @Test
    public void getCity() {
        User user = createUser();
        Address address = createAddress();
        user.setAddress(address);
        String city = Optional.ofNullable(user).map(u -> u.getAddress()).map(a -> a.getCity()).orElseGet(() -> null);
        log.info("city={}", city);


    }

    private User createUser() {
        User user = new User();
        user.setName("zhangsan");
        return user;
    }

    private Address createAddress() {
        Address address = new Address();
        address.setCity("Shanghai");
        return address;
    }
}
