package facade;

import java.util.Date;
import java.util.Vector;

import javax.faces.event.ActionEvent;

import org.primefaces.event.SelectEvent;

import businessLogic.BLFacade;
import domain.Event;
import domain.Question;

public class CreateBean {


	private BLFacade facadeBL;
	private Vector<Event> gertaerak;
	private Date data;
	private Event ev;
	private Question newQuestion;
	private double newMinBet;
	public BLFacade getFacadeBL() {
		return facadeBL;
	}
	public void setFacadeBL(BLFacade facadeBL) {
		this.facadeBL = facadeBL;
	}
	public Vector<Event> getGertaerak() {
		return gertaerak;
	}
	public void setGertaerak(Vector<Event> gertaerak) {
		this.gertaerak = gertaerak;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	} 
	public Event getEv() {
		return ev;
	}
	public void setEv(Event ev) {
		this.ev = ev;
	}
	
	public Question getNewQuestion() {
		return newQuestion;
	}
	public void setNewQuestion(Question newQuestion) {
		this.newQuestion = newQuestion;
	}
	public double getNewMinBet() {
		return newMinBet;
	}
	public void setNewMinBet(double newMinBet) {
		this.newMinBet = newMinBet;
	}
	
	public void onDateSelect(SelectEvent event){
		
		gertaerak= facadeBL.getEvents((Date)event.getObject());
	}
	
	public void updateData(ActionEvent e) {
		   data = null;
		   gertaerak = null;
		   ev = null;
		}

	
}
