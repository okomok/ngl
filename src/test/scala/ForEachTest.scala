

// Copyright Shunsuke Sogame 2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package ginetest


import com.github.okomok.gine


class ForEachTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial {
        val xs: gine.Seq[Int] = gine.Seq.from(Array(1,2,3,4,5))
        val out = new java.util.ArrayList[Int]
        gine.for_each(xs, xs.begin, xs.end) { (x: Int) =>
            out.add(x)
        }
        expect(gine.toJList(xs))(out)
    }

    def testEmpty {
        val xs: gine.Seq[Int] = gine.Seq.from(Array[Int]())
        val out = new java.util.ArrayList[Int]
        gine.for_each(xs, xs.begin, xs.end) { (x: Int) =>
            out.add(x)
        }
        assert(out.isEmpty)
    }

}