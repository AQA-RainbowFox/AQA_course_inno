package ru.inno.course;

import org.junit.jupiter.api.Test;

public class test {
    @Test
    public void test() throws IOException {
        Configuration.browserSize = "1920x1080";
        open("https://demoqa.com/profile");
        $(".element-group:last-child #item-2").scrollIntoView(true).shouldBe(visible).click();
    }

}
