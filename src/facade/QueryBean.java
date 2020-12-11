package facade;

import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
import java.util.Vector;

import javax.faces.event.ActionEvent;

import org.primefaces.event.SelectEvent;

import businessLogic.BLFacade;
import domain.Event;
import domain.Question;
public class QueryBean {
	private BLFacade facadeBL;
	private Vector<Event> gertaerak;
	private Date data;
	private Event ev;
	private Vector<Question> galderak;
	
	public QueryBean() {
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

	public Vector<Question> getGalderak() {
		return galderak;
	}

	public void setGalderak(Vector<Question> galderak) {
		this.galderak = galderak;
	}

	public void onDateSelect(SelectEvent event)
	{
		galderak = null;
		gertaerak= (Vector<Event>) facadeBL.getEvents((Date)event.getObject());
	}
	
	
	@SuppressWarnings("unchecked")
	public void onEventSelect(SelectEvent event) {
		Set<Question> galderakSet = new HashSet<Question>();
		Vector<Question>galderakV = new Vector<Question>();
		galderakSet = ((Event) event.getObject()).getQuestions();
		for (Question q: galderakSet) {
			galderakV.add(q);
		}
		Collections.sort(galderakV);
		this.galderak=galderakV;
	}
	
	public void galderaSortu() {
		
	}
	public void updateData(ActionEvent e) {
		   data = null;
		   galderak = null;
		   gertaerak = null;
		   ev = null;
		}
	
	
}


