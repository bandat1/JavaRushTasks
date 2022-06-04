package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/

public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.equals(loadedObject));
            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        /**
         * -1. Конечно же, проверяем, пустой ли список. Пишем yes/no, как нас учили. Не забываем printWriter.flush();
         * 0. пишем в файл число элементов в массиве: printWriter.println(users.size()); Снова не забываем про printWriter.flush(); (Не знаю, можно ли реализовать без этого - напишите).
         * 1. Дата рождения нужна с точностью до миллисекунд. Пишется и читается в формате long.
         * записываем: --------> printWriter.println(user.getBirthDate().getTime());
         * читаем: ---------------> user.setBirthDate(new Date(Long.parseLong(d)));
         * 2.Со страной тоже не все просто. Поэтому:
         * записываем: --------> printWriter.println(user.getCountry().toString());
         * читаем: --------------->..(тут ваш код )...  user.setCountry(User.Country.valueOf(cntr));
         * 3. После всех записанных полей пользователя не забывайте про printWriter.flush();
         * 4. Самое главное, чтобы не потерять кучу времени: валидатор принимает решение без проверки полей user'а на пустые значения.
         * 5. Это не обязательно: Для тестирования я в классе User переопределил метод toString, чтобы выводить пользователей списка в консоль:
         * public String toString(){
         * return this.firstName + " " + this.lastName + " " + birthDate + " " + isMale + " " + country + " " + country.getDisplayName() + " " +  country.name;
         * }
         */
        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);
            if (users.size() > 0) {
                for (User user : this.users) {
                    StringBuilder stringBuilder = new StringBuilder("");
                    stringBuilder.append(user.getFirstName());
                    stringBuilder.append("/" + user.getLastName());
                    stringBuilder.append("/" + user.getBirthDate().getTime());
                    stringBuilder.append("/" + user.getCountry());
                    stringBuilder.append("/" + user.isMale());

                    printWriter.println(stringBuilder.toString());
                    printWriter.flush();

                }
            }
            printWriter.close();
        }

/*            if (users != null && !users.isEmpty()) {
                try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)) {
                    for (User u : users) {
                        objectOutputStream.writeObject(u);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }*/


        public void load (InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineArray = line.split("/");
                if (lineArray.length < 5) break;
                User user = new User();
                user.setFirstName(lineArray[0]);
                user.setLastName(lineArray[1]);
                user.setBirthDate(new Date(Long.parseLong(lineArray[2])));
                user.setMale(Boolean.parseBoolean(lineArray[4]));
/*                User.Country country = User.Country.valueOf(line[3]);
                user.setCountry(country);*/
                switch (lineArray[3]) {
                    case "UKRAINE":
                        user.setCountry(User.Country.UKRAINE);
                        break;
                    case "RUSSIA":
                        user.setCountry(User.Country.RUSSIA);
                        break;
                    default:
                        user.setCountry(User.Country.OTHER);
                        break;
                }

                this.users.add(user);
            }
            reader.close();
        }


        @Override
        public boolean equals (Object o){
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode () {
            return users != null ? users.hashCode() : 0;
        }
    }
}
