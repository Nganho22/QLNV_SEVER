package QLNVdbsAPI.controller;

import org.springframework.web.bind.annotation.RestController;

import QLNVdbsAPI.model.Database;
import QLNVdbsAPI.repository.DatabaseRepository;

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

@RestController
@RequestMapping("/apiDBS")
public class DatabaseController{
	@Autowired
    private DatabaseRepository repo;

    @GetMapping("/")
    public List<Database> getDatabases() {
		return repo.findAll();

	}
    @GetMapping("/{ServiceID}")
    public List<Database> getDatabase(@PathVariable("ServiceID") int ServiceID) {
        System.out.println("Received ServiceID: " + ServiceID); // Log the received ServiceID
        return repo.findByServiceID(ServiceID); // Note: Ensure that the return type matches the repository method
    }

}
