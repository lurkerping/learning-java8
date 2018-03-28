package com.xplmc.learning.learningjava8.methodhandle;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * meta data of girl friend class using reflection
 *
 * @author luke
 */
public class GirlFriendMeta1 {

    /**
     * girl friend's setter method list
     */
    public static final List<Method> SETTER;

    /**
     * girl friend's getter method list
     */
    public static final List<Method> GETTER;

    static {
        Method[] methods = GirlFriend.class.getMethods();
        SETTER = Arrays.stream(methods)
                .filter(m -> m.getName().startsWith("set"))
                .collect(Collectors.toList());
        GETTER = Arrays.stream(methods)
                .filter(m -> m.getName().startsWith("get"))
                .filter(m -> !"getClass".equals(m.getName()))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        SETTER.forEach(System.out::println);
        GETTER.forEach(System.out::println);
    }

}
