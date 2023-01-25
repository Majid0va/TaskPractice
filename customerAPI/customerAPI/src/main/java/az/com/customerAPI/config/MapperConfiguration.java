package az.com.customerAPI.config;

import az.com.customerAPI.mapper.CustomerMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class MapperConfiguration {

    @Bean
    public CustomerMapper customerMapper() {
        return CustomerMapper.MAPPER;
    }

}
