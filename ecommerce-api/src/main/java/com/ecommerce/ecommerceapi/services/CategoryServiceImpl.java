package com.ecommerce.ecommerceapi.services;

import com.ecommerce.ecommerceapi.domain.Category;
import com.ecommerce.ecommerceapi.exceptions.EtBadRequestException;
import com.ecommerce.ecommerceapi.exceptions.EtResourceNotFoundException;
import com.ecommerce.ecommerceapi.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> fetchAllCategories(Integer userId) {

        return categoryRepository.findAll(userId);
    }

    @Override
    public Category fetchCategoryById(Integer userId, Integer categoryId) throws EtResourceNotFoundException {
        return categoryRepository.findById(userId, categoryId);
    }

    @Override
    public Category addCategory(Integer userId, String title, String description) throws EtBadRequestException {
        int categoryId = categoryRepository.create(userId, title, description);

        return categoryRepository.findById(userId, categoryId);
    }

    @Override
    public void updateCategory(Integer userId, Integer categoryId, Category category) throws EtBadRequestException {

        categoryRepository.update(userId, categoryId, category);
    }

    @Override
    public void removeCategoryWithAllTransaction(Integer userId, Integer categoryId) throws EtResourceNotFoundException {

        this.fetchCategoryById(userId, categoryId);
        categoryRepository.removeById(userId, categoryId);
    }
}
