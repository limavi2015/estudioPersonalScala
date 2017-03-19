package filesInputOutput

import java.io.{PrintWriter, File}

import scala.io.Source

class FilesInputOutput {
  def runFilesInputOutput()={
    println("*** runFilesInputOutput ***")
    outPut
    input
  }

  private def outPut={
    val writer = new PrintWriter(new File("/home/lili/Descargas/test.txt" ))
    writer.write("Hello Scala, test to FilesInputOutput")
    writer.close()
  }

  private def input={
    println(Source.fromFile("/home/lili/Descargas/test.txt" ).mkString)
  }
}
