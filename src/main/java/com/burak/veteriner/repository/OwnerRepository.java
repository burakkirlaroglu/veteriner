package com.burak.veteriner.repository;

import com.burak.veteriner.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OwnerRepository extends JpaRepository<Owner, Long> {

    Owner findByName(String name);

}
