package com.example.demo.base.core.constants;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author wen
 * @Date 2018/11/19 17:57
 * @Description
 **/
public class TestConstant {
    public static Map<Integer, String> grkMap = new LinkedHashMap<>();

    static {
        grkMap.put(1, "Read");
        grkMap.put(2, "Likes");
        grkMap.put(3, "Collect");
        grkMap.put(4, "Replay");
        grkMap.put(5, "SubmitExam");
        grkMap.put(6, "PassExam");
        grkMap.put(7, "PublishContent");
        grkMap.put(8, "PassContent");
    }
}
