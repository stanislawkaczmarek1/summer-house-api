package com.cottages.backend.web.controller;

import com.cottages.backend.application.dto.CottageImageOrderRequest;
import com.cottages.backend.application.service.CottageImageService;
import com.cottages.backend.domain.model.CottageImage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin
public class CottageImageController {

    private final CottageImageService imService;

    public CottageImageController(CottageImageService imService){this.imService = imService;}

    @PostMapping("/api/cottages/{id}/images")
    public CottageImage save(CottageImage im){
        return imService.save(im);
    }
    @PostMapping("/api/cottages/{id}/images/bulk ")
    public void addImagesBulk(@PathVariable Long id, @RequestBody List<String> imageUrls) {

        imService.addImagesBulk(id, imageUrls);
    }
    @DeleteMapping("/api/cottages/{id}/images/{imageId}")
    public void delete(Long id){
       imService.delete(id);
    }
    @PatchMapping("/api/cottages/{id}/images")
    public void updateImageOrder(
            @PathVariable Long id,
            @RequestBody List<CottageImageOrderRequest> images) {

        imService.updateImageOrder(id, images);
    }

}
