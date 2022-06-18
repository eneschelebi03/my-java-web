package bg.softuni.mobilele.service;

import bg.softuni.mobilele.model.dto.AddOfferDTO;
import bg.softuni.mobilele.model.entity.ModelEntity;
import bg.softuni.mobilele.model.entity.OfferEntity;
import bg.softuni.mobilele.model.entity.UserEntity;
import bg.softuni.mobilele.model.mapper.OfferMapper;
import bg.softuni.mobilele.repository.ModelRepository;
import bg.softuni.mobilele.repository.OfferRepository;
import bg.softuni.mobilele.repository.UserRepository;
import bg.softuni.mobilele.user.CurrentUser;
import org.springframework.stereotype.Service;

@Service
public class OfferService {

    private final OfferMapper offerMapper;
    private final CurrentUser currentUser;
    private final UserRepository userRepository;
    private final ModelRepository modelRepository;
    private final OfferRepository offerRepository;

    public OfferService(OfferMapper offerMapper, CurrentUser currentUser, UserRepository userRepository, ModelRepository modelRepository, OfferRepository offerRepository) {
        this.offerMapper = offerMapper;
        this.currentUser = currentUser;
        this.userRepository = userRepository;
        this.modelRepository = modelRepository;
        this.offerRepository = offerRepository;
    }

    public void addOffer(AddOfferDTO addOfferDTO) {

        OfferEntity newOffer = offerMapper.addOfferDtoToOfferEntity(addOfferDTO);

        UserEntity currentUser = userRepository
                .findByEmail(this.currentUser.getEmail())
                .orElseThrow();

        ModelEntity model = modelRepository
                .findById(addOfferDTO.getModelId())
                .orElseThrow();

        newOffer.setSeller(currentUser).setModel(model);

        offerRepository.save(newOffer);
    }
}
