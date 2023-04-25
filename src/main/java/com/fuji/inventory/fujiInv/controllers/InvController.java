package com.fuji.inventory.fujiInv.controllers;
import com.fuji.inventory.fujiInv.models.*;
import com.fuji.inventory.fujiInv.repositories.LogRepository;
import com.fuji.inventory.fujiInv.service.AssetNameService;
import com.fuji.inventory.fujiInv.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class InvController {
    private final ItemService itemService;
    private final LogRepository logRepository;
    private final AssetNameService assetNameService;
    @GetMapping("/")
    public String items(@RequestParam(name = "itemName", required = false) String itemName, Model model){
        model.addAttribute("items", itemService.itemList(itemName));
        return "listOfItems";
    }
    @GetMapping("/item/{id}")
    public String itemInfo(@PathVariable Long id, Model model){
        InvItem item = itemService.getItemById(id);
        List<Logs> logs = itemService.getLogsByItem_Id(id);
        List<Image> images = itemService.getImagesByItemName_Assettype(item.getItem_model());
        model.addAttribute("item", item);
        model.addAttribute("images", images);
        model.addAttribute("logs", logs);
        return "item-info";
    }
    @GetMapping("/additem")
    public String additem(Model model, String assetType){
        List<ItemName> assets = assetNameService.assetList(assetType);
        model.addAttribute("itemNames", assets);
        return "additem";
    }
    @PostMapping("/item/create")
    public String createItem(InvItem invItem, Principal principal, Logs logs){
        logs.setLogText(
                principal.getName()+" added item " +invItem.getItem_brand()
                +" "+invItem.getItem_model() + " in " +invItem.getPlant() +
                " placed on " + invItem.getLocation()
        );

        itemService.saveItem(invItem, logs, principal);
        return "redirect:/additem";
    }

    @PostMapping("/item/{id}/update")
    public String updateItem(@PathVariable Long id, InvItem invItem, Principal principal, Logs logs){
        InvItem item = itemService.updateItem(id);
        item.setPlant(invItem.getPlant());
        item.setLocation(invItem.getLocation());
        item.setDamaged(invItem.isDamaged());
        item.setHostname(invItem.getHostname());
        item.setIp_address(invItem.getIp_address());
        item.setUser_name(invItem.getUser_name());
        item.setDepartment(invItem.getDepartment());
        item.setOperator_number(invItem.getOperator_number());
        log.info("item with id {} saved in DB", item.getId());
        itemService.saveUpdatedItem(item, logs, principal);
        return "redirect:/item/{id}";
    }
}
