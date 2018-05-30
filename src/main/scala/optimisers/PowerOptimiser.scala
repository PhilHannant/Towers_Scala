package optimisers

import Model.{Result, Scenario}

trait PowerOptimiser {
  def optimise(scenario: Scenario): Result
}
