package com.example.demo.services;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class PurchaseResponse {
    private final String orderTrackingNumber;
}
