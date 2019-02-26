package funsets

object Main extends App {
  import FunSets._

  val aSet = singletonSet(1)
  printSet(aSet)
  print(contains(aSet, 1));
}
