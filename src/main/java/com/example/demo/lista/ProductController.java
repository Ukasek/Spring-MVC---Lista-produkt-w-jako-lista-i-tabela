package com.example.demo.lista;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProductController {
    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping("/")
    public String userList(@RequestParam String name, @RequestParam Double price) {

        Products products = new Products(name, price);
        productRepository.add(products);
        return "redirect:/list";
    }

    @ResponseBody
    @PostMapping("/list")
    public String list() {

        List<Products> productList = productRepository.getAll();
        String result = "";

        for (Products products1 : productList) {
            result += products1.getName() + " " + "cena: " + products1.getPrice() + "</br>";
        }
        return result;
    }
}