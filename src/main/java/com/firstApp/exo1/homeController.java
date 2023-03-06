package com.firstApp.exo1;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class homeController {

    @GetMapping (value="/home")
    public String  getIndex(HttpSession session) {
        Date date = new Date();
        long time = date.getTime();
        String t = Long.toString(time);
        Date timeStampTodate = new Date(time);
        session.setAttribute("t", t);
        session.setAttribute("datetimeStamp", timeStampTodate.toString());
        session.setAttribute("dateFormat", getDateFormat(timeStampTodate));

        return "home";
    }

    public String getDateFormat(Date date) {
        String pattern = "dd/MM/yyyy hh:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String dateFormat = simpleDateFormat.format(date);
        return dateFormat;
    }

}
