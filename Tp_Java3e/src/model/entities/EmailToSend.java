package model.entities;

public class EmailToSend {
	
	String m_source;
	String m_sourceName;
	String m_destination;
	String m_subject;
	String m_text;
	
	public String getM_source() {
		return m_source;
	}
	public void setM_source(String m_source) {
		this.m_source = m_source;
	}
	public String getM_sourceName() {
		return m_sourceName;
	}
	public void setM_sourceName(String m_sourceName) {
		this.m_sourceName = m_sourceName;
	}
	public String getM_destination() {
		return m_destination;
	}
	public void setM_destination(String m_destination) {
		this.m_destination = m_destination;
	}
	public String getM_subject() {
		return m_subject;
	}
	public void setM_subject(String m_subject) {
		this.m_subject = m_subject;
	}
	public String getM_text() {
		return m_text;
	}
	public void setM_text(String m_text) {
		this.m_text = m_text;
	}
}
