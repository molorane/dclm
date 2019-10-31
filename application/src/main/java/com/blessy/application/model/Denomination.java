package com.blessy.application.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "denomination")
@Data
public class Denomination {

	@Id
	@Column(name = "id", unique = true)
	private int id;
	
	@Column(name = "name", unique = true)
	private String name;

	@Column(name = "sname", unique = true)
	private String sname;
	
	@Column(name = "country", unique = true)
	private String country;
	
	@Column(name = "founder", unique = true)
	private String founder;

	@Temporal(TemporalType.DATE)
	@Column(name = "start_date", unique = true)
	private Date startDate;
	
	@Column(name = "hq", unique = true)
	private String hq;
	
	@Column(name = "gpsLat", unique = true)
	private double gpsLat;

	@Column(name = "gpsLong", unique = true)
	private double gpsLong;
	
	@Column(name = "logo", unique = true)
	private String logo;

	@Column(name = "mission", unique = true)
	private String mission;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "updated_by")
	private User user;

}
