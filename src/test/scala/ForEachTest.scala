

// Copyright Shunsuke Sogame 2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package ngltest


import com.github.okomok.ngl


class ForEachTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial {
        val xs: ngl.Seq[Int] = ngl.Seq.from(Array(1,2,3,4,5))
        val out = new java.util.ArrayList[Int]
        ngl.for_each(xs, xs.begin, xs.end) { (x: Int) =>
            out.add(x)
        }
        expect(ngl.toJList(xs))(out)
    }

    def testEmpty {
        val xs: ngl.Seq[Int] = ngl.Seq.from(Array[Int]())
        val out = new java.util.ArrayList[Int]
        ngl.for_each(xs, xs.begin, xs.end) { (x: Int) =>
            out.add(x)
        }
        assert(out.isEmpty)
    }

}