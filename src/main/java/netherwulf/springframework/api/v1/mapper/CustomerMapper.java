package netherwulf.springframework.api.v1.mapper;


import netherwulf.springframework.api.v1.model.CustomerDTO;
import netherwulf.springframework.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerDTO customerToCustomerDTO(Customer customer);
}
