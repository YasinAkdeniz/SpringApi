package com.example.springProject.Repository;

import com.example.springProject.Model.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionRepo extends JpaRepository<Promotion, Long> {
}
