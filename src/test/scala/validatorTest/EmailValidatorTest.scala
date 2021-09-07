package validatorTest

import com.knoldus.validator.EmailValidator
import org.scalatest.funsuite.AnyFunSuite

class EmailValidatorTest extends AnyFunSuite {

  val emailValidator_object = new EmailValidator
  test("Checking with a valid Email Id") {

    val expectedResult = true
    val result = emailValidator_object.emailIdIsValid("pramanikdipayan007@gmail.com")
    assert(expectedResult == result)
  }

  test("Checking if it returns false on passing an invalid Email Id without '@'") {

    val expectedResult = false
    val result = emailValidator_object.emailIdIsValid("pramanikdipayan007gmail.com")
    assert(expectedResult == result)
  }

  test("Checking if it returns false on passing an invalid Email Id with special characters in domain name") {

    val expectedResult = false
    val result = emailValidator_object.emailIdIsValid("pramanikdipayan007@g???mail.com")
    assert(expectedResult == result)
  }

  test("Checking if it returns false on passing an invalid Email Id with special characters in recipient's Name") {

    val expectedResult = false
    val result = emailValidator_object.emailIdIsValid("pramanik???dipayan007@gmail.com")
    assert(expectedResult == result)
  }

  test("Checking if it returns false on passing an invalid Email Id with invalid Top Level Domain") {

    val expectedResult = false
    val result = emailValidator_object.emailIdIsValid("pramanikdipayan007@gmail.cam")
    assert(expectedResult == result)
  }
}
