package optimisers
import Model._

class Optimiser extends PowerOptimiser {

  override def optimise(scenario: Scenario): Result = {
    val hypothesis: List[List[Transmitter]] =
      List(getClosetTransmiters(scenario))::: List(List(findCheapestDistanceToRange(scenario.transmitters,
        getOutOfRangeReceivers(scenario.transmitters, scenario.receivers))))
    Result(buildFinalList(scenario.transmitters, getMostEffcient(hypothesis, hypothesis(0))))
  }

  def buildFinalList(transmitters: List[Transmitter], updated: List[Transmitter]): List[Transmitter] = {
    def buildFinalListHelper(t: List[Transmitter], u: List[Transmitter], greatest: List[Transmitter]): List[Transmitter] =
      t match {
        case x :: xs => if(u.map(_.id).contains(x.id)) {
          buildFinalListHelper(xs, u, greatest ::: List(getListItem(x.id, u, null)))
        } else {
          buildFinalListHelper(xs, u, greatest ::: List(x))
        }
        case Nil => greatest
      }
    buildFinalListHelper(transmitters, updated, Nil)
  }


  def getListItem(id: Int, u: List[Transmitter], item: Transmitter): Transmitter = u match {
    case x :: xs => if(x.id == id) {
      getListItem(id, Nil, x)
    } else {
      getListItem(id, xs, item)
    }
    case Nil => item
  }

  def getMostEffcient(hypotheses: List[List[Transmitter]], result: List[Transmitter]): List[Transmitter] =
    hypotheses match {
      case x :: xs =>
        if(x.map(_.power).sum < result.map(_.power).sum){
          getMostEffcient(xs, x)
      } else {
          getMostEffcient(xs, result)
      }
      case Nil => result
  }

  def calculateChebyshev(p1: Point, p2: Point): Int = {
    Math.max(Math.abs(p1.x - p2.x), Math.abs(p1.y - p2.y))
  }

  def outOfRangeCheck(t: Transmitter, r: Receiver): Boolean = {
    calculateChebyshev(t.location, r.location) - t.power > 0
  }

  def distanceToRange(t: Transmitter, r: Receiver): Int = {
    Math.abs(calculateChebyshev(t.location, r.location) - t.power)
  }

  def checkReceiver(transmitters: List[Transmitter], r: Receiver): Boolean = {
    transmitters.forall(t => outOfRangeCheck(t, r))
  }

  def getOutOfRangeReceivers(transmitters: List[Transmitter], receivers: List[Receiver]): List[Receiver] = {
      receivers.filter(r => checkReceiver(transmitters, r))
  }

  def getClosetTransmiters(scenario: Scenario): List[Transmitter] = {
    val receivers = getOutOfRangeReceivers(scenario.transmitters, scenario.receivers)

    def updateTransmittersHelper(t: List[Transmitter], r: List[Receiver], updated: List[Transmitter]): List[Transmitter] =
      r match {
        case x :: xs => updateTransmittersHelper(t, xs, updated ::: List(getClosestTransmitter(t, x)))
        case Nil => updated
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

  def findCheapestDistanceToRange(transmitters: List[Transmitter], outOfRange: List[Receiver]): Transmitter = {
    def findCheapestDistanceToRangeHelper(t: List[Transmitter], r: List[Receiver], greatest: Transmitter): Transmitter =
      t match {
        case x :: xs => if(findMinDistance(x, r) < findMinDistance(greatest, r)) {
          findCheapestDistanceToRangeHelper(xs, r, x)
        } else {
          findCheapestDistanceToRangeHelper(xs, r, greatest)
        }
        case Nil => Transmitter(greatest.id, greatest.location, greatest.power + findMinDistance(greatest, r))
      }
    findCheapestDistanceToRangeHelper(transmitters, outOfRange, transmitters(0))
  }

  def findMinDistance(t: Transmitter, r: List[Receiver]) = {
    r.map(r => distanceToRange(t, r)).max
  }

  def rangeCheck(transmitter: Transmitter, outOfRange: List[Receiver]): Boolean = {
    if(getOutOfRangeReceivers(List(transmitter), outOfRange).isEmpty) true
    else false
  }
}
