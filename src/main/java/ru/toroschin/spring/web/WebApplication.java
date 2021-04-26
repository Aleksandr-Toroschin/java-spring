package ru.toroschin.spring.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebApplication {
    // Домашнее задание
    // 1. Добавьте на главную страницу форму с фильтрами. С возможностью указывать
    // минимальную и максимальную цену искомых товаров.
    // * 2. Добавить к фильтрам по цене, фильтр по названию, т.е. искать товары,
    // в названии которых есть указанная последовательность символов (sql оператор like)
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

}
