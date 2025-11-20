package in.ashokit.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Product {

	@Id
	private Integer productId;

	private String productName;

	private Double productPrice;

	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime dateCreated;

	@UpdateTimestamp
	@Column(insertable = false)
	private LocalDateTime lastUpdated;

}
