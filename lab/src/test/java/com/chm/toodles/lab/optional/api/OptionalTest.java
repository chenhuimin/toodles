package com.chm.toodles.lab.optional.api;

import com.chm.toodles.lab.optional.pojo.User;
import org.junit.Test;

import java.util.Optional;

/**
 * OptionalTest
 *
 * @author chm141593@alibaba-inc.com
 * @date 2018-07-03 14:50
 */

public class OptionalTest {
    @Test
    public void orElseAndorElseGet() {
        User user = null;
        user = Optional.ofNullable(user).orElse(createUser());
        user = Optional.ofNullable(user).orElseGet(() -> createUser());

    }

    private User createUser() {
        User user = new User();
        user.setName("zhangsan");
        return user;
    }
}
