package desktopApp;

import java.util.*;
class BookDetails{
	String bookName;
	String bookTopic;
	String bookAuthor;
	BookDetails (String bookName, String bookTopic,String bookAuthor)
	{
		this.bookName=bookName;
		this.bookTopic=bookTopic;
		this.bookAuthor=bookAuthor;	
	}
}
class UserDefineException extends Exception
{
	UserDefineException( String message)
	{
   super(message);
	}
}
class DesktopAppLibrary{
	public static void main(String args[])
	{
		boolean b=true;
		int i=0;
		Scanner sc=new Scanner(System.in);
		String bookName;
		String bookTopic;
		String bookAuthor;
		ArrayList al=new ArrayList();
        while(b)
        {   System.out.println("-----------------");
        	System.out.println("Enter your choice");
        	System.out.println("1.Add Book");
        	System.out.println("2.Search Book");
        	System.out.println("3.Remove Book");
        	System.out.println("4.Exit");
        	System.out.println("5.All Books");
        	System.out.println("6.Update Book Name");
        	System.out.println("-----------------");
        	System.out.println("Enter -");
       try {
    	   
        	i=sc.nextInt();
        	sc.nextLine();
            } 
       catch(Exception e)
       {
    	   System.out.println("Invalid Input,input should be number");
    	sc.nextLine();
    	   i=-1;    	   
       }
        	switch(i)
        	{
        	case 1:
        		System.out.println("Enter Book Name to Add");
        	    bookName=sc.nextLine();
        	    System.out.println("Enter Book topic");
        	    bookTopic=sc.nextLine();
        	    System.out.println("Enter Book Author");
        	    bookAuthor=sc.nextLine();
        	    BookDetails b2=new BookDetails(bookName,bookTopic,bookAuthor);
        	    if(al.add(b2))
        	    	{
        	    	System.out.println("Book Added Successfully");
        	    	}
        	    else {
        	    	System.out.println("Book was not Added");
        	         }
        	    break;
        	case 2:
        		System.out.println("Enter Book Name to Search");
        		bookName=sc.nextLine();
        	
        		Iterator itt=al.iterator();
        		boolean notpresent=true;
                while(itt.hasNext())
                {
                BookDetails b3=(BookDetails)itt.next();
                if(b3.bookName.equalsIgnoreCase(bookName))
                {
                	System.out.println("Book is present in databse");
                    System.out.println(b3.bookAuthor+" is Author of the book");
                	System.out.println(b3.bookTopic+" is topic");
                    notpresent=false;
                }
                }
                if(notpresent)
                {
                	try {
                	throw new UserDefineException("Please enter correct name");
                	}
                	catch(UserDefineException e)
                	{
                		System.out.println(e);
                	}
                }
        		break;
        	case 3:
        		System.out.println("Enter Book Name to Remove");
        		bookName=sc.nextLine();
        		Iterator itt3=al.iterator();
        		boolean notfind=true;
        		while(itt3.hasNext())
        		{
        			BookDetails b4=(BookDetails)itt3.next();
        			if((b4.bookName).equals(bookName))
        			{
        				al.remove(b4);
        				System.out.println("Removed Successfully");
        			    notfind=false;
        			   break;
        			}
        		}
        	if(notfind)
        	{
        		System.out.println("Enter Book Name Correctly");
        	}
        		break;
        	case 5:
        		System.out.println("List of available books");
        		if(al.isEmpty())
        		{
        			System.out.println("No books present");
        		}
        		else
        		{
        		Iterator it=al.iterator();
        		while(it.hasNext())
        		{
        			BookDetails book=(BookDetails)it.next();
        			System.out.println(book.bookName);
        		}
        		}
        		break;
        		
        	case 4:
        	  System.exit(0);
        	case 6:
        		System.out.println("Enter Book Name to Update");
        		bookName=sc.nextLine();
        		Iterator itt5=al.iterator();
        		int index=-1;
        		while(itt5.hasNext())
        		{
        			index++;
        			BookDetails b5=(BookDetails)itt5.next();
        			if((b5.bookName).equalsIgnoreCase(bookName))
        			{
        				System.out.println("Enter new Book Name");
        				b5.bookName=sc.nextLine();
           			
        				System.out.println("Book Name are updated Sucessfully");
        			}
        		}
        	break;
        	default:
                	  System.out.println("Invalid choice");
        	  
        	  break;
        	}
       }

}
        
	
}