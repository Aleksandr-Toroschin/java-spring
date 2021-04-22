package ru.toroschin.spring.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebApplication {
	// Домашнее задание
	// 1. Добавьте сущность Category (id, title). К каждой категории относится
	// какое-то количество товаров (Товар может относиться только к одной категории)
	// 2. В таблице с товарами отпечатайте название категории
	// 3. * Попробуйте сделать фильтр продуктов по категории
	// .../app/?category=food
	// Должен показать товары категории food
	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}

}
