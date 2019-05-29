package microservice.model;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
public class Record {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;
    private String title;
    private String description;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date date;
    private String url;
    private BigDecimal price;
    private Boolean deleted;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getAvailable() {
        return deleted;
    }

    public void setAvailable(Boolean available) {
        deleted = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return Objects.equals(id, record.id) &&
                Objects.equals(title, record.title) &&
                Objects.equals(description, record.description) &&
                Objects.equals(date, record.date) &&
                Objects.equals(url, record.url) &&
                Objects.equals(price, record.price) &&
                Objects.equals(deleted, record.deleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, date, url, price, deleted);
    }

    @Override
    public String toString() {
        return "Record{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", url='" + url + '\'' +
                ", price=" + price +
                ", deleted=" + deleted +
                '}';
    }
}
