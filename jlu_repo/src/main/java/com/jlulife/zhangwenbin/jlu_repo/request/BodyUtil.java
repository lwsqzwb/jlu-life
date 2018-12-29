package com.jlulife.zhangwenbin.jlu_repo.request;

import org.json.JSONException;
import org.json.JSONObject;

public class BodyUtil {

    public static String createLessonBody(String teachingTerm ,String personId){
        JSONObject rootObject = new JSONObject();
        try {
            rootObject.put("tag","teachClassStud@schedule");
            rootObject.put("branch","default");
            JSONObject subObject = new JSONObject();
            subObject.put("termId",teachingTerm);
            subObject.put("studId",personId);
            rootObject.put("params",subObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return rootObject.toString();
    }

    public static String createScoreBody(){
        JSONObject rootObject = new JSONObject();
        try {
            rootObject.put("tag","archiveScore@queryCourseScore");
            rootObject.put("branch","latest");
            JSONObject subObject = new JSONObject();
            rootObject.put("params",subObject);
            rootObject.put("rowLimit",15);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return rootObject.toString();
    }

}
