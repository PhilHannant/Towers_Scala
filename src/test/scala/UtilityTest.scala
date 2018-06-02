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
    powerOptimiser.outOfRangeCheck(Transmitter(1, Point(1, 0), 1), Receiver(1, Point(2, 3)))should be
    true
  }

  "outOfRangeReceivers" should "take a list of transmitters and receivers and return a list of receviers" in {
    powerOptimiser.getOutOfRangeReceivers(testScenarios.testScenarios(6).scenario.transmitters,
      testScenarios.testScenarios(6).scenario.receivers) should contain theSameElementsAs
    List(Receiver(1, Point(1,2)), Receiver(2, Point(5,2)))
  }

  "getClosestTransmitters" should "take a scenario and return a list of Transmitters" in {
    powerOptimiser.getClosetTransmiters(testScenarios.testScenarios(6).scenario) should contain theSameElementsAs
    List(Transmitter(2,  Point(1, 0), 2),
        Transmitter(3,  Point(5, 0), 2))
  }

  "findMaxDistance" should "take a list of transmitters and a receiver and return an int" in {
    powerOptimiser.findMaxDistance(Transmitter(3,  Point(22, 21), 3),
      powerOptimiser.getOutOfRangeReceivers(
        testScenarios.testScenarios(4).scenario.transmitters,
        testScenarios.testScenarios(4).scenario.receivers)) should be (19)
  }

  "findGreatestDistanceToRange" should "take a list of transmitters and receivers and return a Transmitter" in {
    powerOptimiser.findGreatestDistanceToRange(testScenarios.testScenarios(4).scenario.transmitters,
      testScenarios.testScenarios(4).scenario.receivers) should be (Transmitter(6,  Point(16, 19), 20))
  }
}
