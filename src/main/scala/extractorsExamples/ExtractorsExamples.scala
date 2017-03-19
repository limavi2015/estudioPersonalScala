package extractorsExamples

class ExtractorsExamples {
  def runextractorsExamples={
    println("*** Extractors ***")
    println ("Apply method : " + apply("Zara", "gmail.com"));
    println ("Unapply method : " + unapply("Zara@gmail.com"));
    println ("Unapply method : " + unapply("Zara Ali"));
  }

  private def apply(user: String, domain: String) = {
    user +"@"+ domain
  }

  private def unapply(str: String): Option[(String, String)] = {
    val parts = str split "@"

    if (parts.length == 2){
      Some(parts(0), parts(1))
    } else {
      None
    }
  }
}
