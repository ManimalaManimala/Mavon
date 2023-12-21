package Demo.test.Mavon;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Book 
{
@Id //primary key
private int Id;
private String Name;
private String Author;
private int Cost;

public int getId() {
	return Id;
}
public void setId(int ID) {
	this.Id = ID;
}
public String getName() {
	return Name;
}
public void setName(String Name) {
	this.Name = Name;
}
public String getAuthor() {
	return Author;
}
public void setAuthor(String Author) {
	this.Author = Author;
}
public int getCost() {
	return Cost;
}
public void setCost(int Cost) {
	this.Cost = Cost;
}
@Override
public String toString() {
	return "\n Book id=" + Id +", \n Name=" + Name + ", \n Author=" + Author + ", \n Cost=" + Cost ;
}
}
