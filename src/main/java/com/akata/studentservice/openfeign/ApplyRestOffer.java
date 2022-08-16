package com.akata.studentservice.openfeign;

import com.akata.studentservice.dto.OfferResponseDTO;
import com.akata.studentservice.model.Offer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "OFFER-SERVICE")
public interface ApplyRestOffer {
    @GetMapping(path = "/api/offer/{id}")
    OfferResponseDTO getOffer(@PathVariable("id") Long id);
}
