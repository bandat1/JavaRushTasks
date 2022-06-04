package com.javarush.task.task19.task1903;

import java.util.HashMap;
import java.util.Map;

/* 
Адаптация нескольких интерфейсов
*/

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {

    }

    public static class IncomeDataAdapter implements Customer, Contact {
        private IncomeData data;

        public IncomeDataAdapter(IncomeData incomeData) {
            this.data = incomeData;
        }

        @Override
        public String getCompanyName() {
            return data.getCompany();
        }

        /*
        Метод getCountryName() должен вернуть страну из countries, по ключу getCountryCode() объекта data.
        */
        @Override
        public String getCountryName() {
            //StringBuilder country = new StringBuilder("");
            String country = "";
            String code = data.getCountryCode();
            for (String s : countries.keySet()) {
                if (s.equals(code)) {
                    //country.append(s);
                    country = countries.get(s);
                    break;
                }
            }
            return country;
        }

        @Override
        public String getName() {
            return String.format("%s, %s", data.getContactLastName(), data.getContactFirstName());
        }

        //+38(050)123-45-67
        @Override
        public String getPhoneNumber() {
            String code = "+" + String.valueOf(data.getCountryPhoneCode());
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(data.getPhoneNumber()));
            stringBuilder.reverse();
            while (stringBuilder.length() < 10) {
                stringBuilder.append("0");
            }
            stringBuilder.reverse();
            String number = stringBuilder.toString();
            return String.format("%s(%s)%s-%s-%s", code, number.substring(0, 3), number.substring(3, 6),
                    number.substring(6, 8), number.substring(8, 10));
        }

    }

    public interface IncomeData {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        int getCountryPhoneCode();      //For example: 38

        int getPhoneNumber();           //For example1: 501234567, For example2: 71112233
    }

    public interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example1: +38(050)123-45-67, For example2: +38(007)111-22-33
    }
}