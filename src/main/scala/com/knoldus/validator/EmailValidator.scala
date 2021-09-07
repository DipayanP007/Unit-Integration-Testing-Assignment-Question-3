package com.knoldus.validator

class EmailValidator {

  def emailIdIsValid(emailId: String): Boolean = {

    if (checkAtTheRate(emailId) && recipientName(emailId) && domainName(emailId) && topLevelDomain(emailId))
     return true

    false

}

def checkAtTheRate (emailId: String): Boolean = {
  for (i <- 0 until emailId.length)
  if (emailId.charAt (i) == '@')
  return true
  false
  }

  def recipientName (emailId: String): Boolean = {
  var index = 0
  while (emailId.charAt (index) != '@') {
  if (emailId.charAt (index) == '.') return true

  if (! Character.isLetterOrDigit (emailId.charAt (index) ) ) return false
  index = index + 1
  }
  true
  }

  def domainName (emailId: String): Boolean = {

  if (! checkAtTheRate (emailId) ) return false
  var index = emailId.indexOf ("@") + 1
  while (emailId.charAt (index) != '.') {
  if (! Character.isLetterOrDigit (emailId.charAt (index) ) ) return false
  index = index + 1
  }
  true
  }

  def topLevelDomain (emailId: String): Boolean = {

  if (! checkAtTheRate (emailId) ) return false
  val index = emailId.indexOf (".")
  val toplevelDomain = emailId.substring (index)
  if (toplevelDomain.equals (".com") || toplevelDomain.equals (".net") || toplevelDomain.equals (".org") || toplevelDomain.equals (".co.in"))
  return true
  false

  }
  }
