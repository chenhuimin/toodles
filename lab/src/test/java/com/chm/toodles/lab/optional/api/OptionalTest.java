package com.chm.toodles.lab.optional.api;

import com.chm.toodles.lab.optional.pojo.Address;
import com.chm.toodles.lab.optional.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;

/**
 * OptionalTest
 *
 * @author chm141593@alibaba-inc.com
 * @date 2018-07-03 14:50
 */

@Slf4j
public class OptionalTest {
    @Test
    public void orElse() {
        User user1 = null;
        User user2 = new User("user2");
        User user3 = new User("user3");
        User user = Optional.ofNullable(user1).orElse(user2);
        log.info("user={}", user.getName());
        user = Optional.ofNullable(user2).orElse(user3);
        log.info("user={}", user.getName());

    }

    @Test
    public void orElseGet(){
        User user1 = null;
        User user2 = new User("user2");
        User user3 = new User("user3");
        User user = Optional.ofNullable(user1).orElseGet(() -> user2);
        log.info("user={}", user.getName());
        user = Optional.ofNullable(user2).orElseGet(() -> user3);
        log.info("user={}", user.getName());
    }

    @Test
    public void orElseThrow() throws Exception {
        User user1 = null;
        User user2 = new User("user2");
        User user = Optional.ofNullable(user2).orElseThrow(() -> new Exception("用户不存在"));
        log.info("user={}", user.getName());
        user = Optional.ofNullable(user1).orElseThrow(() -> new Exception("用户不存在"));
        log.info("user={}", user.getName());

    }

    @ParameterizedTest(name = "@MethodSource: getCity(): Test# {index}: User.toString() -> {0}")
    @MethodSource(value = {"userProvider"})
    public void getCity(User user) {
        String city = Optional.ofNullable(user).map(u -> u.getAddress()).map(a -> a.getCity()).orElse(null);
        log.info("city={}", city);


    }

    static Iterator<User> userProvider() {
        List<User> users = new ArrayList<>();
        users.add(null);
        for (int i = 0; i < 5; i++) {
            User user = createUser();
            users.add(user);
        }
        return users.iterator();
    }

    private static User createUser() {
        User user = new User();
        user.setName(generateRandomName());
        user.setAddress(createAddress());
        return user;
    }

    private static Address createAddress() {
        Address address = new Address();
        address.setCity(generateRandomCity());
        return address;
    }

    private static Random rng = new Random(System.currentTimeMillis());

    private static final String[] NAME = {
            "Ag",
            "Bog",
            "Cain",
            "Doan",
            "Erg",
            "Fon",
            "Gor",
            "Heg",
            "In",
            "Jar",
            "Kol",
            "Lar",
            "Mog",
            "Nag",
            "Oon",
            "Ptal",
            "Quon",
            "Rag",
            "Sar",
            "Thag",
            "Uxl",
            "Verd",
            "Wrog",
            "Xlott",
            "Yogrl",
            "Zelx"
    };

    private static final String[] CITY = {
            "Shanghai",
            "Beijing",
            "Shenzhen",
            "Guangzhou"
    };

    /**
     * Warm up the random number generator. Call it a random
     * number of times. Inception? You bet.
     */
    private static void warmupRandomNumberGenerator() {
        // Run through a few before returning the number
        int randomNumberOfWarmups = rng.nextInt(10);
        for (int aa = 0; aa < randomNumberOfWarmups; aa++) {
            rng.nextInt();
        }
    }

    private static int generateRandomNumber(int bound) {
        warmupRandomNumberGenerator();
        return rng.nextInt(bound);
    }

    private static String generateRandomCity() {
        String city = CITY[generateRandomNumber(CITY.length)];
        return city;
    }

    private static String generateRandomName() {
        String name = NAME[generateRandomNumber(NAME.length)];
        return name;
    }

}
