package QLNVUrbox.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import QLNVUrbox.service.UrboxService;
import QLNVUrbox.model.Voucher;

@RestController
@RequestMapping("/vouchers")
public class VoucherController {

    private final UrboxService urboxService;

    public VoucherController(UrboxService urboxService) {
        this.urboxService = urboxService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Voucher>> getAllVouchers() {
        List<Voucher> vouchers = urboxService.getVoucherFromUrbox();
        return ResponseEntity.ok(vouchers);
    }
}
