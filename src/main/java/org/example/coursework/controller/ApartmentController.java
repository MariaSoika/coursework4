package org.example.coursework.controller;

import lombok.RequiredArgsConstructor;
import org.example.coursework.dto.ApartmentCreateDto;
import org.example.coursework.dto.ApartmentDto;
import org.example.coursework.service.ApartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/apartments")
@RequiredArgsConstructor
public class ApartmentController {

    private final ApartmentService apartmentService;

    @PostMapping
    public ResponseEntity<ApartmentDto> createApartment(@RequestBody ApartmentCreateDto apartmentCreateDto) {
        ApartmentDto createdApartment = apartmentService.create(apartmentCreateDto);
        return new ResponseEntity<>(createdApartment, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApartment(@PathVariable Long id) {
        apartmentService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApartmentDto> updateApartment(
            @PathVariable Long id,
            @RequestBody ApartmentDto apartmentDto) {
        ApartmentDto updatedApartment = apartmentService.update(id, apartmentDto);
        return ResponseEntity.ok(updatedApartment);
    }

    @GetMapping
    public ResponseEntity<List<ApartmentDto>> getAllApartments() {
        List<ApartmentDto> apartments = apartmentService.getAll();
        return ResponseEntity.ok(apartments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApartmentDto> getApartmentById(@PathVariable Long id) {
        ApartmentDto apartment = apartmentService.getById(id);
        return ResponseEntity.ok(apartment);
    }
}