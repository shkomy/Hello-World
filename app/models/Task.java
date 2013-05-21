package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class Task extends Model {
	
	public String title;
	public boolean done;
	public int no;
    
	public Task(String title){
		this.title=title;
		this.no=0;
	}
}
