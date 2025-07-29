

public static void DisplayCountByCity(IEnumerable<Employee> employees)
{
    var cityGroup = employees
        .GroupBy(emp => emp.City)
        .Select(g => new { City = g.Key, Count = g.Count() });

    Console.WriteLine("Total number of employees based on City:");
    foreach (var group in cityGroup)
    {
        Console.WriteLine($"{group.City}: {group.Count}");
    }
}


public static void DisplayCountByCityAndTitle(IEnumerable<Employee> employees)
{
    var grouped = employees
        .GroupBy(emp => new { emp.City, emp.Title })
        .Select(g => new { g.Key.City, g.Key.Title, Count = g.Count() });

    Console.WriteLine("\nTotal number of employees based on City and Title:");
    foreach (var group in grouped)
    {
        Console.WriteLine($"{group.City} - {group.Title}: {group.Count}");
    }
}


public static void DisplayYoungestEmployees(IEnumerable<Employee> employees)
{
    DateTime maxDOB = employees.Max(emp => emp.DOB);

    var youngestEmployees = employees.Where(emp => emp.DOB == maxDOB);

    Console.WriteLine("\nYoungest Employee(s):");
    Display(youngestEmployees);

    Console.WriteLine($"Total number of youngest employee(s): {youngestEmployees.Count()}");
}


static void Main(string[] args)
{
    var empList = ListEmployees();

    Employee.Display(empList);

    // 9. Total number of employees based on city
    Employee.DisplayCountByCity(empList);

    // 10. Total number of employees based on city and title
    Employee.DisplayCountByCityAndTitle(empList);

    // 11. Display youngest employee(s) details and count
    Employee.DisplayYoungestEmployees(empList);

    Console.Read();
}










   
