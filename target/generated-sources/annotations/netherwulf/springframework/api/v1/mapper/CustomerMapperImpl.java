package netherwulf.springframework.api.v1.mapper;

import javax.annotation.Generated;
import netherwulf.springframework.api.v1.model.CustomerDTO;
import netherwulf.springframework.domain.Customer;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-09-12T15:40:07+0200",
    comments = "version: 1.2.0.CR2, compiler: javac, environment: Java 1.8.0_181 (Oracle Corporation)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerDTO customerToCustomerDTO(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setId( customer.getId() );
        customerDTO.setFirstName( customer.getFirstName() );
        customerDTO.setLastName( customer.getLastName() );

        return customerDTO;
    }
}
