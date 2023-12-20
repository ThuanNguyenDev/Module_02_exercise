package Service;
import Entities.Category;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CategoryService  implements Serializable {
    static Scanner scanner = new Scanner(System.in);
    static List<Category> categoryList = new ArrayList<>();
    public static void addCategory() {
        displayCategories();

        boolean categoryAdded = false;

        do {
            try {
                System.out.print("Enter Category ID: ");
                int categoryID = Integer.parseInt(scanner.nextLine());

                boolean categoryExists = false;
                for (Category category : categoryList) {
                    if (category.getCategoryID() == categoryID) {
                        categoryExists = true;
                        break;
                    }
                }

                if (categoryExists) {
                    System.out.println("Category ID already exists. Please choose a different ID.");
                } else {
                    System.out.print("Enter Category name: ");
                    String categoryName = scanner.nextLine();

                    Category newCategory = new Category(categoryID, categoryName);
                    categoryList.add(newCategory);
                    writeCategoryToFile();
                    System.out.println("Category successfully added.");

                    categoryAdded = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid Category ID. Please enter a valid numeric ID.");
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        } while (!categoryAdded);
    }

    public static void writeCategoryToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Category.csv"))) {
            for (Category category : categoryList) {
                String line = category.getCategoryID() + "," + category.getCategoryName();
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("An error occurred while writing category data: " + e.getMessage());
        }
    }

    public static void updateCategory() {
        displayCategories();

        System.out.print("Enter Category ID: ");
        int categoryID = Integer.parseInt(scanner.nextLine());

        Category selectedCategory = null;

        for (Category category : categoryList) {
            if (category.getCategoryID() == categoryID) {
                selectedCategory = category;
                break;
            }
        }

        if (selectedCategory != null) {
            System.out.print("Enter new Category name: ");
            String newCategoryName = scanner.nextLine();
            selectedCategory.setCategoryName(newCategoryName);
            writeCategoryToFile();
            System.out.println("Category information has been updated successfully.");
        } else {
            System.out.println("Category not found.");
        }
    }

    public static void deleteCategory() {
        displayCategories();

        System.out.print("Enter Category ID: ");
        int categoryID = Integer.parseInt(scanner.nextLine());

        Category selectedCategory = null;

        for (Category category : categoryList) {
            if (category.getCategoryID() == categoryID) {
                selectedCategory = category;
                break;
            }
        }

        if (selectedCategory != null) {
            categoryList.remove(selectedCategory);
            writeCategoryToFile();
            System.out.println("Category has been deleted successfully.");
        } else {
            System.out.println("Category not found.");
        }
    }

    public static void displayCategories() {
        System.out.println("Category List:");
        if (categoryList.isEmpty()) {
            System.out.println("No Category available.");
        } else {
            for (Category category : categoryList) {
                System.out.println(category.getCategoryID() + ", " + category.getCategoryName());
            }
        }
    }

    public static void readCategoryFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("Category.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int categoryID = Integer.parseInt(data[0]);
                String categoryName = data[1];
                Category category = new Category(categoryID, categoryName);
                categoryList.add(category);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading category data: " + e.getMessage());
        }
    }

}
