package netherwulf.springframework.services;

import netherwulf.springframework.api.v1.mapper.VendorMapper;
import netherwulf.springframework.api.v1.model.VendorDTO;
import netherwulf.springframework.api.v1.model.VendorListDTO;
import netherwulf.springframework.controllers.v1.VendorController;
import netherwulf.springframework.domain.Vendor;
import netherwulf.springframework.repositories.VendorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VendorServiceImpl implements VendorService {

    private final VendorMapper vendorMapper;

    private final VendorRepository vendorRepository;

    public VendorServiceImpl(VendorMapper vendorMapper, VendorRepository vendorRepository) {
        this.vendorMapper = vendorMapper;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public VendorListDTO getAllVendors() {
        List<VendorDTO> vendorDtos =  vendorRepository
                                        .findAll()
                                        .stream()
                                        .map(vendor -> {
                                            VendorDTO vendorDTO = vendorMapper.vendorToVendorDto(vendor);
                                            vendorDTO.setVendorUrl(VendorController.BASE_URL + "/" + vendor.getId());
                                            return vendorDTO;
                                        })
                                        .collect(Collectors.toList());
        return new VendorListDTO(vendorDtos);
    }

    @Override
    public VendorDTO createNewVendor(VendorDTO vendorDTO) {
        return saveAndReturnDTO(vendorMapper.vendorDtoToVendor(vendorDTO));
    }

    @Override
    public VendorDTO getVendorById(Long id) {
        return vendorRepository
                .findById(id)
                .map(vendor -> {
                    VendorDTO vendorDTO = vendorMapper.vendorToVendorDto(vendor);
                    vendorDTO.setVendorUrl(VendorController.BASE_URL);
                    return vendorDTO;
                })
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public VendorDTO updateVendor(Long id, VendorDTO vendorDTO) {
        Vendor vendor = vendorMapper.vendorDtoToVendor(vendorDTO);
        vendor.setId(id);
        return saveAndReturnDTO(vendor);
    }

    @Override
    public VendorDTO patchVendor(Long id, VendorDTO vendorDTO) {
        return vendorRepository
                .findById(id)
                .map(vendor -> {
                    if(vendorDTO.getName() != null) {
                        vendor.setName(vendorDTO.getName());
                    }

                    return saveAndReturnDTO(vendor);
                })
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public void deleteVendorById(Long id) {
        vendorRepository.deleteById(id);
    }

    private VendorDTO saveAndReturnDTO(Vendor vendor) {
        Vendor savedVendor = vendorRepository.save(vendor);

        VendorDTO vendorDTO = vendorMapper.vendorToVendorDto(savedVendor);

        vendorDTO.setVendorUrl(VendorController.BASE_URL + "/" + savedVendor.getId());

        return vendorDTO;
    }
}
