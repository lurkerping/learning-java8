package com.xplmc.learning.learningjava8.methodhandle;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * meta data of girl friend class using method handles
 *
 * @author luke
 */
public class GirlFriendMeta2 {

    /**
     * girl friend's setter method list
     */
    public static final List<MethodHandle> SETTER;

    /**
     * girl friend's getter method list
     */
    public static final List<MethodHandle> GETTER;

    static {
        Field[] fields = GirlFriend.class.getDeclaredFields();
        MethodHandles.Lookup lk = MethodHandles.lookup();
        SETTER = Arrays.stream(fields)
                .map(f -> {
                    MethodHandle mh = null;
                    try {
                        String s = "set" +
                                f.getName().toUpperCase().substring(0, 1) +
                                f.getName().substring(1);
                        mh = lk.findVirtual(GirlFriend.class, s, MethodType.methodType(void.class, String.class));
                    } catch (Exception e) {
                        //do nothing
                    }
                    return mh;
                })
                .collect(Collectors.toList());
        GETTER = Arrays.stream(fields)
                .map(f -> {
                    MethodHandle mh = null;
                    try {
                        String s = "get" +
                                f.getName().toUpperCase().substring(0, 1) +
                                f.getName().substring(1);
                        mh = lk.findVirtual(GirlFriend.class, s, MethodType.methodType(String.class));
                    } catch (Exception e) {
                        //do nothing
                    }
                    return mh;
                })
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        SETTER.forEach(System.out::println);
        GETTER.forEach(System.out::println);
    }

}
