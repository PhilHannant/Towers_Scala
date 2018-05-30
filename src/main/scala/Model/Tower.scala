package Model

sealed trait Tower {
  val id: Int
  val location: Point
}

case class Transmitter(id: Int, location: Point) extends Tower
case class Receiver(id: Int, location: Point) extends Tower