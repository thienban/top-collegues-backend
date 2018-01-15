package topcolleguesbackend.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Vote {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	@Enumerated(EnumType.STRING)
	private Avis avis;
	@Column
	private LocalDate date;
	
	public Vote() {
		date = LocalDate.now();
	}
	
	@ManyToOne
	@JoinColumn(name="COL_ID")
	private Collegue collegue;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Collegue getCollegue() {
		return collegue;
	}
	public void setCollegue(Collegue collegue) {
		this.collegue = collegue;
	}
	public Avis getAvis() {
		return avis;
	}
	public void setAvis(Avis avis) {
		this.avis = avis;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
}
