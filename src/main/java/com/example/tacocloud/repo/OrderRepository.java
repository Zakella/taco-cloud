package com.example.tacocloud.repo;

import com.example.tacocloud.model.TacoOrder;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface OrderRepository
        extends CrudRepository<TacoOrder, UUID> {

}
