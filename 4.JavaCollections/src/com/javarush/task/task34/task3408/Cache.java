package com.javarush.task.task34.task3408;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * Класс Cache - универсальный параметризированный класс для кеширования объектов.
 * Он работает с классами (дженерик тип Т).
 * Задание:
 * 1. Выбери правильный тип для поля cache. Map<K, V> cache должен хранить ключи, на которые есть активные ссылки.
 * Если нет активных ссылок на ключи, то они вместе со значениями должны автоматически удаляться из cache.
 *
 * 2. Реализуй логику метода getByKey:
 * 2.1. Верни объект из cache для ключа key.
 * 2.2. Если объекта не существует в кэше, то добавьте в кэш новый экземпляр используя рефлексию, см. пункт а).
 *
 * 3. Реализуй логику метода put:
 * 3.1. Используя рефлексию получи ссылку на метод, описанный в пункте б).
 * 3.2. Используя рефлексию разреши к нему доступ.
 * 3.3. Используя рефлексию вызови метод getKey у объекта obj, таким образом ты получишь ключ key.
 * 3.4. Добавь в кэш пару <key, obj>.
 * 3.5. Верни true, если метод отработал корректно, false в противном случае. Исключения игнорируй.
 * @param <K> - параметр публичного конструктора класса,он же тип ответа getKey()
 * @param <V>
 */
public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<>();

    //В помощь статья: https://javarush.ru/groups/posts/513-reflection-api-refleksija-temnaja-storona-java
    //В помощь дока: https://javadevblog.com/polnoe-rukovodstvo-po-java-reflection-api-refleksiya-na-primerah.html
    public V getByKey(K key, Class<V> clazz) throws Exception {
        V obj = cache.get(key);
        if (obj == null) {
            V myClass = null;
            myClass = (V) clazz.getConstructor(key.getClass()).newInstance(key);
            cache.put(key, myClass);
        }
        return obj;
    }

    public boolean put(V obj) {
        try {
            //находим метод getKey в классе через рефлекцию
            Method method = obj.getClass().getDeclaredMethod("getKey");
            //открываем доступ к этому методу
            method.setAccessible(true);
            //вызываем getKey для объекта obj
            K key = (K) method.invoke(obj);
            cache.put(key, obj);
        } catch (NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            return false;
        }
        return true;
    }

    public int size() {
        return cache.size();
    }
}
