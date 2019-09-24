package se325.assignment01.concert.service.domain;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import se325.assignment01.concert.common.types.BookingStatus;

@Entity
@Table(name = "SEATS")
public class Seat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;

	@Column(name = "LABEL")
	private String label;

	@Column(name = "STATUS")
	@Enumerated(EnumType.STRING)
	private BookingStatus status;

	@Column(name = "DATE")
	private LocalDateTime date;

	@Digits(integer=5, fraction=2)
	@Column(name = "PRICE")
	private BigDecimal price;

	public Seat() {}

	public Seat(String label, boolean isBooked, LocalDateTime date, BigDecimal price) {
		if(isBooked){
			this.status = BookingStatus.Booked;
		} else {
			this.status = BookingStatus.Unbooked;
		}
		this.label = label;
		this.date = date;
		this.price = price;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public BookingStatus getStatus() {
		return status;
	}

	public void setStatus(BookingStatus status) {
		this.status = status;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}
