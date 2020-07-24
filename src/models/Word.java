package models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.Table;

@Table(name = "words")
@NamedQueries({

    })
@Entity
public class Word {

	@Id
	@Column(name = "primary_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer primary_id;

	@Column(name = "word", nullable = false)
	private String word;

	@Column(name = "mean", nullable = false)
	private String mean;

	@Column(name = "situation")
	private String situation;

	@Column(name = "note")
	private String note;

	@ManyToOne
    @JoinColumn(name = "posting_user", nullable = false)
	private User posting_user;

	@Column(name = "created_at", nullable = false)
	private Timestamp created_at;

	@Column(name = "updated_at", nullable = false)
	private Timestamp updated_at;

	public Integer getPrimary_id() {
		return primary_id;
	}

	public void setPrimary_id(Integer primary_id) {
		this.primary_id = primary_id;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getMean() {
		return mean;
	}

	public void setMean(String mean) {
		this.mean = mean;
	}

	public String getSituation() {
		return situation;
	}

	public void setSituation(String situation) {
		this.situation = situation;
	}



	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public User getPosting_user() {
		return posting_user;
	}

	public void setPosting_user(User posting_user) {
		this.posting_user = posting_user;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

	public Timestamp getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Timestamp updated_at) {
		this.updated_at = updated_at;
	}


}
