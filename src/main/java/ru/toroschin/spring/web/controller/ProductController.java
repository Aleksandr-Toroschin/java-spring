package ru.toroschin.spring.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.toroschin.spring.web.model.Product;
import ru.toroschin.spring.web.service.ProductService;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public String showAllProducts(Model model) {
        List<Product> products = productService.getProducts();
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping("/add")
    public String showAddProduct(Model model) {
        model.addAttribute("id", "");
        model.addAttribute("message", "");
        model.addAttribute("title", "");
        model.addAttribute("cost", "0");
        return "add_product";
    }

    @PostMapping("/add")
    public String addProduct(@RequestParam Long id, @RequestParam String title, @RequestParam Double cost, Model model) {
        boolean isExists = productService.isExists(id);
        if (isExists||cost==0||title.equals("")) {
            String message = "";
            Long saveID = id;
            if (cost==0) {
                message = "Цена не может быть равна нулю!";
            }
            if (title.equals("")) {
                message = "Не заполнено наименование!";
            }
            if (isExists) {
                message = "Товар с таким ID уже существует!";
                saveID = null;
            }

            model.addAttribute("message", message);
            model.addAttribute("id", saveID);
            model.addAttribute("title", title);
            model.addAttribute("cost", cost);
            return "add_product";
        }

        Product product = new Product(id, title, cost);
        productService.addProduct(product);
        return "redirect:/products/all";
    }

}
