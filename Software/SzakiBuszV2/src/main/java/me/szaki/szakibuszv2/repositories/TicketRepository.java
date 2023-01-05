package me.szaki.szakibuszv2.repositories;

import me.szaki.szakibuszv2.models.TicketEntity;
import me.szaki.szakibuszv2.models.enums.TicketType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TicketRepository extends JpaRepository<TicketEntity, Integer> {
    Optional<TicketEntity> findByType(TicketType type);
}
