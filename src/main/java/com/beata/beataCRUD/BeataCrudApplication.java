package com.beata.beataCRUD;

import com.beata.beataCRUD.entity.OrderTrackingEntity;
import com.beata.beataCRUD.repository.OrderTrackingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BeataCrudApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BeataCrudApplication.class, args);
	}

	@Autowired
	private OrderTrackingRepository orderTrackingRepository;
	@Override
	public void run(String... args) throws Exception {
		OrderTrackingEntity orderTracking = new OrderTrackingEntity();
		orderTracking.setOrderNo(4321);
		orderTracking.setOrderStatus("paid");
		orderTracking.setOrderSummary("Shoes 2 pairs and T-shirt 1pair");
		orderTracking.setCustomerSupport("alibaba@gmail.com");
		orderTracking.setEmail("beata@gmail.com");
		orderTracking.setDeliveryDate("07/06/2023");
		orderTrackingRepository.save(orderTracking);

	}
}
