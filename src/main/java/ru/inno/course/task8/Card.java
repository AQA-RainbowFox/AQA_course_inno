package ru.inno.course.task8;

public class Card {

    private String cardNumber;
    private String date;
    private String cvv;
    private String pinCode;

    public Card(String cardNumber, String date, String cvv, String pinCode) {
        this.cardNumber = cardNumber;
        this.date = date;
        this.cvv = cvv;
        this.pinCode = pinCode;
    }

    public void maskNumber() {
        String result = cardNumber.replaceAll(" ", "");
        String maskNumber = result.replaceAll("\\d{12}", "****\s****\s****\s");
        System.out.println(maskNumber);
    }

    public void pinCodeVerify(String code) {
        if (code == pinCode) {
            System.out.println(cardNumber);
        } else {
            System.out.println("Неверный пинкод");
        }
    }
}
