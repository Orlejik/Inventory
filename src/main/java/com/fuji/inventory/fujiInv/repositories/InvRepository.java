package com.fuji.inventory.fujiInv.repositories;

import com.fuji.inventory.fujiInv.models.InvItem;
import com.fuji.inventory.fujiInv.models.Logs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InvRepository extends JpaRepository<InvItem, Long> {
    List<InvItem> findAllByItemname(String itemname);
    Optional<InvItem> getInvItemById(Long id);

}
