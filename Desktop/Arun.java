import java.util.*;

public class Calendar {

public void addEmployee(String name, Integer Id){
     Employee emp = new Employee(name, Id);
     employeeList.add(emp);
}

public void createMeeting(String name, Integer[] invitees, Date start, Date end){
	Meeting m1 = new Meeting();
	m1.createMeeting(name, invitees, start, end);
	meetingList.add(m1);
}

ArrayList<Employee> employeeList;
ArrayList<Meeting> meetingList;

public void Calendar(){
    employeeList = new ArrayList<Employee>();
    meetingList = new ArrayList<Meeting>();

}

public String[] listMeeting(Integer empId){
	ArrayList<String> strList = new ArrayList<String>();
       for(int i = 0; i < meetingList.length; i++){
		Meeting m1 = meetingList.get(i);
		if(m1.isEmpInvited(empId)){
		    strList.add(m1.getName());
		}
	}
	if(strList.length > 0){
		return ArrayList.toArray(strList);
	}
       return null;
}

public static void main(String args[]){
     Scanner sc = new Scanner(System.in);
	Calendar calendar = new Calendar();
     System.out.println("Enter the option\n 1. Add Employee \n 2. Create Meeting \n 3. List Meetings");
     int choice = sc.nextInt();
     switch(choice){
      case 1:{
        System.out.println("Enter the Employee Details:\n Name: \n Id\n");
        String name = sc.next();
        int id = sc.nextInt();
        calendar.addEmployee(name, id);
      }
	break;
      case 2:{
	   System.out.println("Enter the Meeting Details\n");
	   System.out.println("Meeting Name:\n");
	   String name = sc.next();
           
	   System.out.println("Meeting Start Time and End Time:\n");
   	   String start = sc.next();
	   String end = sc.next();
	   SimpleDateFormat scd = new SimpleDateFormat("DD-MM-YYYY:HH-MM-SS");
	   Date startTime = scd.getDateTime(start);
	   Date endTime = scd.getDateTime(end);

	   System.out.println("Enter the total number of invitees:\n");
	   int total_num = sc.nextInt();
	   System.out.println("Enter the Ids of Invited Employees:\n");
	   Integer empIds[] = new Integer[50];
	   for(int i = 0; i < total_num; i++){
		empIds[i] = sc.nextInt();
	   }
	   calendar.createMeeting(name, empIds, startTime, endTime);
	   		
	}
      break;
	case 3:{
	System.out.println("Enter the Employee Id:\n");	
	int id = sc.nextInt();
        String[] employeeList = calendar.listMeeting(id);
	if(employeeList != null){
		System.out.println("Invited Meeting Room Names: \n"); 
		for(int i = 0; i < employeeList.length; i++){
			System.out.println(employeeList[i] + "\n");
		}
	}
	else{
		System.out.println("No Meetings Invited for\n");
	}		
	}
	break;
	}
}

}




class Employee{
private String emp_name;
private Integer emp_Id;
Employee(String name, Integer Id){
emp_name = new String(name);
emp_Id = new Integer(Id);
	}
}





class Meeting{
private Date meeting_start;
Private Date meeting_end;
private String meeting_name;

private ArrayList<Integer> m_invitees;
public void Meeting(){

m_invitees = new ArrayList<Integer>();

}
public void createMeeting(String name, Integer[] invitees, Date start, Date end){
meeting_name = new String(name);
meeting_invitees = invitees.toArrayList();
meeting_start = start;
meeting_end = end;
}

public boolean isEmpInvited(Integer empId){
       for(int i = 0; i < invitees.length; i++){
		if(invitees.get(i) == empId){
			return true;
                 }
	}
	return false;

}

public String getName(){
 return meeing_name;
}

public Date getStartTime(){
return meeting_start;
}
