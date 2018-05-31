import Model.Point
import optimisers.Optimiser

import collection.mutable.Stack
import org.scalatest._


class UtilityTest extends FlatSpec with Matchers {

  val powerOptimiser: Optimiser = new Optimiser
  val testScenarios: TestScenarios = new TestScenarios{}

  "calculateChebyshev" should "take two points and return an Int" in {
    powerOptimiser.calculateChebysev(Point(2, 4), Point(0, 6)) should be (2)
  }

}
