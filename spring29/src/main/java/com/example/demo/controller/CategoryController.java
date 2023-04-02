package com.example.demo.controller;

import com.example.demo.domain.Category;
import com.example.demo.dto.CategoryDTO;
import com.example.demo.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {
    private final CategoryService categoryService;


    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/save")
    public ResponseEntity<CategoryDTO> save(@Valid @RequestBody CategoryDTO categoryDTO){
        return ResponseEntity.ok(categoryService.save(categoryDTO));}

    @GetMapping("/get")
    public List<CategoryDTO> getAllCategory(){
        return categoryService.getAll();}

    @DeleteMapping("/delete/{id}")
    public void deleteCategory(@Valid @PathVariable Long id){
        categoryService.deleteCat(id);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(@Valid @PathVariable Long id,@Valid @RequestBody CategoryDTO categoryDTO){
           return ResponseEntity.ok(categoryService.update(categoryDTO,id));
        }

}


