Sports Card Collection Manager

The Sports Card Collection Manager is a Java application that allows users to manage 
a collection of sports cards through a console-based menu system. Users can add 
sports cards and graded cards, view stored records, update existing information, 
and delete records from an SQLite database. 
The program provides a practical way to organize and maintain a sports card 
collection while demonstrating database management and object-oriented programming concepts.

This project incorporates several key Java concepts, including inheritance, polymorphism, 
interfaces, abstract classes, and composition. The abstract Card class serves as the 
foundation for the SportsCard and GradedCard classes, while the Displayable interface 
provides a standard method for displaying card information. 

The CardCollection class demonstrates composition by managing a collection of card objects, 
and polymorphism is used when different card types are displayed through the same method.

The application stores data in an SQLite database named sportscards.db. 
The DatabaseManager class handles all CRUD operations, allowing users to create, 
read, update, and delete card records. Through its menu-driven interface, 
the program demonstrates database connectivity, terminal input/output, constructors, 
access modifiers, collections, and exception handling while meeting the requirements of the course project.
