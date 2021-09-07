package com.knoldus.validator

import com.knoldus.models.Employee
import com.knoldus.db.CompanyReadDto

class EmployeeValidator {

  def employeeIsValid(employee: Employee): Boolean = {

    val database_object = new CompanyReadDto
    val companyName = database_object.getCompanyByName(employee.companyName)
    val emailValidator_object = new EmailValidator
    val emailValidator = emailValidator_object.emailIdIsValid(employee.emailId)
    if(emailValidator && companyName != None)
      return true
    false
  }
}
