package com.codegym.productmanagementthymeleaf.controller;

import com.codegym.productmanagementthymeleaf.model.Product;
import com.codegym.productmanagementthymeleaf.service.IProductService;
import com.codegym.productmanagementthymeleaf.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final IProductService productService = new ProductService();
    @GetMapping("")
    public String showAll(Model model){
        List<Product> productList = productService.findAll();
        model.addAttribute("productList", productList);
        return "home";
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model){
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "delete";
    }
    @PostMapping("/delete")
    public String delete(Product product){
        productService.remove(product.getId());
        return "redirect:/products";
    }
    @GetMapping("/{id}/view")
    public String showDetail(@PathVariable int id, Model model){
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "view";
    }
    @GetMapping("/{id}/edit")
    public String updateForm(@PathVariable int id, Model model){
        model.addAttribute("product", productService.findById(id));
        return "update";
    }
    @PostMapping("/update")
    public String edit(Product product){
        productService.update(product.getId(), product);
        return "redirect:/products";
    }
    @GetMapping("/create")
    public String showFormAdd(Model model){
        model.addAttribute("product", new Product());
        return "create";
    }
    @PostMapping("/save")
    public String save(Product product){
        productService.save(product);
        return "redirect:/products";
    }


}
