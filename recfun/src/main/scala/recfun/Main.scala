package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
    * Exercise 1
    */
  def pascal(c: Int, r: Int): Int = {
    if (0 == c || c == r) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
    * Exercise 2
    */
  def balance(chars: List[Char]): Boolean = {
    def loop(chars: List[Char], nbOpenParenthese: Int): Boolean = {
      if (chars.isEmpty) 0 == nbOpenParenthese
      else if (chars.head == '(') loop(chars.tail, nbOpenParenthese + 1)
      else if (chars.head == ')') nbOpenParenthese > 0 && loop(chars.tail, nbOpenParenthese - 1)
      else loop(chars.tail, nbOpenParenthese)
    }

    loop(chars, 0)
  }

  /**
    * Exercise 3
    */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (0 > money || coins.isEmpty) 0
    else if (0 == money) 1
    // money = N, coins = List(S1, S2, ..., Sm)
    // C(N,m) = C(N, m - 1) + C(N - Sm, m)
    else countChange(money, coins.tail) + countChange(money - coins.head, coins)
  }
}
