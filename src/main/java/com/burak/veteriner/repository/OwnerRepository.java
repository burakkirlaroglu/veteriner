package com.burak.veteriner.repository;

import com.burak.veteriner.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OwnerRepository extends JpaRepository<Owner, Long> {

    List<Owner> findByName(String name);

}
