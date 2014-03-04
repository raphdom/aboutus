package com.jrdevel.aboutus.model;

// Generated 4/Mar/2014 12:22:19 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Tab generated by hbm2java
 */
@Entity
@Table(name = "tbl_tabs")
public class Tab implements java.io.Serializable {

	private Integer id;
	private Music music;
	private Instrument instrument;
	private byte[] content;

	public Tab() {
	}

	public Tab(Music music, Instrument instrument, byte[] content) {
		this.music = music;
		this.instrument = instrument;
		this.content = content;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_music", nullable = false)
	public Music getMusic() {
		return this.music;
	}

	public void setMusic(Music music) {
		this.music = music;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_instrument", nullable = false)
	public Instrument getInstrument() {
		return this.instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

	@Column(name = "content", nullable = false)
	public byte[] getContent() {
		return this.content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

}
