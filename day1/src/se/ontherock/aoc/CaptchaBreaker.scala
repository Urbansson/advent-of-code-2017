package se.ontherock.aoc

import scala.io.Source

object CaptchaBreaker{
  def main(args: Array[String]): Unit = {
    if(args.length < 1){
      println("Expected path to input")
      return;
    }

    val input = readFile(args.head);
    println(solve(input))
    println(solve(input,input.length/2))
  }

  def readFile(filename: String): String = {
    Source.fromFile(filename).getLines().mkString
  }

  //Generic solution
  def solve(input: String, offset: Int = 1): Int ={
    val length = input.length
    val index = input.zipWithIndex
    index
      .filter(i => i._1 == index((offset + i._2) % length)._1)
      .map(_._1.asDigit)
      .sum
  }

  //Part 1 solution
  /*
    def solve(input: String): Int ={
    (input :+ input.head)
      .sliding(2)
      .filter(_.distinct.size == 1)
      .map(_.head.asDigit)
      .sum
  }
  */
}