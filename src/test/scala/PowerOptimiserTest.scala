import optimisers.Optimiser

import collection.mutable.Stack
import org.scalatest._


class PowerOptimiserTest extends FlatSpec with Matchers {

  val powerOptimiser: Optimiser = new Optimiser
  val testScenarios: TestScenarios = new TestScenarios{}

  "a testSceanrio" should "return Result containing a list of Transmitters" in {
    powerOptimiser.optimise(testScenarios.testScenarios(0).scenario) should be (testScenarios.testScenarios(0).expectedResult)
  }

}
