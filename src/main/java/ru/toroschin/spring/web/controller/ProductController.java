package ru.toroschin.spring.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.toroschin.spring.web.model.Product;
import ru.toroschin.spring.web.service.ProductService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String showAllProducts(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "index";
    }

    @PostMapping("/products/find")
    public String showProduct(@RequestParam(required = false) Long id, Model model) {
        productService.findOneById(id).ifPresent(p -> model.addAttribute("product", p));
        return "product_info";
    }

    @GetMapping("/products/add")
    public String showAddProduct(Model model) {
        model.addAttribute("message", "");
        model.addAttribute("title", "");
        model.addAttribute("cost", "0");
        return "add_product";
    }

    @PostMapping("/products/add")
    public String addProduct(@RequestParam String title, @RequestParam int cost, @RequestParam Long id_category) {
        productService.saveWithCategory(title, cost, id_category);
        return "redirect:/";
    }

    @GetMapping("/products/delete/{id}")
    public String deleteProductById(@PathVariable Long id) {
        productService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/products/increment/{id}")
    public String incrementScore(@PathVariable(name = "id") Long id, Model model) {
        Optional<Product> product = productService.findOneById(id);
        if (product.isPresent()) {
            productService.incrementScore(product.get());
            model.addAttribute("product", product.get());
        }
        return "redirect:/";
    }

    @GetMapping("/products/decrement/{id}")
    public String decrementScore(@PathVariable(name = "id") Long id, Model model) {
        Optional<Product> product = productService.findOneById(id);
        if (product.isPresent()) {
            productService.decrementScore(product.get());
            model.addAttribute("product", product.get());
        }
        return "redirect:/";
    }



}
