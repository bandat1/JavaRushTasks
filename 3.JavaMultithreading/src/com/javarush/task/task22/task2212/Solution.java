package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/

public class Solution {
    /**
     * 1) если номер начинается с '+', то он содержит 12 цифр
     * 2) если номер начинается с цифры или открывающей скобки, то он содержит 10 цифр
     * 3) может содержать 1 пару скобок '(' и ')'
     * 4) скобки (если они есть) внутри содержат четко 3 цифры
     * 5) номер может содержать только цифры, '+', '(' и ')'
     * 6) номер заканчивается на цифру
     */
    public static boolean checkTelNumber(String telNumber) {
/*        String s = telNumber.replaceAll("\\+|\\(|\\)", "");
        System.out.println(s);
        System.out.println(s.length());*/
        if (telNumber == null || telNumber == "") return false;
        if ((telNumber.matches("\\+*\\d*\\(?\\d{3}\\)?\\d+")) &&
            (
                (
                    telNumber.matches("\\+.*") &&
                    telNumber.replaceAll("\\(|\\)|\\+", "").length() == 12
                ) ||
                (
                    (
                        telNumber.matches("\\(.*") ||
                        telNumber.matches("\\d+.*")
                    ) &&
                        telNumber.replaceAll("\\(|\\)", "").length() == 10
                )
            ) &&
                (
                    (
                        telNumber.contains("(") &&
                        telNumber.contains(")")
                    ) ||
                    !(
                            telNumber.contains("(") &&
                            telNumber.contains(")")
                    )
                )
        ) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        //System.out.println("T".matches("%T"));

/*
        System.out.println(checkTelNumber("+380501234567"));
        System.out.println(checkTelNumber("+38(050)1234567"));
        System.out.println(checkTelNumber("(050)1234567"));
        System.out.println(checkTelNumber("0(501)234567"));
        System.out.println(checkTelNumber("+38)050(1234567"));
        System.out.println(checkTelNumber("+38(050)123-45-67"));
        System.out.println(checkTelNumber("050ххх4567"));
        System.out.println(checkTelNumber("050123456"));
        System.out.println(checkTelNumber("(0)501234567"));
*/


    }
}
