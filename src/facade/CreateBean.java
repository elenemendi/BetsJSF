package facade;

import java.util.Date;
import java.util.Vector;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.event.SelectEvent;

import businessLogic.BLFacade;
import domain.Event;

import exceptions.EventFinished;
import exceptions.QuestionAlreadyExist;

public class CreateBean {



	private BLFacade facadeBL;
	private Vector<Event> gertaerak;
	private Date data;
	private Event ev;
	private String newQuestion;
	private float newMinBet;
	
	public CreateBean() {
		facadeBL=FacadeBean.getBusinessLogic();
		gertaerak=facadeBL.getEvents(data);
	}
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
	public float getNewMinBet() {
		return newMinBet;
	}
	public void setNewMinBet(float newMinBet) {
		this.newMinBet = newMinBet;
	} 
	public String getNewQuestion() {
		return newQuestion;
	}
	public void setNewQuestion(String newQuestion) {
		this.newQuestion = newQuestion;
	}
	
	public void onDateSelect(SelectEvent event){
		
		gertaerak= facadeBL.getEvents((Date)event.getObject());
	}
	
	public void onEventSelect(SelectEvent event) {
		
		ev=(Event) event.getObject();
		System.out.println("nire ebentua"+ev);  
	}
	
	public void galderaSortu() throws EventFinished, QuestionAlreadyExist {
		System.out.println("nire ebentua"+ev);
		System.out.println("nire galdera"+newQuestion);  
		  if(ev==null){
		   FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Errorea: gertaera aukeratu behar da."));
		  }
		  else if(newQuestion.isEmpty()) {
		    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Errorea: bete eremu guztiak."));
		   }
		  else if(newMinBet<0.0) {
		   FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Errorea: zenbakizko balio okerra."));
		  }
		  else {
		   facadeBL.createQuestion(ev,newQuestion, newMinBet);
		   FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Galdera gorde da!"));
		  }
		 }
	
	public void updateData(ActionEvent e) {
		   data = null;
		   gertaerak = null;
		   ev = null;
		}

	
}
