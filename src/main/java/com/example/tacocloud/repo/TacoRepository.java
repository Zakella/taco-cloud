package com.example.tacocloud.repo;

import com.example.tacocloud.model.Taco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TacoRepository 
         extends CrudRepository<Taco, Long> {

}