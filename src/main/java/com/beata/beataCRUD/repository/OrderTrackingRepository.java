package com.beata.beataCRUD.repository;

import com.beata.beataCRUD.entity.OrderTrackingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderTrackingRepository extends JpaRepository<OrderTrackingEntity, Long> {
    //all code for crud methods for databases
}
