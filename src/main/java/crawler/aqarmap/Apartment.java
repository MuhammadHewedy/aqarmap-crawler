package crawler.aqarmap;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Apartment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String city;
	private String district;
	private String adNumber;
	private LocalDate adDate;
	private String adMobile;
	private String adType;
	private Long price;
	private String type;
	private String area;
	private String payMethod;
	private Long numOfRooms;
	private Long floorNumber;
	private Long wcNumber;
	private Long buildYear;
	private String categoryOfFinishes;
	@Column(length = 7000)
	private String description;
	private Double latitude;
	private Double longitude;
	@ElementCollection
	private List<String> imageUrls;
}
