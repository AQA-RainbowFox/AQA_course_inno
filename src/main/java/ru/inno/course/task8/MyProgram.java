package ru.inno.course.task8;

public class MyProgram {
    public static void main(String[] args) {
        Card myCard= new Card("1234 4321 3456 6543","09/30","123", "0101");

        myCard.maskNumber();

        myCard.pinCodeVerify("0102");
    }
}
