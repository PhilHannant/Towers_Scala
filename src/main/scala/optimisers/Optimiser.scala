package optimisers
import Model.{Point, Result, Scenario}

class Optimiser extends PowerOptimiser {

  override def optimise(scenario: Scenario): Result = ???

  def calculateChebysev(p1: Point, p2: Point): Int = {
    Math.max(Math.abs(p1.x - p2.x), Math.abs(p1.y - p2.y))
  }

}
