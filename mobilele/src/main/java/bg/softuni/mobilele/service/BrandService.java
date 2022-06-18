package bg.softuni.mobilele.service;

import bg.softuni.mobilele.model.dto.BrandDTO;
import bg.softuni.mobilele.model.entity.BrandEntity;
import bg.softuni.mobilele.model.mapper.BrandMapper;
import bg.softuni.mobilele.repository.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    private final BrandRepository brandRepository;
    private final BrandMapper brandMapper;

    public BrandService(BrandRepository brandRepository, BrandMapper brandMapper) {
        this.brandRepository = brandRepository;
        this.brandMapper = brandMapper;
    }

    public List<BrandDTO> getAllBrands() {

        List<BrandEntity> allBrands = brandRepository.findAll();

        return allBrands
                .stream()
                .map(brandMapper::brandToBrandDto)
                .toList();
    }
}
