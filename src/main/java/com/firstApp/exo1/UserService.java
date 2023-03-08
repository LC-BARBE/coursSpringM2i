package com.firstApp.exo1;

import org.apache.tomcat.util.json.ParseException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;

public class UserService {

    UserApi userApi = new UserApi();

    public Boolean verifyEmailByApi(String email) throws IOException, ParseException {
        Boolean checkEmail = (Boolean) new JSONObject(new JSONTokener(this.userApi.verifyEmail(email)))
                .getJSONObject("is_valid_format")
                .get("value");
        if (checkEmail) {
            return true;
        }
        return false;
    }
//
//    public String[] getFieldsByModel(String object) throws IOException {
//        String[] fields = new String[Object..class.getDeclaredFields().length];
//        for (int i = 0; i < fields.length; i++) {
//            fields[i] = User.class.getDeclaredFields()[i].getName();
//        }
//        return fields;
//    }
}
