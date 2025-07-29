using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Linq_Questions
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("---------All Questions--------");

            // Call to method that returns the employee list
            var empList = ListEmployees();

            //-----------------------------------------
            //linq1
            var joinedBefore2015 = Employee.Linq1(empList);

            //linq2
            var joinedBefore1990 = Employee.Linq2(empList);

            //linq3
            var ConsultantAndAssociate = Employee.Linq3(empList);

            //linq6
            var highestId = Employee.Linq6(empList);
            //---------------------------------------------







            //Display

            //Employee.Display(empList);


            //linq1
            Console.WriteLine();
            Console.WriteLine("**************Question-1**********");
            Console.WriteLine();
            Employee.Display(joinedBefore2015);

            //linq2
            Console.WriteLine();
            Console.WriteLine("**************Question-2**********");
            Console.WriteLine();
            Employee.Display(joinedBefore1990);

            //linq3
            Console.WriteLine();
            Console.WriteLine("**************Question-3**********");
            Console.WriteLine();
            Employee.Display(ConsultantAndAssociate);

            //linq4
            Console.WriteLine();
            Console.WriteLine("**************Question-4**********");
            Console.WriteLine();
            Employee.Linq4(empList);

            //linq5
            Console.WriteLine();
            Console.WriteLine("**************Question-5**********");
            Console.WriteLine();
            Employee.Linq5(empList);

            //linq6
            Console.WriteLine();
            Console.WriteLine("**************Question-6**********");
            Console.WriteLine();
            Employee.Display(highestId);


            //linq7
            Console.WriteLine();
            Console.WriteLine("**************Question-7**********");
            Console.WriteLine();
            int countJoinedAfter2015 = Employee.Linq7(empList);
            Console.WriteLine("Total Number of Employees joined after 1/1/2015 : " + countJoinedAfter2015);

            //linq8
            Console.WriteLine();
            Console.WriteLine("**************Question-8**********");
            Console.WriteLine();
            int countNotAssociate = Employee.linq8(empList);
            Console.WriteLine("Total Number of Employees who is not 'Associate' : " + countNotAssociate);

            // 9. Total number of employees based on city
            Console.WriteLine();
            Console.WriteLine("**************Question-9**********");
            Console.WriteLine();
            Employee.Linq9(empList);

            // 10. Total number of employees based on city and title
            Console.WriteLine();
            Console.WriteLine("**************Question-10**********");
            Console.WriteLine();
            Employee.Linq10(empList);

            // 11. Display youngest employee(s) details and count
            Console.WriteLine();
            Console.WriteLine("**************Question-11**********");
            Console.WriteLine();
            Employee.Linq11(empList);


            Console.ReadLine();
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
            Console.WriteLine("{0,-8} {1,-12} {2,-12} {3,-14} {4,-12} {5,-12} {6,-10}", "EmpID", "FirstName", "LastName", "Title", "DOB", "DOJ", "City");

            Console.WriteLine("----------------------------------------------------------------------------------------------------------------------");


            foreach (var e in employeeList)
            {
                Console.WriteLine("{0,-8} {1,-12} {2,-12} {3,-14} {4,-12} {5,-12} {6,-10}", e.EmployeeID, e.FirstName, e.LastName, e.Title, e.DOB.ToString("dd/MM/yyyy"), e.DOJ.ToString("dd/MM/yyyy"), e.City);
            }
        }

        //Linq-1

        public static IEnumerable<Employee> Linq1(IEnumerable<Employee> employees)
        {
            DateTime cutoffDate = new DateTime(2015, 1, 1);
            return employees.Where(emp => emp.DOJ < cutoffDate);
        }

        //Linq-2

        public static IEnumerable<Employee> Linq2(IEnumerable<Employee> employees)
        {
            DateTime cutoff = new DateTime(1990, 1, 1);
            return employees.Where(emp => emp.DOB > cutoff);
        }

        //Linq-3

        public static IEnumerable<Employee> Linq3(IEnumerable<Employee> employees)
        {
            return employees.Where(emp => emp.Title == "Consultant" || emp.Title == "Associate");
        }

        //Linq-4

        public static void Linq4(IEnumerable<Employee> employees)
        {
            int count = employees.Count();
            Console.WriteLine("Total number of Employees : " + count);
        }

        //linq-5

        public static void Linq5(IEnumerable<Employee> employees)
        {
            int count = employees.Count(emp => emp.City == "Chennai");
            Console.WriteLine("Total number of employees in Chennai : " + count);
        }

        //linq-6

        public static IEnumerable<Employee> Linq6(IEnumerable<Employee> employees)
        {
            int highestId = employees.Max(emp => emp.EmployeeID);
            return employees.Where(emp => emp.EmployeeID == highestId);
        }

        //linq-7

        public static int Linq7(IEnumerable<Employee> employees)
        {
            DateTime cutoff = new DateTime(2015, 1, 1);
            return employees.Count(emp => emp.DOJ > cutoff);
        }

        //linq-8

        public static int linq8(IEnumerable<Employee> employees)
        {
            return employees.Count(emp => !string.Equals(emp.Title, "Associate", StringComparison.OrdinalIgnoreCase));
        }

        //linq-9
        public static void Linq9(IEnumerable<Employee> employees)
        {
            var cityGroup = employees.GroupBy(emp => emp.City).Select(g => new { City = g.Key, Count = g.Count() });

            Console.WriteLine("Total number of employees based on City:");
            foreach (var group in cityGroup)
            {
                Console.WriteLine($"{group.City}: {group.Count}");
            }
        }

        //linq-10

        public static void Linq10(IEnumerable<Employee> employees)
        {
            var grouped = employees.GroupBy(emp => new { emp.City, emp.Title })
                .Select(g => new { g.Key.City, g.Key.Title, Count = g.Count() });

            Console.WriteLine("\nTotal number of employees based on City and Title:");
            foreach (var group in grouped)
            {
                Console.WriteLine($"{group.City} - {group.Title}: {group.Count}");
            }
        }

        //linq-11
        public static void Linq11(IEnumerable<Employee> employees)
        {
            DateTime maxDOB = employees.Max(emp => emp.DOB);

            var youngestEmployees = employees.Where(emp => emp.DOB == maxDOB);

            Console.WriteLine("\nYoungest Employee(s):");
            Display(youngestEmployees);

            Console.WriteLine($"Total number of youngest employee(s): {youngestEmployees.Count()}");
        }
    }
}






