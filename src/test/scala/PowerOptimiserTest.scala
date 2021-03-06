import optimisers.Optimiser

import collection.mutable.Stack
import org.scalatest._


class PowerOptimiserTest extends FlatSpec with Matchers {

  val powerOptimiser: Optimiser = new Optimiser
  val testScenarios: TestScenarios = new TestScenarios{}

  "optimise" should "return Result containing a list of Transmitters0" in {
    powerOptimiser.optimise(testScenarios.testScenarios(0).scenario) should be (testScenarios.testScenarios(0).expectedResult)
  }

  "optimise" should "return Result containing a list of Transmitters1" in {
    powerOptimiser.optimise(testScenarios.testScenarios(1).scenario) should be (testScenarios.testScenarios(1).expectedResult)
  }

  "optimise" should "return Result containing a list of Transmitters2" in {
    powerOptimiser.optimise(testScenarios.testScenarios(2).scenario) should be (testScenarios.testScenarios(2).expectedResult)
  }

  "optimise" should "return Result containing a list of Transmitters3" in {
    powerOptimiser.optimise(testScenarios.testScenarios(3).scenario) should be (testScenarios.testScenarios(3).expectedResult)
  }

  "optimse" should "return Result containing a list of Transmitters4" in {
    powerOptimiser.optimise(testScenarios.testScenarios(4).scenario) should be (testScenarios.testScenarios(4).expectedResult)
  }

  "optimise" should "return Result containing a list of Transmitters5" in {
    powerOptimiser.optimise(testScenarios.testScenarios(5).scenario) should be (testScenarios.testScenarios(5).expectedResult)
  }

  "optimise" should "return Result containing a list of Transmitters6" in {
    powerOptimiser.optimise(testScenarios.testScenarios(6).scenario) should be (testScenarios.testScenarios(6).expectedResult)
  }
}
