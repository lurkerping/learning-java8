package com.xplmc.learning.learningjava8.jvm;

import com.xplmc.learning.learningjava8.methodhandle.GirlFriend;

/**
 * escaping analysis, start from java6u20
 * 1/detecting an object that is only used in the method
 * 2/avoiding heap memory allocating
 *
 * @author luke
 */
public class EscapeAnalysisSimpleExample {

    public static void main(String[] args) {
        long count = Integer.MAX_VALUE * 100L;
        EscapeAnalysisSimpleExample e = new EscapeAnalysisSimpleExample();
        for (long i = 0; i < count; i++) {
            e.newObject();
        }
    }

    /**
     * GirlFriend match the escaping condition
     */
    private void newObject() {
        GirlFriend girlFriend = new GirlFriend();
        girlFriend.setBody("nice");
        girlFriend.setFace("pretty");
        girlFriend.setName("Lyanna");
        girlFriend.setSex("female");
        girlFriend.setNature("good");
    }

}
