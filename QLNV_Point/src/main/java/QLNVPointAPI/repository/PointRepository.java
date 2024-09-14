package QLNVPointAPI.repository;
import QLNVPointAPI.model.Felicitation;
import QLNVPointAPI.model.Voucher;
import jakarta.transaction.Transactional;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;
import java.util.Map;


public interface PointRepository extends JpaRepository <Felicitation, Integer>{
}

