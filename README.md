# Women Safety Application
## _Feel Safe Everywhere_


Women Safety App is user friendly application built in Android Studio,
it is simple to implement,easy to understand.

## Features

- Easy to implement
- Easy to understand
- Shake detector
- Shake device to send SOS to registered mobile
- Sends Last Known Location to registered mobile

#### Prerequisites :
- Android Studio
- Basic knowledge about Firebase Authentication and Realtime database.
## Build and Run Application

###### Women Safety Application requires Android Oreo or newer version to run.
Follow this steps to get Working Project!
```
Clone this repository or download file
Extract zip if downloaded code
Open project in Android Studio
Wait while Android Studio Download gradle or required files
Hit Run Button !
```

------------

Module 37:  SQL Server Overview  

 What is SQL Server 

 Advantages of SQL Server 2012 

 SQL Server architecture 

 SQL Server security Model 

 SQL Server System databases 

 

Module 38:  SQL Server Tools  

 Server Tools 

• SQL Server manager 

• SQL Server Agent 

• Server Network Utility 

 Client Tools 

• SQL Enterprise Manager 

• SQL Query Analyzer 

• Client Network Utility

-----------------------------


using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Question_2
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("---------All Employee Details--------");

            var empList = ListEmployees(); // Call to method that returns the employee list
            Employee.Display(empList);

            Console.Read();
        }

        // Method to return populated list of employees
        static List<Employee> ListEmployees()
        {
            return new List<Employee>
            {
                new Employee { EmployeeID = 1001, FirstName = "Malcolm", LastName = "Daruwalla", Title = "Manager", DOB = DateTime.ParseExact("16/11/1984", "dd/MM/yyyy", null), DOJ = DateTime.ParseExact("08/06/2011", "dd/MM/yyyy", null), City = "Mumbai" },
new Employee { EmployeeID = 1002, FirstName = "Asdin", LastName = "Dhalla", Title = "AsstManager", DOB = DateTime.ParseExact("20/08/1984", "dd/MM/yyyy", null), DOJ = DateTime.ParseExact("07/07/2012", "dd/MM/yyyy", null), City = "Mumbai" },
new Employee { EmployeeID = 1003, FirstName = "Madhavi", LastName = "Oza", Title = "Consultant", DOB = DateTime.ParseExact("14/11/1987", "dd/MM/yyyy", null), DOJ = DateTime.ParseExact("12/04/2015", "dd/MM/yyyy", null), City = "Pune" },
new Employee { EmployeeID = 1004, FirstName = "Saba", LastName = "Shaikh", Title = "SE", DOB = DateTime.ParseExact("03/06/1990", "dd/MM/yyyy", null), DOJ = DateTime.ParseExact("02/02/2016", "dd/MM/yyyy", null), City = "Pune" },
new Employee { EmployeeID = 1005, FirstName = "Nazia", LastName = "Shaikh", Title = "SE", DOB = DateTime.ParseExact("08/03/1991", "dd/MM/yyyy", null), DOJ = DateTime.ParseExact("02/02/2016", "dd/MM/yyyy", null), City = "Mumbai" },
new Employee { EmployeeID = 1006, FirstName = "Amit", LastName = "Pathak", Title = "Consultant", DOB = DateTime.ParseExact("07/11/1989", "dd/MM/yyyy", null), DOJ = DateTime.ParseExact("08/08/2014", "dd/MM/yyyy", null), City = "Chennai" },
new Employee { EmployeeID = 1007, FirstName = "Vijay", LastName = "Natrajan", Title = "Consultant", DOB = DateTime.ParseExact("02/12/1989", "dd/MM/yyyy", null), DOJ = DateTime.ParseExact("01/06/2015", "dd/MM/yyyy", null), City = "Mumbai" },
new Employee { EmployeeID = 1008, FirstName = "Rahul", LastName = "Dubey", Title = "Associate", DOB = DateTime.ParseExact("11/11/1993", "dd/MM/yyyy", null), DOJ = DateTime.ParseExact("06/11/2014", "dd/MM/yyyy", null), City = "Chennai" },
new Employee { EmployeeID = 1009, FirstName = "Suresh", LastName = "Mistry", Title = "Associate", DOB = DateTime.ParseExact("12/08/1992", "dd/MM/yyyy", null), DOJ = DateTime.ParseExact("03/12/2014", "dd/MM/yyyy", null), City = "Chennai" },
new Employee { EmployeeID = 1010, FirstName = "Sumit", LastName = "Shah", Title = "Manager", DOB = DateTime.ParseExact("12/04/1991", "dd/MM/yyyy", null), DOJ = DateTime.ParseExact("02/01/2016", "dd/MM/yyyy", null), City = "Pune" }
            };
        }
    }

    class Employee
    {
        public int EmployeeID { get; set; }
        public string FirstName { get; set; }
        public string LastName { get; set; }
        public string Title { get; set; }
        public DateTime DOB { get; set; }
        public DateTime DOJ { get; set; }
        public string City { get; set; }

        public static void Display(IEnumerable<Employee> employeeList)
        {
            Console.WriteLine("{0,-8} {1,-12} {2,-12} {3,-14} {4,-12} {5,-12} {6,-10}","EmpID", "FirstName", "LastName", "Title", "DOB", "DOJ", "City");

            Console.WriteLine("----------------------------------------------------------------------------------------------------------------------"); 

            
            foreach (var e in employeeList)
            {
                Console.WriteLine("{0,-8} {1,-12} {2,-12} {3,-14} {4,-12} {5,-12} {6,-10}",e.EmployeeID,e.FirstName,e.LastName,e.Title,e.DOB.ToString("dd/MM/yyyy"),e.DOJ.ToString("dd/MM/yyyy"),e.City);
            }
        }

        public static void Linq1()
        {
            var joinedBefore2015 = Employee.Where()
        }


    }
}









   
