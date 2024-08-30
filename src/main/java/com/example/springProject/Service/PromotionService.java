package com.example.springProject.Service;

import com.example.springProject.Model.Promotion;
import com.example.springProject.Repository.PromotionRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionService {

    @Autowired
    PromotionRepo promotionRepo;

    public List<Promotion> getPromotions(){
        return promotionRepo.findAll();
    }

    public Promotion addPromotion(Promotion promotion) {
        Promotion promotion1 = new Promotion();
        promotion1.setId(promotion.getId());
        promotion1.setName(promotion.getName());
        promotion1.setType(promotion.getType());
        promotion1.setDiscount(promotion.getDiscount());

        return promotionRepo.save(promotion1);
    }

    public Promotion getPromotionById(Long id) {
        return promotionRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Promotion not found"));
    }

    public Promotion updatePromotion(Long id, Promotion promotion){
        Promotion promotion1 = promotionRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Product not found"));
        promotion1.setId(promotion.getId());
        promotion1.setName(promotion.getName());
        promotion1.setName(promotion.getName());
        promotion1.setDiscount(promotion.getDiscount());

        return promotionRepo.save(promotion1);
    }

    public Promotion deletePromotion(Long id) {
        Promotion promotion =  promotionRepo.findById(id).orElseThrow(
                () -> new EntityNotFoundException("There is no promotion id : " + id)
        );
        promotionRepo.delete(promotion);
        return promotion;
    }
}
