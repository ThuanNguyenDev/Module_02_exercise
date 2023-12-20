package service;

import entity.Category;
import java.util.ArrayList;
import java.util.List;

public class CategoryService {

    private static List<Category> categoryList;

    static{
        categoryList = new ArrayList<>();
        categoryList.add(new Category(1, "Men fashion"));
        categoryList.add(new Category(2, "Women fashion"));
        categoryList.add(new Category(3, "Shoes"));
        categoryList.add(new Category(4, "Baby"));

    }

    public List<Category> getAll() {
        return categoryList;
    }

    public boolean checkIdIsExisted(Integer categoryId) {
        for(Category ele : categoryList){
            if(ele.getId() == categoryId){
                return true;
            }
        }
        return false;
    }
}
