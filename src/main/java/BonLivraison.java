public class BonLivraison {
    private int id;
    private String status;
    private java.sql.Date deliveryDate;

    public BonLivraison(int id, String status, java.sql.Date deliveryDate) {
        this.id = id;
        this.status = status;
        this.deliveryDate = deliveryDate;
    }

    public int getId() { return id; }
    public String getStatus() { return status; }
    public java.sql.Date getDeliveryDate() { return deliveryDate; }

    public void setId(int id) { this.id = id; }
    public void setStatus(String status) { this.status = status; }
    public void setDeliveryDate(java.sql.Date deliveryDate) { this.deliveryDate = deliveryDate; }

    @Override
    public String toString() {
        return "BonLivraison [id=" + id + ", status=" + status + ", deliveryDate=" + deliveryDate + "]";
    }
}
