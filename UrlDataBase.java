package chaithra;
import java.util.*;
import java.lang.*;
public class UrlDataBase {
	static boolean check(Url[] url,String link,int i) {
		for(int a=0;a<i;a++) {
			if(link.equals(url[a].urlLink)) {
				return true;
			}
		}
		return false;
	}
	public static void main(String args[]) {
			
		Scanner s=new Scanner(System.in);
		Url[] url = new Url[10];
		boolean r = true;
		int i = 0;
		while( r== true) {
			System.out.print("Enter Command > ");
			String str = s.nextLine();
			String c;
			String link = null;
			try {
				String[] commands = str.split(" ");
				c = commands[0];
				link = commands[1];
			}catch(ArrayIndexOutOfBoundsException e) {
				c = str;
			}
			switch(c) {
			case "get":
				for(int a=0;a<i;a++) {
					if(link.equals(url[a].urlLink)) {
						url[a].count++;
						System.out.println("ID : "+url[a].id);
						System.out.println("Count : "+url[a].count);
					}
				}
				break;
			case "storeurl":
				if(check(url,link,i)) {
					System.out.println("Already Exist");
					break;
				}
				url[i] = new Url();
				url[i].urlLink = link;
				url[i].id = UUID.randomUUID();
				i++;
				break;
			case "list":
				for(int j=0;j<i;j++) {
					System.out.println(url[j].id+"  "+url[j].urlLink+"  "+url[j].count);
				}
				break;
			case "count":
				for(int a=0;a<i;a++) {
					if(link.equals(url[a].urlLink)) {
						System.out.println("Count : "+url[a].count);
					}
				}
				break;
			case "exit":
				r = false;
				System.out.println("Terminated");
				break;
			default:
				System.out.println("Enter a valid command");
				break;
			}
			
			
		}
		
		
		
	}
	
}

class Url{
	public UUID id;
	public String urlLink;
	public int count = 0;
}