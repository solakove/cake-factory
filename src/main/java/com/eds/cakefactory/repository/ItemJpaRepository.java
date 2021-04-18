package com.eds.cakefactory.repository;

import com.eds.cakefactory.model.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemJpaRepository extends JpaRepository<Items, Long> {
}
