package validatorTest

import org.scalatest.funsuite.AnyFunSuite
import com.knoldus.models.Employee
import com.knoldus.validator.EmployeeValidator
class EmployeeValidatorTest extends AnyFunSuite{

  val employeeOneDavid = Employee("Mark", "David", 32,50000, "Software Consultant", "Knoldus", "markdavid123@gmail.com" )
  val employeeTwoLeo = Employee("Leo", "Gill", 26,30000, "Software Trainee", "Philips", "gillleo@gmail.com" )
  val employeeThreeSimon = Employee("Simon", "Cowell", 43,65000, "Sr. Software Consultant", "TCS", "cowellSimon43@gmail.com" )
  val employeeFourSam = Employee("Sam", "Rogers", 22,25000, "Software Trainee", "Knoldus", "rogerssam21?@gmail.com" )


  test("Checking if Employee- employeeOneDavid working in Knoldus(company present in Database) is a valid Employee"){
    val expectResult = true
    val result = (new EmployeeValidator).employeeIsValid(employeeOneDavid)
    assert(expectResult == result)
  }


  test("Checking if Employee- employeeTwoLeo working in Philips(company present in Database) is a valid Employee"){

    val expectResult = true
    val result = (new EmployeeValidator).employeeIsValid(employeeTwoLeo)
    assert(expectResult == result)
  }


  test("Checking if Employee- employeeThreeSimon working in company TCS(company not present in Database) is thus an invalid Employee"){

    val expectResult = false
    val result = (new EmployeeValidator).employeeIsValid(employeeThreeSimon)
    assert(expectResult == result)
  }

  test("Checking if Employee- employeeFourSam working in Knoldus(company present in Database) having invalid Email ID is thus an invalid Employee"){
    val expectResult = false
    val result = (new EmployeeValidator).employeeIsValid(employeeFourSam)
    assert(expectResult == result)
  }

}
