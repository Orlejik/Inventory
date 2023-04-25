package com.fuji.inventory.fujiInv.repositories;

import com.fuji.inventory.fujiInv.models.Logs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LogRepository extends JpaRepository<Logs, Long> {
    public List<Logs> findAllByItem_Id(Long id);
}
