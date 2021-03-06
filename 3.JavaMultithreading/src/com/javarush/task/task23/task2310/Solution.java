package com.javarush.task.task23.task2310;

/* 
Напряги извилины!
*/

/**
 * Что происходит в задаче:
 * 1) Сначала вызываем метод sout() у экземпляра (класса Solution) с полем "main".
 *
 * 2) Метод sout создает экземпляр наследника класса Solution с полем "sout" и тут же вызывает у этого экземпляра
 * метод printName(). В результате у нас есть два объекта, которые связаны друг с другом одновременно двумя способами:
 * "внешний-внутренний" и "родитель-наследник".
 *
 * 3) Метод printName() вызывает метод getName(). Теперь главный вопрос - у какого экземпляра вызывается метод
 * getName() - у экземлпяра с "main" или с "sout"?
 *
 * 4) Ответ вытекает из следующих фактов: приватный метод не передается в наследуемый класс, однако у экземпляра
 * внутреннего класса есть доступ к приватному методу внешнего объекта (т.е. объекта с "sout"). Публичный же метод
 * передается в наследуемый класс (и соответственно это уже свой "собственный" метод внутреннего объекта, который ко
 * внешнему объекту не имеет отношения).
 */
public class Solution {
    private String name;

    Solution(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void sout() {
        new Solution("The Darkside Hacker") {
            void printName() {
                System.out.println(getName());
            }
        }.printName();
    }

    public static void main(String[] args) {
        new Solution("Риша").sout();
    }
}
