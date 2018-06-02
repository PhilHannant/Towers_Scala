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

  def checkReceiver(transmitters: List[Transmitter], r: Receiver): Boolean =
    transmitters match {
      case x :: xs =>
        if(!outOfRangeCheck(x, r)){
          checkReceiver(xs, r)
        } else {
          true
        }
      case Nil => false
  }

  def getOutOfRangeReceivers(transmitters: List[Transmitter], receivers: List[Receiver]): List[Receiver] = {
      receivers.filter(r => checkReceiver(transmitters, r))
  }

  def getClosetTransmiters(scenario: Scenario): List[Transmitter] = {
    val receivers = getOutOfRangeReceivers(scenario.transmitters, scenario.receivers)

    def updateTransmittersHelper(t: List[Transmitter], r: List[Receiver], updated: List[Transmitter]): List[Transmitter] =
      r match {
        case x :: xs => updateTransmittersHelper(t, xs, updated ::: List(getClosestTransmitter(t, x)))
        case Nil => println(updated); updated
      }

    updateTransmittersHelper(scenario.transmitters, scenario.receivers, Nil)
  }

  def getClosestTransmitter(transmitters: List[Transmitter], receiver: Receiver) = {

    def closestTransmitterHelper(t: List[Transmitter], r: Receiver, closest: Transmitter): Transmitter = t match {
      case x :: xs =>
        if (distanceToRange(x, r) < distanceToRange(closest, r))
        closestTransmitterHelper(xs, r, x)
        else closestTransmitterHelper(xs, r, closest)
      case Nil => Transmitter(closest.id, closest.location, closest.power + distanceToRange(closest, r))
    }

    closestTransmitterHelper(transmitters, receiver, transmitters(0))
  }

  def findGreatestDistanceToRange(transmitters: List[Transmitter], outOfRange: List[Receiver]): Transmitter = {
    def findGreatestDistanceToRangeHelper(t: List[Transmitter], r: List[Receiver], greatest: Transmitter): Transmitter =
      t match {
        case x :: xs => if(findMaxDistance(x, r) < findMaxDistance(greatest, r)) {
          findGreatestDistanceToRangeHelper(xs, r, x)
        } else {
          findGreatestDistanceToRangeHelper(xs, r, greatest)
        }
        case Nil => Transmitter(greatest.id, greatest.location, greatest.power )
      }
    findGreatestDistanceToRangeHelper(transmitters, outOfRange, transmitters(0))
  }

  def findMaxDistance(t: Transmitter, r: List[Receiver]) = {
    r.map(r => distanceToRange(t, r)).max
  }

}
