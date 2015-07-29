/*
Eric Tam
007989423
CS-152
RecursiontLab
*/object session {

	// PROBLEM 5
  def controlLoop[S](state: S, cycle: Int, halt: (S, Int) => Boolean, update: (S, Int) => S): S = {
    if (halt(state, cycle)) state
    else controlLoop(update(state,cycle), cycle+1, halt, update)
    
  }                                               //> controlLoop: [S](state: S, cycle: Int, halt: (S, Int) => Boolean, update: (S
                                                  //| , Int) => S)S

	// PROBLEM 6
	def halt(amount: Int, cycle: Int) = {
	if(amount > 100000) true
	else false
	}                                         //> halt: (amount: Int, cycle: Int)Boolean
	
	def update(amount: Int, cycle: Int) = {
	amount * 2
	}                                         //> update: (amount: Int, cycle: Int)Int
	
	controlLoop(1,0,halt,update)              //> res0: Int = 131072
	
	// PROBLEM 7
	def solve(f: Double=>Double) = {
		def stop(a: Double, cycle: Int) = Math.abs(f(a))<0.000001
		def up(amount: Double, cycle: Int) = {
		amount - (f(amount)/((f(amount+0.000001) - f(amount))/0.000001))
		}
		controlLoop(1.0,0,stop,up)
	}                                         //> solve: (f: Double => Double)Double
	
	// PROBBLEM 8
	def squareRoot(x: Double) = {
		def f(a: Double) = (a*a) - x
		solve(f)
	}                                         //> squareRoot: (x: Double)Double
	
	squareRoot(4)                             //> res1: Double = 2.0000000930780586
	squareRoot(100)                           //> res2: Double = 10.00000000014253
	squareRoot(2)                             //> res3: Double = 1.4142135623754424
	squareRoot(1)                             //> res4: Double = 1.0
	squareRoot(0)                             //> res5: Double = 9.77061926403101E-4
	
	
	// PROBLEM 9
	def cubeRoot(x: Double) = {
		def f(a: Double) = (a*a*a) - x
		solve(f)
	}                                         //> cubeRoot: (x: Double)Double
	
	cubeRoot(8)                               //> res6: Double = 2.0000000000145284
	cubeRoot(2)                               //> res7: Double = 1.2599210500277118
	cubeRoot(1000)                            //> res8: Double = 10.000000000000018
	cubeRoot(1)                               //> res9: Double = 1.0
	
	// PROBLEM 10
	def nthRoot(x: Double, n: Int) = {
		def f(a: Double) = (Math.pow(a,n)) - x
		solve(f)
	}                                         //> nthRoot: (x: Double, n: Int)Double
	
	nthRoot(1000,3)                           //> res10: Double = 10.000000000000016
	nthRoot(7,3)                              //> res11: Double = 1.9129311827732232
	nthRoot(1000000,6)                        //> res12: Double = 10.000000000000002
	nthRoot(-8,3)                             //> res13: Double = -2.0000000000059996
}