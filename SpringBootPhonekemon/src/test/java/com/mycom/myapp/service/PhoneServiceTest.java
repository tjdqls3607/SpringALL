package com.mycom.myapp.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PhoneServiceTest {

    private final PhoneService phoneService = new PhoneService();

    @Test
    public void testGetInventory() {
        // When
        String inventory = phoneService.getInventory();

        // Then
        assertNotNull(inventory);
        assertTrue(inventory.contains("iPhone 13"));
        assertTrue(inventory.contains("Samsung Galaxy S21"));
        assertTrue(inventory.contains("Google Pixel 6"));
    }
}