package com.example.FSJDSwiggy.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.FSJDSwiggy.ExceptionHandling.ResourceNotFoundException;
import com.example.FSJDSwiggy.Model.Restaurant;
import com.example.FSJDSwiggy.Repository.RestaurantRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/Swiggy")
public class RestaurantController {
	/*  The controller class only predict which method going to execute based on the url or mapping.
	 * Each one having the different mapping. Here we have used the parent mapping as /Swiggy.
	 * Annotations:
	 * @CrossOrgin is used to indicate the origins mapping
	 * @RestController is a combination of both response body and controller.
	 * @Autowired is used
	 * @postMapping is used to create the data.
	 * @GetMapping is used to get the date
	 * @PutMapping is used to update the data.
	 * @DeleteMapping is used to delete the data.
	 */
	
	@Autowired
	private RestaurantRepository resRepo;
	
	@PostMapping("/SaveResDetails")
	public Restaurant createRestaurant(@RequestBody Restaurant res) {
		return resRepo.save(res);
	}
	
	@GetMapping("/DisplayAllRes")
	public List<Restaurant> getAllHotels(){
		return resRepo.findAll();
	}
	@GetMapping("/SearchRes/{id}")
	public ResponseEntity<Restaurant> getHotelById(@PathVariable int id) {
		Restaurant resSearch= resRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Restaurant not exist with id :" + id));
		return ResponseEntity.ok(resSearch);
	}
	
	@PutMapping("/UpdateRes/{id}")
	public ResponseEntity<Restaurant> updateHotel(@PathVariable int id, @RequestBody Restaurant hotel){
		Restaurant resUpd = resRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Restaurant not exist with id :" + id));
		
		resUpd.setFoodType(hotel.getFoodType());
		resUpd.setLocation(hotel.getLocation());
		resUpd.setResName(hotel.getResName());
		
		Restaurant updatedRes = resRepo.save(resUpd);
		return ResponseEntity.ok(updatedRes);
	}
	
	@DeleteMapping("/DeleteRes/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteHotels(@PathVariable int id){
		Restaurant delHotel=resRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Restaurant not exist with id :" + id));
		
		resRepo.delete(delHotel);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
