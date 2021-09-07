package com.knoldus.validator

import com.knoldus.models.Company
import com.knoldus.db._

class CompanyValidator {

  def companyIsValid(company: Company): Boolean = {

    val database_object = new CompanyReadDto
    val companyExist = database_object.getCompanyByName(company.name)

    val emailValidator = new EmailValidator
    val checkEmail = emailValidator.emailIdIsValid(company.emailId)
    if (checkEmail && companyExist == None)
      return true
    false

  }
}
