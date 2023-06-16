// package com.example.demo.controllers;

// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PostMapping;

// import com.example.demo.entity.Category;
// import com.example.demo.services.CategoryService;

// import lombok.RequiredArgsConstructor;

// @RequiredArgsConstructor

// @Controller

// public class AdminController {
//     @GetMapping("/admin")
//     public String adminHome(){
//         return "adminhome";
//     }

//     @GetMapping("/admin/categories")
//     public String getCat(Model model){
//         model.addAttribute("categories", CategoryService.getAllCategory()); 
//         return "categories";
//     }

//     @GetMapping("/admin/categories/add")
//     public String getCatAdd(Model model){
//         model.addAttribute("category", new Category());
//         return "CategoriesAdded";
//     }

//      @PostMapping("/admin/categories/add")
//     public String postCatAdd(@ModelAttribute("category"),Category category){
//         CategoryService.addCategory(category);
//         return "Category is Added";
//     }

// }
