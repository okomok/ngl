

// Copyright Shunsuke Sogame 2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package ngltest


import com.github.okomok.ngl


class AccumulateTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial {
        val xs: ngl.Seq[Int] = ngl.Seq(1,2,3,4,5)
        val i = ngl.accumulate(xs, xs.begin, xs.end)("0") { (b, a) =>
            (a + 90).toString + b
        }
        expect("95949392910")(i)
    }

}