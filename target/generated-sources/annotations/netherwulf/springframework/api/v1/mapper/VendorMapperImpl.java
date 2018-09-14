package netherwulf.springframework.api.v1.mapper;

import javax.annotation.Generated;
import netherwulf.springframework.api.v1.model.VendorDTO;
import netherwulf.springframework.domain.Vendor;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-09-15T01:28:41+0200",
    comments = "version: 1.2.0.CR2, compiler: javac, environment: Java 1.8.0_181 (Oracle Corporation)"
)
@Component
public class VendorMapperImpl implements VendorMapper {

    @Override
    public VendorDTO vendorToVendorDto(Vendor vendor) {
        if ( vendor == null ) {
            return null;
        }

        VendorDTO vendorDTO = new VendorDTO();

        vendorDTO.setName( vendor.getName() );

        return vendorDTO;
    }

    @Override
    public Vendor vendorDtoToVendor(VendorDTO vendorDTO) {
        if ( vendorDTO == null ) {
            return null;
        }

        Vendor vendor = new Vendor();

        vendor.setName( vendorDTO.getName() );

        return vendor;
    }
}
