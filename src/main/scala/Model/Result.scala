package Model

case class Result(transmitters: List[Transmitter]){

  def getTotalPower(): Int = {
    transmitters.map(_.power).sum
  }
}
