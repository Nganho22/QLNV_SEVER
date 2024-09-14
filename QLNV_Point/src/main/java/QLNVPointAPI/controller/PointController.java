package QLNVPointAPI.controller;

import QLNVPointAPI.model.Felicitation;
import QLNVPointAPI.model.*;
import QLNVPointAPI.repository.*;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.dao.EmptyResultDataAccessException;

@RestController
@RequestMapping("/apiPoint")
public class PointController {

    @Autowired
    private PointRepository repo;


    @GetMapping("/")
    public List<Felicitation> getAllFelicitation() {
        return repo.findAll();
    }
}
