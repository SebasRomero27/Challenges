package co.ciclo3.reto.reto.web;

import co.ciclo3.reto.reto.model.Category;
import co.ciclo3.reto.reto.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/Category")
@CrossOrigin(origins = "*", methods={RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class CategoryController {
    
    @Autowired
    private CategoryService categoryService;
    
    @GetMapping("/all")
    public List<Category> getCategorys(){
        return categoryService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional <Category> getCategory(@PathVariable("id") int id){
       return categoryService.getCategory(id);
    }
    
   @PostMapping("/save")
   @ResponseStatus(HttpStatus.CREATED)
   public Category save(@RequestBody Category cate){
       return categoryService.save(cate);
   }
   
   @PutMapping("/update")
   @ResponseStatus(HttpStatus.CREATED)
   public Category update(@RequestBody Category cate){
       return categoryService.update(cate);
   }
   
   @DeleteMapping("/{id}")
   @ResponseStatus(HttpStatus.NO_CONTENT)
   public boolean deleteCategory (@PathVariable("id") int id){
       return categoryService.delete(id);
   }
}