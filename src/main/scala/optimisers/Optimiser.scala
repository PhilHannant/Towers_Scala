package optimisers
import Model._

class Optimiser extends PowerOptimiser {

  override def optimise(scenario: Scenario): Result = ???

  def calculateChebyshev(p1: Point, p2: Point): Int = {
    Math.max(Math.abs(p1.x - p2.x), Math.abs(p1.y - p2.y))
  }

  def outOfRangeCheck(t: Transmitter, r: Receiver): Boolean = {
    calculateChebyshev(t.location, r.location) - t.power > 0
  }

  def distanceToRange(t: Transmitter, r: Receiver): Int = {
    Math.abs(calculateChebyshev(t.location, r.location) - t.power)
  }

  def getOutOfRangeReceivers(transmitters: List[Transmitter], receivers: List[Receiver]): List[Receiver] = {
    match receivers{
      case x :: xs => ???
      case Nil => receivers
    }
  }
}
