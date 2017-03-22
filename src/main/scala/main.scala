import anonymousFunctionsExamples.AnonymousFunctionsExamples
import collectionsExamples.CollectionsExamples
import extractorsExamples.ExtractorsExamples
import filesInputOutput.FilesInputOutput
import futuresExamples.{FuturesExamples3, FuturesExamples2, FuturesExamples}
import patterMatchingExamples.PatterMatchingExamples
import traitExamples.traitExamples

object Main extends App {
  println("personal study of Scala")

  //new CollectionsExamples().runExamplesCollections
  //new traitExamples().runTraitExamples
  //new PatterMatchingExamples().runPatterMatchingExamples
  //new ExtractorsExamples().runextractorsExamples
  //new FilesInputOutput().runFilesInputOutput
  //new AnonymousFunctionsExamples().runAnonymousFunctions()
  //new FuturesExamples().runFutures
  //new FuturesExamples2().runFutures2
  new FuturesExamples3().runFutures3
}