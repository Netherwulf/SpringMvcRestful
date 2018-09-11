package netherwulf.springfamework.api.v1.mapper;


import netherwulf.springfamework.api.v1.model.CustomerDTO;
import netherwulf.springfamework.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerDTO customerToCustomerDTO(Customer customer);
}
