/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.hotelmanagementsystem3;

/**
 *
 * @author 23
 */
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.io.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
class Contact implements Serializable{
    private String phone;
    private String email;
    public Contact(){}
    public Contact(String phone, String email) {
        this.phone = phone;
        this.email = email;
    }
    public void set(String p,String e) {
        phone = p;
        email=e;
    }
    public String getEmail() {
        return email;
    }
     public String getPhone() {
        return phone;
    }

    public void display() {
        System.out.println("Contact Information:");
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
    }
}
class Address implements Serializable{
    private int street;
    private int house;
    private String city;
    public Address(){
        street=0;
        house=0;
        city="";
    }
    public Address(int a,int b,String c){
        street=a;
        house=b;
        city=c;
    }
    public void set(int a,int b,String c){
        street=a;
        house=b;
        city=c;
    }
    public int getstreet(){
        return street;
    }
    public int gethouse(){
        return house;
    }
    public String getcity(){
        return city;
    }
    public void display(){
        System.out.println("Street N0="+street);
        System.out.println("House NO="+house);
        System.out.println("City Name="+city);
    }
}
class Persons implements Serializable{
    private String name;
    private Address address;
    private Contact contact;
    public Persons(){
    }
    public Persons(String a,Address c,Contact d){
        name=a;
        address=c;
        contact=d;
    }
    public void set(String a,Address c,Contact d){
        name=a;
        address=c;
        contact=d;
    }
    public String getName(){
        return name;
    }
    public Address getaddress(){
        return address;
    }
    public Contact getcontact(){
        return contact;
    }
    public void display(){
        System.out.println("Name="+name);
        address.display();
        contact.display();
    }
    }
class Hotel implements Serializable{
    private String name;
    private Address address;
    private Contact contact;
    private int rooms;
    public Hotel(){}
    public Hotel(String name, Address address, Contact contact, int rooms) {
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.rooms = rooms;
    }
    public void setHotelData(String name, Address address, Contact contact, int rooms) {
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.rooms = rooms;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public Contact getContact() {
        return contact;
    }

    public int getRooms() {
        return rooms;
    }

    public void displayInfo() {
        System.out.println("Hotel Information:");
        System.out.println("Name: " + name);
        System.out.println("Address: ");
        address.display();
        System.out.println("Contact: ");
        contact.display();
        System.out.println("Rooms: " + rooms);
    }
}

class Room implements Serializable{
    private int roomNumber;
    private boolean availability;
    public Room(){}
    public Room(int roomNumber, boolean availability) {
        this.roomNumber = roomNumber;
        this.availability = availability;
    }

    public int getRoomNumber() {
        return roomNumber;
    }
    public void setRoomNumber(int r){
        this.roomNumber=r;
    }
    public void setAvailability(boolean data){
        this.availability=data;
    }
    public boolean checkAvailability() {
        return availability;
    }

    public void setRoomData(int roomNumber, boolean availability) {
        this.roomNumber = roomNumber;
        this.availability=availability;
    }

    public void displayInfo() {
        System.out.println("Room Information:");
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Room available: " + availability);
    }
}


class Guest implements Serializable{
    private Persons person;

    public Guest(Persons person) {
        this.person = person;
    }

    public Persons getPerson() {
        return person;
    }
    public void setPerson(Persons p){
        this.person=p;
    }

    public void displayInfo() {
       person.display();
    }

    public void checkIn() {
        System.out.println(person.getName() + " has checked in.");
    }

    public void checkOut() {
        System.out.println(person.getName() + " has checked out.");
    }
}
class Inventory implements Serializable {
    private String itemName;
    private int itemQuantity;
    private int itemCount;
    public Inventory(){}
    public Inventory(String n,int q,int num) {
        itemName = n;
        itemQuantity = q;
        itemCount=num;
    }
    public void removequantity(int q){
        if(q<=itemQuantity){
            itemQuantity=itemQuantity-q;}
        else {
            System.out.println("Intended deletion of Quantity is more than present quantity");
        }
    }
    public void addQuantity(int q){
        itemQuantity+=q;
    }
    public int getcount(){
    return itemCount;}
     public int getQuantity(){
    return itemQuantity;}
     public String getname(){
    return itemName;}
     public static void Header(){
        System.out.println("Item_ID      Item_NAME    Item_QUANTITY");
    }
    public void displayInventory() {
        System.out.println("Item Name="+itemName);
        System.out.println("Item Quantity"+itemQuantity);
    }
}




class Reservation implements Serializable{
    private Guest guest;
    public  int reservationNo;
    private Room[] room;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Billing bill;
    private double totalBill;

    public Reservation(Guest guest, Room[] r, LocalDate checkInDate, LocalDate checkOutDate,Billing b,double totalb) {
        this.guest = guest;
        
        room=new Room[r.length];
        for(int i=0;i<r.length;i++){
            this.room[i]=r[i];
        }
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        bill=b;
        this.totalBill=totalb;
        
    }

    public Guest getGuest() {
        return guest;
    }
    public double getTotalBill(){
        return totalBill;
    }
    public void setTotalBill(){
        bill.calculateBill();
    }
    public int getReservationNo(){
        return reservationNo;
    }
    public Room[] getRoom() {
        return room;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }
    public int getStayDuration() {
        long days = ChronoUnit.DAYS.between(checkInDate, checkOutDate);
        return (int) days;
}
    public Billing getBill(){
        return bill;
    }
    public void setReservationNo(int n){
        reservationNo=n;
    }

    public void displayReservationDetails() {
        System.out.println("Reservation Details:");
        System.out.println("Guest Name: " + guest.getPerson().getName());
        System.out.println("ReservationNo: "+reservationNo);
        
        for(int i=0;i<room.length;i++){
            System.out.println("Room no: "+room[i].getRoomNumber());
        }
        System.out.println("Check-in Date: " + checkInDate);
        System.out.println("Check-out Date: " + checkOutDate);
        System.out.println("Stay Duration: " + getStayDuration() + " days");
        System.out.println("Bill: "+totalBill);
        
    }
    
    
}
class Staff extends Persons implements Serializable {
    private String department;
    private double salary;
    private String gender;
    private String ID;
    public Staff(){}
    public Staff(String a,Address c,Contact d,String gen, String department, double salary,String id) {
        super(a,c,d);
        this.department = department;
        this.salary = salary;
        this.ID=id;
        this.gender=gen;
    }
     public void set(String a,Address c,Contact d,String gen, String department, double salary,String id) {
        super.set(a,c,d);
        this.department = department;
        this.salary = salary;
        this.ID=id;
        this.gender=gen;
    }
     public void set(String n,Address a, Contact c, String gen,String department,double salary){
         super.set(n,a,c);
        this.department = department;
        this.salary = salary;
        
        this.gender=gen;
     }
    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
    public String getGender(){
        return gender;
    }
    public String getid() {
        return ID;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public static void Header(){
        System.out.println("ID      NAME    GENDER       DEPARTMENT      SALARY      HOUSE      STREET      CITY     PHONE       EMAIL");
    }
    public void displayStaffInfo() {
         super.display();
        System.out.println("Staff Information:");
        System.out.println("ID"+ID);
        System.out.println("Department: " + department);
        System.out.println("Salary: $" + salary);
    }
}
class Billing implements Serializable{
    private int roomsReserved;
    private double totalAmount=7000;
    private int days;

    public Billing(int rooms,int d){
        this.roomsReserved=rooms;
        this.days=d;
       
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    

    
    public double calculateBill(){
        return roomsReserved*days*totalAmount;
    }

    public void displayBillingDetails() {
        System.out.println("Billing Details:");
        System.out.println("Total Amount: $" + totalAmount);
        System.out.println(roomsReserved+" Rooms are reserved for "+days+" days");
       
    }
}
class Manager{
    private String password;
    public Manager(){
        password="manager123";
    }
    public String getpassword(){
        return password;
    }
    public void setpassword(String p){
        password=p;
    }
}

public class HotelManagementSystem3 extends JFrame implements ActionListener{
    private File roomFile=new File("Room.txt");
    private File staffFile = new File("Staff.txt");
    private File hotelFile = new File("Hotel.txt");
    private File inventoryFile=new File("Inventory.txt");
    private File reservationFile=new File("Reservation.txt");
    private File billFile=new File("Bill.txt");
    private ArrayList<Room> roomList=new ArrayList<Room>();
    private ArrayList<Reservation> reservationList=new ArrayList<Reservation>();
    private ArrayList<Double> billsList=new ArrayList<Double>();
    private ArrayList<Staff> staffList = new ArrayList<>();
    private ArrayList<Inventory> inventoryList=new ArrayList<>();
    
    private Color CustomColor = new Color(174, 194, 198);
    private Manager M=new Manager();
    private JTextField nameField, phoneField,roomField,idField, emailField, houseField, streetField, cityField, departmentField, salaryField;
    private JComboBox genderComboBox;
    
    private Address A;
    private Contact C;
    private Hotel H;
    private Scanner input=new Scanner(System.in);
    private Scanner inputt=new Scanner(System.in);
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    Room[] roomArray;
    private ListIterator<Staff> iterator;
    private ListIterator<Room> iterator2;
    private ListIterator<Reservation> iterator3;
    private ListIterator<Double> iterator4;
    private ListIterator<Inventory> iterator6;
    
    public HotelManagementSystem3(){
         A=new Address(20,22, "Islamabad");
         C = new Contact("44-177-771-99", "hifzamehakhotel@gmail.com");
         H = new Hotel("Hifza Mehak Hotel", A, C, 20);
    }
    public void setA(Address a){
        A=a;
    }
    public void setC(Contact c){
        C =c;
    }
    public void setH(Hotel h){
        H = h;
    }
    
    Color navy=new Color(32,42,68);
    //MAIN
    public void mainMethod() {
    JFrame mainFrame = new JFrame("Main Frame");
    mainFrame.setBounds(200, 100, 800, 400);
    mainFrame.setLayout(new GridLayout(10,1,1,1));
    mainFrame.getContentPane().setBackground(navy);

    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new GridLayout(1,1,15,5));
    mainPanel.setBackground(navy);

    JLabel menu = new JLabel("WELCOME TO HIFZA AND MEHAK HOTEL");
    menu.setFont(new Font("Arial", Font.BOLD, 27));
    menu.setForeground(Color.WHITE);
    menu.setBackground(CustomColor);
    mainFrame.add(menu, BorderLayout.PAGE_START);

    JLabel label1 = new JLabel("YOUR KIND OF VACATION       YOUR KIND OF RENTAL");
    label1.setFont(new Font("Arial", Font.ITALIC, 20));
    label1.setForeground(Color.WHITE);
    label1.setBackground(navy);
    label1.setOpaque(true);
    mainFrame.add(label1, BorderLayout.AFTER_LAST_LINE);
    
    JLabel label = new JLabel("Select an Option");
    label.setForeground(Color.WHITE);
    label.setBackground(CustomColor);
    mainFrame.add(label, BorderLayout.AFTER_LAST_LINE);

    JButton B1 = new JButton("Guest");
    JButton B2 = new JButton("Login as Staff");
    JButton B3 = new JButton("Login as Manager");
    JButton endButton = new JButton("Exit");

    mainPanel.add(B1);
    mainPanel.add(B2);
    mainPanel.add(B3);
    mainPanel.add(endButton);

    B1.setBackground(CustomColor);
    B2.setBackground(CustomColor);
    B3.setBackground(CustomColor);
    endButton.setBackground(CustomColor);

    B1.addActionListener(this);
    B2.addActionListener(this);
    B3.addActionListener(this);
    endButton.addActionListener(this);

    mainFrame.add(mainPanel);
    mainFrame.setVisible(true);
    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

    //MANAGER
     public void managerLOGIN(){
        JFrame login=new JFrame("Login Validation");
        login.setBounds(100,90,400,400);
        JPanel mainPanel = new JPanel(new GridLayout(9, 2, 10, 10));
        mainPanel.setBackground(navy);
        login.setLayout(new BorderLayout());
        login.getContentPane().setBackground(CustomColor);
        JLabel labe=new JLabel("Enter password=");
        mainPanel.add(labe,BorderLayout.NORTH);
        nameField = new JTextField();
        mainPanel.add(nameField);
        JButton submitButton = new JButton("Submit Password");
        submitButton.setBackground(CustomColor);
        submitButton.addActionListener(this);
        mainPanel.add(submitButton);
        login.add(mainPanel);
        login.setVisible(true);
    }
    public void managerMenu() {
        String password = nameField.getText();
        if(password.equals(M.getpassword())){
        JFrame managerFrame=new JFrame("Manager Menu");
        managerFrame.setBounds(3,4,400,200);
        managerFrame.setLayout(new BorderLayout());
        managerFrame.getContentPane().setBackground(CustomColor);
        JPanel managerPanel = new JPanel();
        managerPanel.setLayout(new FlowLayout());
        managerPanel.setBackground(navy);
        JLabel label = new JLabel("What you want to do?");
        label.setLayout(new FlowLayout());
        label.setVisible(true);
        managerFrame.add(label, BorderLayout.BEFORE_FIRST_LINE); 
        JButton B1 = new JButton("Manage Staff");
        JButton B2 = new JButton("Manage Hotel Information");
        JButton B3 = new JButton("See Report of Hotel");
        JButton B4 = new JButton("Change your Password");
        JButton endButton = new JButton("Click cross icon to exit");
        B1.setBackground(CustomColor);
        B2.setBackground(CustomColor);
        B3.setBackground(CustomColor);
        B4.setBackground(CustomColor);
        endButton.setBackground(CustomColor);
        managerPanel.add(B1);
        managerPanel.add(B2);
        managerPanel.add(B3);
        managerPanel.add(B4);
        managerPanel.add(endButton);
        managerFrame.add(managerPanel);
        B1.addActionListener(this);
        B2.addActionListener(this);
        B3.addActionListener(this);
        B4.addActionListener(this);
        endButton.addActionListener(this);
        managerFrame.setVisible(true);}
        else{
            JOptionPane.showMessageDialog(this, "INVALID PASSWORD");
        }
         nameField.setText("");
    }
    //MANAGE STAFF
    public void manageStaff() {
        JFrame mstaffFrame=new JFrame("Manage Staff");
        mstaffFrame.setBounds(3,4,400,200);
        mstaffFrame.setLayout(new BorderLayout());
        mstaffFrame.getContentPane().setBackground(CustomColor);
        JPanel staffPanel = new JPanel();
        staffPanel.setLayout(new FlowLayout());
        JLabel label = new JLabel("What you want to do?");
        label.setLayout(new FlowLayout());
        label.setVisible(true);
        mstaffFrame.add(label, BorderLayout.BEFORE_FIRST_LINE); 
        staffPanel.setBackground(navy);
        JButton B1 = new JButton("Print Information of All Staff members");
        JButton B2 = new JButton("Enter new Staff member");
        JButton B3 = new JButton("Remove staff member");
        JButton endButton = new JButton("Click cross icon to exit");
        staffPanel.add(B1);
        staffPanel.add(B2);
        staffPanel.add(B3);
        staffPanel.add(endButton);
        mstaffFrame.add(staffPanel);
        B1.setBackground(CustomColor);
        B2.setBackground(CustomColor);
        B3.setBackground(CustomColor);
        endButton.setBackground(CustomColor);
        B1.addActionListener(this);
        B2.addActionListener(this);
        B3.addActionListener(this);
        endButton.addActionListener(this);
        mstaffFrame.setVisible(true);
    }
    public void readStaffFile() throws Exception{
        if (staffFile.isFile()) {
                ois = new ObjectInputStream(new FileInputStream(staffFile));
                Object obj = ois.readObject();
                if (obj instanceof ArrayList<?>) {
                    staffList = (ArrayList<Staff>) obj;
                } else {
                    staffList.add((Staff) obj);
                }
                ois.close();
            }
    }
     public void printStaffInformation(){
        try {
            readStaffFile();
        } catch (Exception ex) {
        }
        Staff.Header();
        iterator = staffList.listIterator();
        while (iterator.hasNext()) {
            Staff staff = iterator.next();
            System.out.println(
                staff.getid()+"       "+staff.getName() + "    " + staff.getGender() + "    " + staff.getDepartment() + "    " +
                staff.getSalary() + "    " + staff.getaddress().gethouse() + "    " +
                staff.getaddress().getstreet() + "    " + staff.getaddress().getcity() + "    " +
                staff.getcontact().getPhone() + "    " + staff.getcontact().getEmail()
            );
        }
    }
    public void staffForm(){
        JFrame StaffForm=new JFrame("Staff Information Form");
        StaffForm.setBounds(0,0,1000,1000);
        StaffForm.setLayout(new GridLayout());
        StaffForm.getContentPane().setBackground(CustomColor);
        JPanel mainPanel = new JPanel(new GridLayout(13, 2,10,10));
        mainPanel.setBackground(CustomColor);
        mainPanel.add(new JLabel("ID:"));
        idField = new JTextField();
        mainPanel.add(idField);
        
        mainPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        mainPanel.add(nameField);

        mainPanel.add(new JLabel("Gender:"));
        genderComboBox = new JComboBox<>(new String[]{"Male", "Female","Other"});
        mainPanel.add(genderComboBox);

        mainPanel.add(new JLabel("Phone:"));
        phoneField = new JTextField();
        mainPanel.add(phoneField);

        mainPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        mainPanel.add(emailField);

        mainPanel.add(new JLabel("House No:"));
        houseField = new JTextField();
        mainPanel.add(houseField);

        mainPanel.add(new JLabel("Street No:"));
        streetField = new JTextField();
        mainPanel.add(streetField);

        mainPanel.add(new JLabel("City:"));
        cityField = new JTextField();
        mainPanel.add(cityField);

        mainPanel.add(new JLabel("Department:"));
        departmentField = new JTextField();
        mainPanel.add(departmentField);

        mainPanel.add(new JLabel("Salary:"));
        salaryField = new JTextField();
        mainPanel.add(salaryField);

        JButton submitButton = new JButton("Submit Staff Form");
        submitButton.setBackground(CustomColor);
        submitButton.addActionListener(this);
        mainPanel.add(submitButton);

        StaffForm.add(mainPanel);
        StaffForm.setVisible(true);
    }
    public void insertStaff()throws Exception{
        Staff staff = new Staff();
        Address address = new Address();
        Contact contact = new Contact();

        String name = nameField.getText();
        String gender = (String) genderComboBox.getSelectedItem();
        String phone = phoneField.getText();
        String email = emailField.getText();
        int house = Integer.parseInt(houseField.getText());
        int street = Integer.parseInt(streetField.getText());
        String city = cityField.getText();
        String department = departmentField.getText();
        String id=idField.getText();
        double salary = Double.parseDouble(salaryField.getText());

        contact.set(phone, email);
        address.set(street, house, city);
        staff.set(name, address, contact, gender, department, salary,id);

        staffList.add(staff);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(staffFile));
        oos.writeObject(staffList);
        oos.close();

        JOptionPane.showMessageDialog(this, "Staff member added successfully!");

        clearFields();
    }
    private void clearFields() {
        nameField.setText("");
        genderComboBox.setSelectedIndex(0);
        phoneField.setText("");
        emailField.setText("");
        houseField.setText("");
        streetField.setText("");
        cityField.setText("");
        departmentField.setText("");
        salaryField.setText("");
        idField.setText("");
    }
     public void updateStaff()throws Exception{
        System.out.println("Enter staff ID you want to remove=");
        String id = inputt.nextLine();
        iterator = staffList.listIterator();
        while (iterator.hasNext()) {
            Staff staff = iterator.next();
            if (staff.getid().equals(id)) {
                iterator.remove();
                System.out.println("Staff member removed successfully.");
                break;
               }
             }
            oos = new ObjectOutputStream(new FileOutputStream(staffFile));
            oos.writeObject(staffList);
            oos.close();
   
    }
    //MANAGE HOTEL
      public void writeHotelFile(Hotel h) throws Exception{
        oos=new ObjectOutputStream(new FileOutputStream(hotelFile));
        oos.writeObject(h);
        oos.close();
    }
    public void readHotelFile()throws Exception{
        ois=new ObjectInputStream(new FileInputStream("Hotel.txt"));
        while(true){
            Hotel hotel=(Hotel)ois.readObject();
            hotel.displayInfo();
        }
    }
    public void manageHotel(){
        JFrame mhotelFrame=new JFrame("Manage Hotel Information");
        mhotelFrame.setBounds(3,4,400,200);
        mhotelFrame.setLayout(new BorderLayout());
        mhotelFrame.getContentPane().setBackground(CustomColor);
        JPanel hotelPanel = new JPanel();
        hotelPanel.setLayout(new FlowLayout());
        JLabel label = new JLabel("What you want to do?");
        label.setLayout(new FlowLayout());
        label.setVisible(true);
        mhotelFrame.add(label, BorderLayout.BEFORE_FIRST_LINE); 
        hotelPanel.setBackground(navy);
        JButton B1 = new JButton("Print Information of Hotel");
        JButton B2 = new JButton("Update Infromation of Hotel");
        JButton endButton = new JButton("Click cross icon to exit");
        hotelPanel.add(B1);
        hotelPanel.add(B2);
        hotelPanel.add(endButton);
        B1.setBackground(CustomColor);
        B2.setBackground(CustomColor);
        endButton.setBackground(CustomColor);
        mhotelFrame.add(hotelPanel);
        B1.addActionListener(this);
        B2.addActionListener(this);
        endButton.addActionListener(this);
        mhotelFrame.setVisible(true);
    }    
    public void newHotelForm(){
        JFrame HotelForm=new JFrame("Hotel Information Form");
        HotelForm.setBounds(0,0,1000,1000);
        HotelForm.setLayout(new GridLayout());
        HotelForm.getContentPane().setBackground(CustomColor);
        JPanel mainPanel = new JPanel(new GridLayout(9, 2, 10, 10));
        mainPanel.setBackground(CustomColor);
        mainPanel.add(new JLabel("Name of Hotel:"));
        nameField = new JTextField();
        mainPanel.add(nameField);

        mainPanel.add(new JLabel("Contact number of Hotel:"));
        phoneField = new JTextField();
        mainPanel.add(phoneField);

        mainPanel.add(new JLabel("Email of Hotel:"));
        emailField = new JTextField();
        mainPanel.add(emailField);

        mainPanel.add(new JLabel("Building No:"));
        houseField = new JTextField();
        mainPanel.add(houseField);

        mainPanel.add(new JLabel("Street No:"));
        streetField = new JTextField();
        mainPanel.add(streetField);

        mainPanel.add(new JLabel("City:"));
        cityField = new JTextField();
        mainPanel.add(cityField);

        mainPanel.add(new JLabel("Total Rooms"));
        roomField=new JTextField();
        mainPanel.add(roomField);
        
        JButton submitButton = new JButton("Submit Hotel Updated Information");
        submitButton.setBackground(CustomColor);
        submitButton.addActionListener(this);
        mainPanel.add(submitButton);

        HotelForm.add(mainPanel);
        HotelForm.setVisible(true);
    }
     public void updateHotel()throws Exception{
        Hotel hotel = new Hotel();
        Address address = new Address();
        Contact contact = new Contact();
        String name = nameField.getText();
        String phone = phoneField.getText();
        String email = emailField.getText();
        int house = Integer.parseInt(houseField.getText());
        int street = Integer.parseInt(streetField.getText());
        String city = cityField.getText();
        int room = Integer.parseInt(roomField.getText());
        contact.set(phone, email);
        address.set(street, house, city);
        hotel.setHotelData(name, address,contact,room);
        this.setA(address);
        this.setC(contact);
        this.setH(hotel);
        writeHotelFile(hotel);
        JOptionPane.showMessageDialog(this, "Hotel Information updated successfully!");
        clearFieldsHotelForm();
    }
    
    private void clearFieldsHotelForm() {
        nameField.setText("");
        phoneField.setText("");
        emailField.setText("");
        houseField.setText("");
        streetField.setText("");
        cityField.setText("");
        roomField.setText("");
    }
    //REPORT OF HOTEL
    public void HotelReport(){
        System.out.println("--------HOTEL INFORMATION---------");
        try {
            readHotelFile();
        } catch (Exception ex) {
        }
        System.out.println("--------ROOM INFORMATION---------");
        try {
            checkRoomsAvailability();
        } catch (Exception ex) {
        }
        System.out.println("--------Reservation INFORMATION---------");
        try {
            CheckAllReservationsData();
        } catch (Exception ex) {
        }
        System.out.println("--------BILL INFORMATION---------");
        try {
            DisplayAllBills();
        } catch (Exception ex) {
        }
        try {
            totalBill();
        } catch (Exception ex) {
        }
        System.out.println("--------STAFF INFORMATION---------");
        printStaffInformation();
        System.out.println("--------INVENTORY INFORMATION---------");
        printInventory();
    }
    //CHANGE MANAGER PASSWORD
     public void changeManagerPassword(){
        M=new Manager();
        JFrame login=new JFrame("Change Password");
        login.setBounds(100,90,400,400);
        JPanel mainPanel = new JPanel(new GridLayout(9, 2, 10, 10));
        mainPanel.setBackground(navy);
        login.setLayout(new BorderLayout());
        login.getContentPane().setBackground(CustomColor);
        JLabel labe=new JLabel("Enter current password=");
        mainPanel.add(labe,BorderLayout.NORTH);
        nameField = new JTextField();
        mainPanel.add(nameField);
        JButton sButton = new JButton("Submit Current Password");
        sButton.setBackground(CustomColor);
        sButton.addActionListener(this);
        mainPanel.add(sButton);
        login.add(mainPanel);
        login.setVisible(true);
    }
    public void newPassword(){
        String p=nameField.getText();
        if(p.equals(M.getpassword())){
            JFrame login=new JFrame("Change Password");
            login.setBounds(100,90,400,400);
            JPanel mainPanel = new JPanel(new GridLayout(9, 2, 10, 10));
            mainPanel.setBackground(navy);
            login.setLayout(new BorderLayout());
            login.getContentPane().setBackground(CustomColor);
            JLabel label=new JLabel("Enter new password=");
            mainPanel.add(label,BorderLayout.NORTH);
            nameField = new JTextField();
            mainPanel.add(nameField);
            JButton submitButton = new JButton("Submit new Password");
            submitButton.setBackground(CustomColor);
            submitButton.addActionListener(this);
            mainPanel.add(submitButton);
            login.add(mainPanel);
            login.setVisible(true);
            nameField.setText("");}
        else{
            JOptionPane.showMessageDialog(this, "INVALID PASSWORD");
        }
        nameField.setText("");
    }
   //STAFF
     public void staffLOGIN(){
        JFrame login=new JFrame("Login Validation");
        login.setBounds(100,90,400,400);
        JPanel mainPanel = new JPanel(new GridLayout(9, 2, 10, 10));
        mainPanel.setBackground(navy);
        login.setLayout(new BorderLayout());
        login.getContentPane().setBackground(CustomColor);
        JLabel labe=new JLabel("Enter ID=");
        mainPanel.add(labe,BorderLayout.NORTH);
        idField = new JTextField();
        mainPanel.add(idField);
        JButton submitButton = new JButton("Submit ID");
        submitButton.setBackground(CustomColor);
        submitButton.addActionListener(this);
        mainPanel.add(submitButton);
        login.add(mainPanel);
        login.setVisible(true);
    }
      public void staffMenu()throws Exception{
        readStaffFile();
        String id=idField.getText();
        iterator = staffList.listIterator();
        boolean check=false;
        while (iterator.hasNext()) {
            Staff staff = iterator.next();
            if (staff.getid().equals(id) || id.equals("000")) {
                check=true;
                JFrame staffFrame=new JFrame("Staff Menu");
                staffFrame.setBounds(3,4,400,200);
                staffFrame.setLayout(new BorderLayout());
                staffFrame.getContentPane().setBackground(CustomColor);
                JPanel staffPanel = new JPanel();
                staffPanel.setLayout(new FlowLayout());
                JLabel label = new JLabel("What you want to do?");
                label.setLayout(new FlowLayout());
                label.setVisible(true);
                staffFrame.add(label, BorderLayout.BEFORE_FIRST_LINE); 
                staffPanel.setBackground(navy);
                JButton B1 = new JButton("Manage Inventory");
                JButton B2 = new JButton("Manage Rooms");
                JButton B3 = new JButton("Manage Reservations");
                JButton endButton = new JButton("Click cross icon to exit");
                B1.setBackground(CustomColor);
                B2.setBackground(CustomColor);
                B3.setBackground(CustomColor);
                endButton.setBackground(CustomColor);
                staffPanel.add(B1);
                staffPanel.add(B2);
                staffPanel.add(B3);
                staffPanel.add(endButton);
                staffFrame.add(staffPanel);
                B1.addActionListener(this);
                B2.addActionListener(this);
                B3.addActionListener(this);
                endButton.addActionListener(this);
                staffFrame.setVisible(true);
                break;
               }
             }
        if(check==false){
            JOptionPane.showMessageDialog(this, "INVALID ID"); 
        }
        idField.setText("");
    }
      //MANAGE INVENTORY
      public void inventoryMenu(){
        JFrame inventoryFrame=new JFrame("Manage Hotel Inventory");
        inventoryFrame.setBounds(3,4,400,200);
        inventoryFrame.setLayout(new BorderLayout());
        inventoryFrame.getContentPane().setBackground(CustomColor);
        JPanel inventoryPanel = new JPanel();
        inventoryPanel.setLayout(new FlowLayout());
        JLabel label = new JLabel("What you want to do?");
        label.setLayout(new FlowLayout());
        label.setVisible(true);
        inventoryFrame.add(label, BorderLayout.BEFORE_FIRST_LINE); 
        inventoryPanel.setBackground(navy);
        JButton B1 = new JButton("Print all Items in Inventory");
        JButton B2 = new JButton("Enter new item in Inventory");
        JButton B3 = new JButton("Delete item in Inventory");
        JButton endButton = new JButton("Click cross icon to exit");
        B1.setBackground(CustomColor);
        B2.setBackground(CustomColor);
        B3.setBackground(CustomColor);
        endButton.setBackground(CustomColor);
        inventoryPanel.add(B1);
        inventoryPanel.add(B2);
        inventoryPanel.add(B3);
        inventoryPanel.add(endButton);
        inventoryFrame.add(inventoryPanel);
        B1.addActionListener(this);
        B2.addActionListener(this);
        B3.addActionListener(this);
        endButton.addActionListener(this);
        inventoryFrame.setVisible(true);
    }
      public void readInventoryFile() throws Exception{
        if (inventoryFile.isFile()) {
                ois = new ObjectInputStream(new FileInputStream(inventoryFile));
                Object obj = ois.readObject();
                if (obj instanceof ArrayList<?>) {
                    inventoryList = (ArrayList<Inventory>) obj;
                } else {
                    // Handle the case when the file contains a single Staff object
                    inventoryList.add((Inventory) obj);
                }
                ois.close();
            }
    }
      public void printInventory(){
        try {
            readInventoryFile();
        } catch (Exception ex) {
            
        } 
        Inventory.Header();
        iterator6 = inventoryList.listIterator();
        while (iterator6.hasNext()) {
            Inventory inventory = iterator6.next();
            System.out.println(
                inventory.getcount() + "    " + inventory.getname() + "      " + inventory.getQuantity());
        }
    }
    
    public void inventoryForm(){
        JFrame StaffForm=new JFrame("Inventory Form");
        StaffForm.setBounds(0,0,1000,1000);
        StaffForm.setLayout(new GridLayout());
        StaffForm.getContentPane().setBackground(CustomColor);
        JPanel mainPanel = new JPanel(new GridLayout(9, 2, 10, 10));
        mainPanel.setBackground(CustomColor);
        mainPanel.add(new JLabel("Item ID:"));
        salaryField = new JTextField();
        mainPanel.add(salaryField);
        
        mainPanel.add(new JLabel("Item Name:"));
        nameField = new JTextField();
        mainPanel.add(nameField);

        mainPanel.add(new JLabel("Item Quantity:"));
        phoneField = new JTextField();
        mainPanel.add(phoneField);

        JButton submitButton = new JButton("Submit Inventory Form");
        submitButton.addActionListener(this);
        mainPanel.add(submitButton);
        submitButton.setBackground(CustomColor);

        StaffForm.add(mainPanel);
        StaffForm.setVisible(true);
    }
     public void insertInventory() throws Exception{
        String name = nameField.getText();
        int quantity= Integer.parseInt(phoneField.getText());
        int num = Integer.parseInt(salaryField.getText());
        Inventory inventory =new Inventory(name,quantity,num);
        inventoryList.add(inventory);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(inventoryFile));
        oos.writeObject(inventoryList);
        oos.close();

        JOptionPane.showMessageDialog(this, "Inventory item added successfully!");
        clearFieldsInventoryForm();
    }
    
     public void  updateInventory()throws Exception{
        System.out.println("Enter Inventory ID you want to remove=");
        int id = input.nextInt();
        iterator6 = inventoryList.listIterator();
        while (iterator6.hasNext()) {
            Inventory inventory = iterator6.next();
            if (inventory.getcount()==id) {
                iterator6.remove();
                System.out.println("Item removed successfully.");
                break;
               }
             }
            oos = new ObjectOutputStream(new FileOutputStream(inventoryFile));
            oos.writeObject(inventoryList);
            oos.close();
    }
    public void clearFieldsInventoryForm(){
        nameField.setText("");
        phoneField.setText("");
        salaryField.setText("");
    }
   //MANAGE ROOMS
     public void Rooms(){
        JFrame roomsFrame=new JFrame("Manage Rooms");
        roomsFrame.setBounds(3,4,400,200);
        roomsFrame.setLayout(new BorderLayout());
        roomsFrame.getContentPane().setBackground(CustomColor);
        JLabel label = new JLabel("What you want to do?");
        label.setLayout(new FlowLayout());
        label.setVisible(true);
        roomsFrame.add(label, BorderLayout.BEFORE_FIRST_LINE); 
        JPanel roomsPanel=new JPanel();
        roomsPanel.setLayout(new FlowLayout());
        roomsPanel.setBackground(navy);
        JButton b1=new JButton("PrintAllRoomsAvailabilty");
        JButton b2=new JButton("SetRooms");
        JButton endButton=new JButton("Click cross button to exit");
        roomsPanel.add(b1);
        roomsPanel.add(b2);
        roomsPanel.add(endButton);
        roomsFrame.add(roomsPanel);
        b1.setBackground(CustomColor);
        b2.setBackground(CustomColor);
        endButton.setBackground(CustomColor);
        b1.addActionListener(this);
        b2.addActionListener(this);
        roomsFrame.setVisible(true);
        
    }
     public void SetRooms(){
        for(int i=0;i<20;i++){
        Room r=new Room(i,true);
        roomList.add(r);
        }
        try {
            writeRoomFile();
        } catch (Exception ex) {
        }
    }
    public void checkRoomsAvailability(){
        if(!roomFile.exists()){
            try {
                for(int i=0;i<20;i++){
                    Room r=new Room(i,true);
                    roomList.add(r);
                }
                oos=new ObjectOutputStream(new FileOutputStream(roomFile));
                oos.writeObject(roomList);
                oos.close();
            } catch (IOException ex) {
            }
        }
        try {
            readRoomFile();
        } catch (Exception ex) {
        }
        System.out.println("Room no"+" "+"Availability");
        iterator2=roomList.listIterator();
        while(iterator2.hasNext()){
            Room r=iterator2.next();
            System.out.println(r.getRoomNumber()+" "+r.checkAvailability());
        }  
        }
    //MANAGE RESERVATIONS
      public void Reservations() {
        JFrame reservationsFrame=new JFrame("Reservations Menu");
        reservationsFrame.setBounds(3,4,400,200);
        reservationsFrame.setLayout(new BorderLayout());
        reservationsFrame.getContentPane().setBackground(CustomColor);
        JPanel reservationsPanel=new JPanel();
        reservationsPanel.setLayout(new FlowLayout());
        reservationsPanel.setBackground(navy);
        JLabel label = new JLabel("What you want to do?");
        label.setLayout(new FlowLayout());
        label.setVisible(true);
        reservationsFrame.add(label, BorderLayout.BEFORE_FIRST_LINE); 
        JButton b1=new JButton("PrintAllReservationsInformation");
        JButton b4=new JButton("PrintAllBills");
        JButton endButton=new JButton("Click cross Button to exit");
        b1.setBackground(CustomColor);
        b4.setBackground(CustomColor);
        endButton.setBackground(CustomColor);
        reservationsPanel.add(b1);
        reservationsPanel.add(b4);
        reservationsPanel.add(endButton);
        reservationsFrame.add(reservationsPanel);
        b1.addActionListener(this);
        b4.addActionListener(this);
        reservationsFrame.setVisible(true);
        
    }
      
    public void CheckAllReservationsData()throws Exception{
        readReservationFile();
        iterator3=reservationList.listIterator();
        while(iterator3.hasNext()){
            Reservation r=iterator3.next();
            System.out.println("NAME: "+r.getGuest().getPerson().getName());
            System.out.println("Address: \nHouseNo: "+r.getGuest().getPerson().getaddress().gethouse());
            System.out.println("StreetNo: "+r.getGuest().getPerson().getaddress().getstreet());
            System.out.println("City: "+r.getGuest().getPerson().getaddress().getcity());
            System.out.println("Contacts: \nPhoneNumber: "+r.getGuest().getPerson().getcontact().getPhone());
            System.out.println("Email: "+r.getGuest().getPerson().getcontact().getEmail());
            System.out.println("Rooms reserved: ");
            for(int i=0;i<r.getRoom().length;i++){
                System.out.println(r.getRoom()[i].getRoomNumber());
            }
            System.out.println("Check-In: "+r.getCheckInDate());
            System.out.println("Check-out: "+r.getCheckOutDate());
            System.out.println("Total Bill: "+r.getBill().calculateBill());
            System.out.println("ReservationNo: "+r.getReservationNo());
        }
    }
    public void readReservationFile() throws Exception{
        if(reservationFile.isFile()){
            ois=new ObjectInputStream(new FileInputStream(reservationFile));
            Object obj=ois.readObject();
            if(obj instanceof ArrayList<?>){
                reservationList=(ArrayList<Reservation>)obj;
            }
            else{
                reservationList.add((Reservation)obj);
            }
            ois.close();
    }
    }
    public void readBillFile()throws Exception{
        if(billFile.isFile()){
           ois=new ObjectInputStream(new FileInputStream(billFile));
           Object obj3=ois.readObject();
           if(obj3 instanceof ArrayList<?>){
               billsList=(ArrayList<Double>)obj3;
           }
           else{
               billsList.add((Double)obj3);
           }
           ois.close();
        }
    }
    public void readRoomFile()throws Exception{
        if(roomFile.isFile()){
            ois=new ObjectInputStream(new FileInputStream(roomFile));
            Object obj2=ois.readObject();
            if(obj2 instanceof ArrayList<?>){
                roomList=(ArrayList<Room>)obj2;
            }
            else{
                roomList.add((Room)obj2);
            }
            ois.close();
        }
    }
    public void writeReservationFile()throws Exception{
        oos=new ObjectOutputStream(new FileOutputStream(reservationFile));
        oos.writeObject(reservationList);
        oos.close();
    }
    public void writeBillFile()throws Exception{
        oos=new ObjectOutputStream(new FileOutputStream(billFile));
        oos.writeObject(billsList);
        oos.close();
    }
    public void writeRoomFile()throws Exception{
        oos=new ObjectOutputStream(new FileOutputStream(roomFile));
        oos.writeObject(roomList);
        oos.close();
    }
    public void DeleteAnyReservation(){
        System.out.println("Enter your reservationNo: ");
        int n=input.nextInt();
        
        try {
            readReservationFile();
        } catch (Exception ex) {
        }
        try {
            readRoomFile();
        } catch (Exception ex) {
                   }
        try {
            readBillFile();
        } catch (Exception ex) {
        }
        iterator3=reservationList.listIterator();
        while(iterator3.hasNext()){
            Reservation r=iterator3.next();
            if(r.getReservationNo()==n){
                for(int i=0;i<r.getRoom().length;i++){
                    iterator2=roomList.listIterator();
                    while(iterator2.hasNext()){
                        Room r2=iterator2.next();
                        if(r.getRoom()[i].getRoomNumber()==r2.getRoomNumber()){
                            r2.setAvailability(true);
                            
                            break;
                        }
                    }
                
                    
            }
            iterator4=billsList.listIterator();
            int k=0;
            while(iterator4.hasNext()){
            Double d=iterator4.next();
                if(r.getReservationNo()==k){
                    iterator4.remove();
                    break;
                }
                k++;
            }
            iterator3.remove();
            break;
            }
        }
        
        try {
            writeRoomFile();
        } catch (Exception ex) {
           
        }
        try {
            writeBillFile();
        } catch (Exception ex) {
           
        }
        try {
            writeReservationFile();
        } catch (Exception ex) {
           
        }
        
         JOptionPane.showMessageDialog(this, "Reservation deleted successfully!"); 
       
    }
     public void guestForm(){
        JFrame GuestForm=new JFrame("Guest Information Form");
        GuestForm.setBounds(0,0,1000,1000);
        GuestForm.setLayout(new GridLayout());
        GuestForm.getContentPane().setBackground(CustomColor);
        JPanel mainPanel = new JPanel(new GridLayout(10, 2,10,10));
        mainPanel.setBackground(CustomColor);
        
        mainPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        mainPanel.add(nameField);

        mainPanel.add(new JLabel("Gender:"));
        genderComboBox = new JComboBox<>(new String[]{"Male", "Female","Other"});
        mainPanel.add(genderComboBox);

        mainPanel.add(new JLabel("Phone No:"));
        phoneField = new JTextField();
        mainPanel.add(phoneField);

        mainPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        mainPanel.add(emailField);

        mainPanel.add(new JLabel("House No:"));
        houseField = new JTextField();
        mainPanel.add(houseField);

        mainPanel.add(new JLabel("Street No:"));
        streetField = new JTextField();
        mainPanel.add(streetField);

        mainPanel.add(new JLabel("City:"));
        cityField = new JTextField();
        mainPanel.add(cityField);
        
        mainPanel.add(new JLabel("Stay Time(in days):"));
        idField = new JTextField();
        mainPanel.add(idField);
        
        JButton submitButton = new JButton("Submit Guest Form");
        submitButton.setBackground(CustomColor);
        submitButton.addActionListener(this);
        mainPanel.add(submitButton);

        GuestForm.add(mainPanel);
        GuestForm.setVisible(true);
    }
    public void EnterReservation(){
        checkRoomsAvailability();
        Persons p=new Persons();
        System.out.println("How many rooms you want to reserved");
        int rooms=input.nextInt();
        int i=0;
        int count=0;
        roomArray=new Room[rooms];
        while(i<rooms){
            iterator2 = roomList.listIterator();
            while(iterator2.hasNext()){
                Room r=iterator2.next();
                count=r.getRoomNumber();
                if(r.checkAvailability()==true){
                    count=r.getRoomNumber();
                    System.out.println("Room NO: "+count+" has assigned to you");
                    r.setAvailability(false);
                    roomArray[i]=r;
                    i++;
                    break;
                }
                if(count==19 && i<=rooms-1){
                    System.out.println("Sorry, due to limited rooms, we cant make your desired reservation right now");
                    System.exit(0);
                }
            }
            
        }
        System.out.println(i+" rooms were available and they are assigned to you");
        try {
            writeRoomFile();
        } catch (Exception ex) {
                   }
        try {
            readReservationFile();
        } catch (Exception ex) {
                }
        try {
            readBillFile();
        } catch (Exception ex) {
                  }
        if(i>0){
            guestForm();
        }
        else{
            System.out.println("Sorry, due to limited rooms we cant make your reservation");
        }
    }
    public void insertGuest(){
            String name=nameField.getText();
            String email=emailField.getText();
            String phoneNo=phoneField.getText();
            int house=Integer.parseInt(houseField.getText());
            int street=Integer.parseInt(streetField.getText());
            String city=cityField.getText();
            Address a=new Address(street,house,city);
            Contact c=new Contact(phoneNo,email);
            Persons person=new Persons(name,a,c);
            Guest g=new Guest(person);
            LocalDate checkIn=LocalDate.now();
            int days=Integer.parseInt(idField.getText());
            LocalDate checkOut=checkIn.plusDays(days);
            Billing bill=new Billing(roomArray.length,days);
            double totalBill=bill.calculateBill();
            Reservation reservation=new Reservation(g,roomArray,checkIn,checkOut,bill,totalBill);
            int counting=-1;
            int maxReservationNo=0;
            if(reservationFile.isFile()){
                try{
                ois=new ObjectInputStream(new FileInputStream(reservationFile));
                iterator3=reservationList.listIterator();
                while(iterator3.hasNext()){
                    Reservation r=iterator3.next();
                    counting=r.getReservationNo();
                    if(counting>maxReservationNo){
                        maxReservationNo=counting;
                    }
                }
                }catch(IOException ex){
                    System.out.println("Exception");
                }
            }
            if(counting==-1){
                reservation.setReservationNo(maxReservationNo);
            }
            else{
            reservation.setReservationNo(++maxReservationNo);
            }
            billsList.add(reservation.getBill().calculateBill());
            reservation.displayReservationDetails();
            reservationList.add(reservation);
        try {
            writeReservationFile();
        } catch (Exception ex) {
                   }
            
        try {
            writeBillFile();
        } catch (Exception ex) {
                    }
            JOptionPane.showMessageDialog(this, "Reservation made successfully!");
            clearFields();
            idField.setText("");
          
    }
    public void DisplayAllBills()throws Exception{
        readBillFile();
        iterator4=billsList.listIterator();
        int i=0;
        while(iterator4.hasNext()){
            Double d=iterator4.next();
            System.out.println("Bill# "+i+" "+d);
            i++;
        }
    }
    public void totalBill() throws Exception{
        readBillFile();
        iterator4=billsList.listIterator();
        double total=0;
        while(iterator4.hasNext()){
            Double d=iterator4.next();
            total+=d;
        }
        System.out.println("TOTAL EARNINGS OF HOTEL="+total);
    }
   
    //GUEST
    public void GuestFrame(){
        JFrame guestFrame=new JFrame("GUEST");
        guestFrame.setBounds(3,4,400,200);
        guestFrame.setLayout(new BorderLayout());
        guestFrame.getContentPane().setBackground(CustomColor);
        JPanel guestPanel=new JPanel();
        guestPanel.setBackground(navy);
        guestPanel.setLayout(new FlowLayout());
        JLabel guestLabel=new JLabel("Select any option");
        guestLabel.setLayout(new FlowLayout());
        guestLabel.setVisible(true);
        guestFrame.add(guestLabel,BorderLayout.BEFORE_FIRST_LINE);
        JButton b1=new JButton("EnterReservation");
        JButton b2=new JButton("DeleteReservation");
        JButton endButton=new JButton("Click Cross Button to exit");
        guestPanel.add(b1);
        guestPanel.add(b2);
        guestPanel.add(endButton);
        guestFrame.add(guestPanel);
        b1.setBackground(CustomColor);
        b2.setBackground(CustomColor);
        endButton.setBackground(CustomColor);
        b1.addActionListener(this);
        b2.addActionListener(this);
        guestFrame.setVisible(true);
 
    }
    //ALL ACTION PERFORMED
    @Override
    public void actionPerformed(ActionEvent e){
        String a=e.getActionCommand();
        try{
        if(a.equals("PrintAllRoomsAvailabilty")){
            try{
            checkRoomsAvailability();
            }catch(Exception ex){
               
            }
        }
        else if(a.equals("See Report of Hotel")){
            HotelReport();
        }
        else if(a.equals("SetRooms")){
            try{
                SetRooms();
            }catch(Exception ex){
            }
        }
        else if(a.equals("PrintAllReservationsInformation")){
            try{
            CheckAllReservationsData();
            }catch(Exception ex){
            }
        }
        else if(a.equals("DeleteReservation")){
            try{
            DeleteAnyReservation();
            }catch(Exception ex){
            }
        }
        else if(a.equals("EnterReservation")){
            try{
            EnterReservation();
            }catch(Exception ex){
            }
        }
        else if(a.equals("PrintAllBills")){
            DisplayAllBills();
        }
        else if(a.equals("Manage Reservations")){
            Reservations();
        }
        else if(a.equals("Manage Rooms")){
            Rooms();
        }
        else if (a.equals("Manager")) {
            managerMenu();
        } else if (a.equals("Manage Staff")) {
            manageStaff();
        } else if (a.equals("Print Information of All Staff members")) {
            printStaffInformation();
        }
        else if(a.equals("Enter new Staff member")){
            staffForm();
        }
        else if(a.equals("Remove staff member")){
            try {
                updateStaff();
            } catch (Exception ex) {
            }
        }
        else if(a.equals("Submit Guest Form")){
            insertGuest();
        }
        else if (a.equals("Login as Manager")) {
            managerLOGIN();
        }else if(a.equals("Login as Staff")){
           staffLOGIN();
        }
        else if(a.equals("Manage Inventory")){
            inventoryMenu();
        }
        else if(a.equals("Print all Items in Inventory")){
            printInventory();
        }
        else if(a.equals("Enter new item in Inventory")){
            inventoryForm();
        }
        else if(a.equals("Submit Inventory Form")){
           try {
                insertInventory();
            } catch (Exception ex) {
             
            }
    }
        else if(a.equals("Change your Password")){
            changeManagerPassword();
        }
        else if(a.equals("Delete item in Inventory")){
            try {
                updateInventory();
            } catch (Exception ex) {
              
            }
        }
        else if(a.equals("Submit ID")){
           staffMenu();
        }
        else if(a.equals("Submit Staff Form")){
            try {
                insertStaff();
            } catch (Exception ex) {
            }
        }
        else if(a.equals("Submit Password")){
            managerMenu();
        }
        else if(a.equals("Submit Current Password")){
            newPassword();
        }
        else if(a.equals("Submit new Password")){
            M.setpassword(nameField.getText());
            JOptionPane.showMessageDialog(this, "PASSWORD CHANGED SUCCESSFULLY!");
        }
        else if(a.equals("Manage Hotel Information")){
            manageHotel();
        }
        else if(a.equals("Print Information of Hotel")){
            try {
                writeHotelFile(H);
                readHotelFile();
            } catch (Exception ex) {
            }
        }
        else if(a.equals("Update Infromation of Hotel")){
            newHotelForm();
        }
        else if(a.equals("Submit Hotel Updated Information")){
            try {
                updateHotel();
            } catch (Exception ex) {
            }
        }
        else if(a.equals("Submit")){
            try {
                insertStaff();
            } catch (Exception ex) {
            }
        }
        else if(a.equals("Guest")){
            try{
                GuestFrame();
            }catch(Exception ex){
               
            }
        }
        else if(a.equals("Exit")){
            System.exit(0);
        }
        }catch(Exception ex){
        }
    }
    public static void main(String[] args) throws Exception {
        HotelManagementSystem3 main=new HotelManagementSystem3();
        main.mainMethod();
        
}
}
