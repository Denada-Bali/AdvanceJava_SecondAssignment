package model;

import java.util.List;

import com.dbali.entity.Play;
import com.dbali.entity.Show;



public class ShowMOD {
	private long id;
	private Play play;
	private String startTime;
	private TheaterHallMOD theaterHall;
	
	
	
	public TheaterHallMOD getTheaterHall() {
		return theaterHall;
	}
	public void setTheaterHall(TheaterHallMOD theaterHall) {
		this.theaterHall = theaterHall;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Play getPlay() {
		return play;
	}
	public void setPlay(Play play) {
		this.play = play;
	}
	
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	
}
