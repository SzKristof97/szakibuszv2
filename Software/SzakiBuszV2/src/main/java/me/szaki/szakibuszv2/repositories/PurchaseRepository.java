package me.szaki.szakibuszv2.repositories;

import me.szaki.szakibuszv2.models.PurchaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends JpaRepository<PurchaseEntity, Integer> { }
