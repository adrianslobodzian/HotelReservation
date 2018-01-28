package com.github.adrianslobodzian.entities;

import java.sql.Timestamp;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.NotBlank;



@Entity
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(nullable = false)
	private LocalDate starts;
	
	@NotNull
	@Column(nullable = false)
	private LocalDate ends;
	
	@ManyToOne
	@JoinColumn
	private Room room;

	@CreationTimestamp
	private Timestamp created;
	
	@ManyToOne
	@JoinColumn
	private User user;
	
	

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", starts=" + starts + ", ends=" + ends + ", room=" + room + ", created="
				+ created + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
	

	public LocalDate getStarts() {
		return starts;
	}

	public void setStarts(LocalDate starts) {
		this.starts = starts;
	}

	public LocalDate getEnds() {
		return ends;
	}

	public void setEnds(LocalDate ends) {
		this.ends = ends;
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
