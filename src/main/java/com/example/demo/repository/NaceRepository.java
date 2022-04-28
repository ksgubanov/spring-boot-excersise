package com.example.demo.repository;

import com.example.demo.model.NaceRecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NaceRepository extends CrudRepository<NaceRecord, Long> {

    public NaceRecord findByOrderId(@Param("order") Long orderId);

}
