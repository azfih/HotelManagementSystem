**Hotel Management System**

**Overview**

The Hotel Management System is a Java Swing application designed to manage various aspects of hotel operations. It provides functionality for managing reservations, rooms, staff, inventory, and hotel information. Users can interact with the system through a graphical user interface (GUI) with options for guests, staff, and managers.

**Features**

**Guest Operations:**

1:Enter new reservations.

2:Delete existing reservations.

3:View all rooms' availability.

**Manager Operations:**

1:Manage reservations.

2:Manage rooms.

3:Manage staff.

4:Manage inventory.

5:Manage hotel information.

**Staff Operations:**

1:View staff information.

2:Add or remove staff members.

**Inventory Management:**

1:Print all items in inventory.

2:Add or remove items in inventory.

**Getting Started**

**Prerequisites**

-Java Development Kit (JDK) 8 or later

-Integrated Development Environment (IDE) like Eclipse, IntelliJ IDEA, or NetBeans

**Setup**

-Clone the Repository: Clone the repository to your local machine.
git clone <repository-url>

-Import the Project: Open your IDE and import the project as a Java project.

-Compile the Code: Build the project to compile the source code.

-Run the Application: Execute the HotelManagementSystem3 class to launch the application.

**Usage**

Starting the Application:

Run the HotelManagementSystem3 class which contains the main method to start the GUI application.

Navigating the GUI:

Guest Menu: Provides options for making or deleting reservations.

Manager Menu: Allows managers to manage reservations, rooms, staff, inventory, and hotel information.

Staff Menu: Enables staff members to view and manage staff information.

Inventory Menu: Provides options for managing inventory items.

**Action Commands**

**Guest Operations:**

"EnterReservation" - Opens the reservation entry form.

"DeleteReservation" - Opens the reservation deletion form.

"PrintAllRoomsAvailability" - Prints the availability of all rooms.

**Manager Operations:**

"Manage Reservations" - Opens the reservations management menu.

"Manage Rooms" - Opens the rooms management menu.

"Manage Staff" - Opens the staff management menu.

"Manage Inventory" - Opens the inventory management menu.

"Manage Hotel Information" - Opens the hotel information management menu.

**Staff Operations:**

"Print Information of All Staff members" - Prints all staff information.

"Enter new Staff member" - Opens the form to add a new staff member.

"Remove staff member" - Opens the form to remove a staff member.

**Inventory Management:**

"Print all Items in Inventory" - Prints all items in the inventory.

"Enter new item in Inventory" - Opens the form to add a new inventory item.

"Delete item in Inventory" - Opens the form to delete an inventory item.

**Password Management:**

"Change your Password" - Opens the form to change the manager's password.

"Submit new Password" - Submits the new password.

**Hotel Information:**

"Print Information of Hotel" - Prints hotel information.

"Update Information of Hotel" - Opens the form to update hotel information.

**Code Structure**

HotelManagementSystem3.java: Main class containing the GUI logic and action listeners.

GuestFrame: Method to create and display the guest menu frame.

actionPerformed: Method to handle all action events from the GUI components.

main: Entry point of the application.

**Error Handling**

Ensure proper handling of exceptions where required.

Check for null pointers or invalid operations.

**Contributing**

Feel free to fork the repository, make changes, and submit a pull request. Ensure to follow best practices and test your changes thoroughly.

**License**

This project is licensed under the MIT License - see the LICENSE file for details.

