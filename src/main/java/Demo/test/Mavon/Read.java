package Demo.test.Mavon;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


/**
 * DAO file
 *
 */
public class Read
{
  static Configuration config;
  static SessionFactory factory;
  static Session session;
  static Transaction trans;
  
  
  public static void Insert() throws NumberFormatException, IOException
  {
    //creating object for Book
    Book b = new Book();
    
    Scanner sc=new Scanner(System.in);
    
    System.out.println("Enter Book ID : ");
    int id = Integer.parseInt(sc.nextLine());
    
    System.out.println("Enter Book Name : ");
    String name = sc.nextLine();
    
    System.out.println("Enter Author Name : ");
    String author = sc.nextLine();
    
    System.out.println("Enter Book Cost: ");
    int cost = Integer.parseInt(sc.nextLine());

    
    //Setting values
    b.setId(id);
    b.setName(name);
    b.setAuthor(author);
    b.setCost(cost);
   
    session.saveOrUpdate(b);
        trans =  session.beginTransaction();
        trans.commit();
    
  }
  
  public static void show()
  {
    String hqlQuery = "from Book";
    List<Book> book = session.createQuery(hqlQuery,Book.class).list();
    for(Book b : book)
    {
      System.out.println("-------------------" );
      int i=1;
      System.out.println("Book:" +i++ );
      System.out.println(b);
      i++;
    }
  }
  
  public static void removeBy(int bookid)
  {
    Book b  = session.get(Book.class,bookid);
    trans = session.beginTransaction();
    String name = b.getName();
    //session.delete(d1);
    session.remove(b);
    trans.commit();
    System.out.println("Book "+name+" is removed.");
  }
  
  public static void update(int bookid)
  {
    Book b = session.get(Book.class,bookid);
    trans = session.beginTransaction();
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter Book name to update:");
    String name = sc.nextLine();
    b.setName(name);
    session.update(b);
    trans.commit();
    System.out.println("Book name updated to " +name);
  }
    public static void main( String[] args ) throws NumberFormatException, IOException 
    {
           Read R = new Read();
           config = new Configuration();
           config.configure();
          
           factory = config.buildSessionFactory();
           
           //create Session object
           session = factory.openSession();
          
          //System.out.println("-------------------Online Book------------");
          System.out.println("1.Adding Book Details");
          System.out.println("2.Displaying Book Details");
          System.out.println("3.Remove Book Record");
          System.out.println("4.Updating an Employee");
          
          Scanner sc = new Scanner(System.in);
          int choice = Integer.parseInt(sc.nextLine());
          switch(choice)
          {
          case 1 :Read.Insert();
               System.out.println("Book details Added Sucessfully... Data updated !");                  
               break; 
               
          case 2 : System.out.println("Book Details..."); 
               Read.show();
               break;
               
          case 3 : System.out.println("Enter the Book id");
           int Bookid = sc.nextInt();
           Read.removeBy(Bookid);
           break;
           
          case 4 : System.out.println("Enter the Book id : ");
                 int Bookid1 = sc.nextInt();
                 Read.update(Bookid1);
                 break;
              
          default : System.out.println("Enter the valid choice !");
          }
          //closing configurations
            session.close();
            factory.close();
      }
}