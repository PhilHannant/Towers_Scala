import Model.{Point, Receiver, Transmitter}
import optimisers.Optimiser

import collection.mutable.Stack
import org.scalatest._


class UtilityTest extends FlatSpec with Matchers {

  val powerOptimiser: Optimiser = new Optimiser
  val testScenarios: TestScenarios = new TestScenarios{}

  "calculateChebyshev" should "take two points and return an Int" in {
    powerOptimiser.calculateChebyshev(Point(2, 4), Point(0, 6)) should be (2)
  }

  "outOfRangeCheck" should "take a transmitter and a receiver and return a boolean" in {
    powerOptimiser.outOfRangeCheck(Transmitter(1, Point(1, 0), 1), Receiver(1, Point(2, 3))) should be (true)
  }
}
