package com.fuji.inventory.fujiInv.service;

import com.fuji.inventory.fujiInv.models.Image;
import com.fuji.inventory.fujiInv.models.InvItem;
import com.fuji.inventory.fujiInv.models.Logs;
import com.fuji.inventory.fujiInv.repositories.ImageRepository;
import com.fuji.inventory.fujiInv.repositories.InvRepository;
import com.fuji.inventory.fujiInv.repositories.LogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Service
public class ItemService {
    public final InvRepository invRepository;
    public final ImageRepository imageRepository;

    public final LogRepository logRepository;

    public List<InvItem> itemList(String itemname) {
        if (itemname != null) return invRepository.findAllByItemname(itemname);
        return invRepository.findAll();
    }

    public List<Image> getImagesByItemName_Assettype(String itemtype) {
        return imageRepository.getImagesByItemName_AssetModel(itemtype);
    }

    public void saveItem(InvItem invItem, Principal principal, Logs logs) {
        invItem.setUser_added_item(principal.getName());
        String logText = principal.getName()+" added item " +invItem.getItem_brand()
                +" "+invItem.getItem_model() + " in " +invItem.getPlant() +
                " placed on " + invItem.getLocation();
        log.info("Item Item.Title {} {} added to DB", invItem.getItem_brand(), invItem.getItem_model());
        logs.setLogText(logText);
        invRepository.save(invItem);
        logRepository.save(logs);
    }

//    UPDATE RECORD IN DATABASE
    public InvItem updateItem(Long id) {
        Optional<InvItem> item = invRepository.getInvItemById(id);
        InvItem invItem = null;
        if (item.isPresent()) {
            invItem = item.get();
        } else {
            throw new RuntimeException("No such Item with id = " + id);
        }
        return invItem;
    }

    public void saveUpdatedItem(InvItem invItem, Principal principal, Logs logs) {
        log.info("Item with id {} updated", invItem.getId());
        String logText = principal.getName() + "updated " +invItem.getItem_brand()
                +" "+invItem.getItem_model() + " in " +invItem.getPlant() +
                " placed on " + invItem.getLocation();
        logs.setLogText(logText);
        invRepository.save(invItem);

        logRepository.save(logs);
    }

    public InvItem getItemById(Long id) {
        return invRepository.findById(id).orElse(null);
    }
}


