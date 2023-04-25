package com.fuji.inventory.fujiInv.controllers;

import com.fuji.inventory.fujiInv.models.ItemName;
import com.fuji.inventory.fujiInv.service.AssetNameService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@AllArgsConstructor
public class AssetController {
    private final AssetNameService assetNameService;


    @GetMapping("/assets-add")
    public String assets(@RequestParam(name = "assetType", required = false) String assetType, Model model) {
        model.addAttribute("assets", assetNameService.assetList(assetType));
        return "assets-add";
    }

    @PostMapping("/assets/create")
    public String createAsset(@RequestParam("file1") MultipartFile file1,
                              @RequestParam("file2") MultipartFile file2,
                              @RequestParam("file3") MultipartFile file3,
                              ItemName itemName) throws IOException {
        assetNameService.saveAsset(itemName, file1, file2, file3);
        return "redirect:/assets-add";
    }

    @PostMapping("/assets/delete/{id}")
    public String deleteAsset(@PathVariable Long id) {
        assetNameService.deleteAsset(id);
        return "redirect:/assets-add";
    }

}
