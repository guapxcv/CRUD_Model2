package dto;

import java.util.Date;

public class BoardDTO {
	int id;
	String name;
	String title;
	String content;
	int readCount;
	Date date;
	
	public BoardDTO() {
		
	}
	public BoardDTO(int id, String name, String title, String content, int readCount, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.title = title;
		this.content = content;
		this.readCount = readCount;
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "BoardDTO [id=" + id + ", name=" + name + ", title=" + title + ", content=" + content + ", readCount="
				+ readCount + ", date=" + date + "]";
	}
	
}
