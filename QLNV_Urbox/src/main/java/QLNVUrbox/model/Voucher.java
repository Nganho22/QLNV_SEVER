package QLNVUrbox.model;

public class Voucher {
    private String agentSite;
    private String coupon;
    private String brandId;
    
    private String giftCode;
    private String status;
    private String message;

    public Voucher(String agentSite, String coupon, String brandId) {
        this.agentSite = agentSite;
        this.coupon = coupon;
        this.brandId = brandId;
    }
    public Voucher() {}

    public String getAgentSite() {
        return agentSite;
    }

    public void setAgentSite(String agentSite) {
        this.agentSite = agentSite;
    }

    public String getCoupon() {
        return coupon;
    }

    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }
    
    public String getGiftCode() {
        return giftCode;
    }

    public void setGiftCode(String giftCode) {
        this.giftCode = giftCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
