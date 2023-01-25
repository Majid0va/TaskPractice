package az.com.customerAPI.mapper;

import az.com.customerAPI.dto.CustomerDto;
import az.com.customerAPI.model.Customers;
import az.com.customerAPI.request.CustomerRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {
    CustomerMapper MAPPER = Mappers.getMapper(CustomerMapper.class);

    CustomerDto entityToDto(Customers customer);

    Customers requestToModel(CustomerRequest customerRequest);


}
