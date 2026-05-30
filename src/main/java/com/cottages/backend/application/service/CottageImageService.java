package com.cottages.backend.application.service;

import com.cottages.backend.application.dto.CottageImageOrderRequest;
import com.cottages.backend.domain.model.CottageImage;
import com.cottages.backend.domain.repository.CottageImageRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CottageImageService {
    private final CottageImageRepository imRepo;

    public CottageImageService(CottageImageRepository imRepo){this.imRepo = imRepo;}

    public CottageImage save(CottageImage im){
        return imRepo.save(im);
    }
    public void addImagesBulk(Long cottageId, List<String> imageUrls) {
        List<CottageImage> images = new ArrayList<>();
        int order = 1;
        for (String url : imageUrls) {
            images.add(new CottageImage(null, cottageId, url, order++));
        }
        imRepo.saveAll(images);
    }
    public void delete(Long id){
        imRepo.deleteById(id);
    }
    public void updateImageOrder(Long cottageId,
                                 List<CottageImageOrderRequest> images) {

        List<CottageImage> existingImages = imRepo.findByCottageId(cottageId);

        Map<Long, CottageImage> imageMap = existingImages.stream().collect(Collectors.toMap(CottageImage::getId, img -> img));

        for (CottageImageOrderRequest req : images) {

            CottageImage image = imageMap.get(req.id());

            if (image != null) {
                image.setSortOrder(req.sortOrder());
            }
        }
        imRepo.saveAll(existingImages);
    }
}
