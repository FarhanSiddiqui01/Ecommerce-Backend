package com.example.demo.service;

import com.example.demo.domain.Category;
import com.example.demo.domain.User;
import com.example.demo.dto.CategoryDTO;
import com.example.demo.exception.RecordNotFound;
import com.example.demo.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    ModelMapper modelMapper;

private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryDTO save(CategoryDTO categoryDTO) {
       Category category = categoryRepository.save(todo(categoryDTO));
    return todto(category);}

    public List<CategoryDTO> getAll() {

        List<Category> categorys = categoryRepository.findAll();
        List<CategoryDTO> categoryDTOs=categorys.stream().map(
                c->modelMapper.map(c,CategoryDTO.class)).collect(Collectors.toList());
        return categoryDTOs;
    }

    public void deleteCat(Long id)
    {     if (presetById(id)){
        categoryRepository.deleteById(id);}
        else {
        throw new RecordNotFound(String.format("No Category found on id => %d",id));
    }
    }

    public boolean presetById(Long id) {
       Optional<Category> category =  categoryRepository.findById(id);
       if(category.isPresent()){
           return true;
       }
    else {return false;}}

    public Optional<Category> getCategoryById(Long id) {
       return categoryRepository.findById(id);
    }

    public CategoryDTO update(CategoryDTO categoryDTO, Long id) {
                if (presetById(id)){
      Category category = categoryRepository.save(todo(categoryDTO));
      return todto(category);
    }else {throw new RecordNotFound(String.format("No Category found on id => %d",id));
                }
    }
    public Category todo(CategoryDTO playerDTO){
        return modelMapper.map(playerDTO,Category.class);
    }
    public CategoryDTO todto(Category category){
        return modelMapper.map(category,CategoryDTO.class);
    }
}
