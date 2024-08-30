package com.example.springProject.Controller;

import com.example.springProject.Model.Promotion;
import com.example.springProject.Service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PromotionController {

    @Autowired
    private PromotionService promotionService;

    @GetMapping("/promotions")
    public List<Promotion> getAllPromotion(){
       return promotionService.getPromotions();
    }

    @PostMapping("/promotion/add")
    public Promotion addPromotion(@RequestBody Promotion promotion) {
        return promotionService.addPromotion(promotion);
    }

    @GetMapping("/promotion/{id}")
    @ResponseBody
    public Promotion getById(@PathVariable("id") Long id) {
        return promotionService.getPromotionById(id);
    }

    @PutMapping("/promotion/{id}")
    public Promotion updatePromotion(@PathVariable("id") Long id, @RequestBody Promotion Promotion) {
        return promotionService.updatePromotion(id, Promotion);

    }
    @DeleteMapping("/promotion/{id}")
    public Promotion deletePromotion(@PathVariable("id") Long id){
        return promotionService.deletePromotion(id);
    }
}
