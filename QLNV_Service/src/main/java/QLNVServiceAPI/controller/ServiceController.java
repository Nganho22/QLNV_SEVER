package QLNVServiceAPI.controller;

import org.springframework.web.bind.annotation.RestController;

import QLNVServiceAPI.model.Service;
import QLNVServiceAPI.repository.ServiceRepository;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import java.util.Optional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.stream.Collectors;



@RestController
@RequestMapping("/apiService")
public class ServiceController{
	@Autowired
    private ServiceRepository repo;

    @GetMapping("/")
    public List<Service> getAllActivity() {
		return repo.findAll();
	}
    
}