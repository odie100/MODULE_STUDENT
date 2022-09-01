package com.akata.studentservice.openfeign;

import com.akata.studentservice.dto.ContactResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CLIENT-SERVICE")
public interface ApplyRestClient {
    @GetMapping(path = "/api/contact/getByUserAndType/{id}")
    ContactResponseDTO getContact(@PathVariable("id") Long id);
}