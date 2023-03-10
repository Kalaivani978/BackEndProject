package com.example.FSJDSwiggy.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.FSJDSwiggy.Model.Restaurant;
import com.example.fspSwiggy.model.SwiggyDetails;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,Integer>{

}
