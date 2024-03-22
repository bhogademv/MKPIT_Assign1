package com.mkpit.assig1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.mkpit.assig1.DTO.AddressDTO;
import com.mkpit.assig1.service.AddressService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AddressControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private AddressService addressService;

    // Test for creating a new address
    @Test
    public void testCreateAddress() {
        // Create a sample AddressDTO
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setStreet("123 Main St");
        addressDTO.setCity("Springfield");
        addressDTO.setState("IL");
        addressDTO.setPostalCode("12345");
        
        // Mock the service method to return the created AddressDTO
        Mockito.when(addressService.createAddress(Mockito.any(AddressDTO.class))).thenReturn(addressDTO);

        // Make a POST request to create a new address
        ResponseEntity<AddressDTO> response = restTemplate.postForEntity("/api/addresses", addressDTO, AddressDTO.class);

        // Assert that the response status code is 201 Created
        assertEquals(HttpStatus.CREATED, response.getStatusCode());

        // Assert that the response body matches the created AddressDTO
        assertEquals(addressDTO, response.getBody());
    }

}