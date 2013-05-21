package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;
import play.data.validation.*;
public class Application extends Controller {
    
    @Before 
    static void addDef(){
    	Task task = new Task("dsgdgdf");
	task.save();
    }

    public static void index() {
    	Task task = Task.find("order by id desc").first();
        render(task);
    }
    
    public static void sayHello(@Required String myName) {
        if(validation.hasErrors()) {
            flash.error("Oops, please enter your name!");
            index();
        }
	  Task task = Task.find("order by id desc").first();
        render(myName, task);
    }
    
    public static void createTask(long id){
    	//Task task = new Task(title).save();
    	Task task = Task.findById(id);
    	task.no++;
    	task.save();
    	renderJSON(task);
    }
    
    public static void changeStatus(long id, boolean done){
    	Task task = Task.findById(id);
    	task.done=done;
    	task.save();
    	renderJSON(task);
    }
}