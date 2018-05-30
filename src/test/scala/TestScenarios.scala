import Model._

abstract class TestScenarios {

  val testScenarios = List(
    TestScenario(
      Scenario(
        List(
          Transmitter(1, Point(0, 0), 1)
        ),
        List(
          Receiver(1,  Point(0, 2))
        )
      ),
       Result(
         List(
           Transmitter(1,  Point(0, 0), 2)
         )
       )
    ),
     TestScenario(
       Scenario(
        List(
          Transmitter(1,  Point(0, 0), 1),
          Transmitter(2,  Point(0, 6), 2)
        ),
        List(
           Receiver(1,  Point(0, 3)))
      ),
       Result(
        List(
          Transmitter(1,  Point(0, 0), 1),
          Transmitter(2,  Point(0, 6), 3))
       )
     ),
     TestScenario(
       Scenario(
         List(
           Transmitter(1,  Point(2, 4), 1),
           Transmitter(2,  Point(0, 6), 3),
           Transmitter(3,  Point(1, 2), 2),
           Transmitter(4,  Point(3, 5), 3)),
         List(
           Receiver(1,  Point(0, 1)),
           Receiver(2,  Point(8, 8)),
           Receiver(3,  Point(6, 5)))),
       Result(
         List(
           Transmitter(1,  Point(2, 4), 1),
           Transmitter(2,  Point(0, 6), 3),
           Transmitter(3,  Point(1, 2), 2),
           Transmitter(4,  Point(3, 5), 5)))),
     TestScenario(
       Scenario(
         List(
           Transmitter(1,  Point(12, 12), 1),
           Transmitter(2,  Point(12, 1), 1),
           Transmitter(3,  Point(12, 23), 1),
           Transmitter(4,  Point(1, 12), 1),
           Transmitter(5,  Point(23, 12), 1)),
         List(
           Receiver(1,  Point(12, 6)),
           Receiver(2,  Point(6, 12)),
           Receiver(3,  Point(18, 12)),
           Receiver(4,  Point(12, 18)))),
       Result(
         List(
           Transmitter(1,  Point(12, 12), 6),
           Transmitter(2,  Point(12, 1), 1),
           Transmitter(3,  Point(12, 23), 1),
           Transmitter(4,  Point(1, 12), 1),
           Transmitter(5,  Point(23, 12), 1))
       )
     ),
     TestScenario(
       Scenario(
         List(
           Transmitter(1,  Point(18, 23), 2),
           Transmitter(2,  Point(34, 30), 4),
           Transmitter(3,  Point(22, 21), 3),
           Transmitter(4,  Point(13, 14), 2),
           Transmitter(5,  Point(32, 27), 4),
           Transmitter(6,  Point(16, 19), 3)
         ),
         List(
           Receiver(1,  Point(8, 37)),
           Receiver(2,  Point(6, 27)),
           Receiver(3,  Point(35, 18)),
           Receiver(4,  Point(36, 8)),
           Receiver(5,  Point(5, 1)),
           Receiver(6,  Point(12, 22)),
           Receiver(7,  Point(0, 19)),
           Receiver(8,  Point(3, 16)))
       ),
       Result(
         List(
           Transmitter(1,  Point(18, 23), 2),
           Transmitter(2,  Point(34, 30), 4),
           Transmitter(3,  Point(22, 21), 3),
           Transmitter(4,  Point(13, 14), 2),
           Transmitter(5,  Point(32, 27), 4),
           Transmitter(6,  Point(16, 19), 20)))),
     TestScenario(
       Scenario(
         List(
           Transmitter(1,  Point(2, 5), 1),
           Transmitter(2,  Point(0, 6), 3),
           Transmitter(3,  Point(1, 2), 2),
           Transmitter(4,  Point(6, 8), 1)),
         List(
           Receiver(1,  Point(0, 1)),
           Receiver(2,  Point(9, 8)),
           Receiver(3,  Point(6, 5)))),
       Result(
         List(
           Transmitter(1,  Point(2, 5), 1),
           Transmitter(2,  Point(0, 6), 3),
           Transmitter(3,  Point(1, 2), 2),
           Transmitter(4,  Point(6, 8), 3))
       )
     ),
     TestScenario(
       Scenario(
         List(
           Transmitter(1,  Point(1, 6), 1),
           Transmitter(2,  Point(1, 0), 1),
           Transmitter(3,  Point(5, 0), 1)),
         List(
           Receiver(1,  Point(1, 2)),
           Receiver(2,  Point(5, 2))
         )
       ),
       Result(
         List(
           Transmitter(1,  Point(1, 6), 1),
           Transmitter(2,  Point(1, 0), 2),
           Transmitter(3,  Point(5, 0), 2)
         )
       )
     )

  )
}
