package ru.inno.course.utils;

import io.qameta.allure.Attachment;

public class AttachmentHelper {

    @Attachment(value = "{0}", type = "text/plain")
    public static String attachText(String name, String text){
        return text;
    }
}
