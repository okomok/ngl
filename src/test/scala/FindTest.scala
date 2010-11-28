

// Copyright Shunsuke Sogame 2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package ginetest


import com.github.okomok.gine


class FindTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial {
        val xs: gine.Seq[Int] = gine.Seq.from(Array(1,2,3,4,5))
        val i = gine.find(xs, xs.begin, xs.end)(3)
        expect(2)(i)
    }

    def testNotFound {
        val xs: gine.Seq[Int] = gine.Seq.from(Array(1,2,3,4))
        val i = gine.find(xs, xs.begin, xs.end)(9)
        expect(4)(i)
    }

    def testEmptyNotFound {
        val xs: gine.Seq[Int] = gine.Seq.from(Array[Int]())
        val i = gine.find(xs, xs.begin, xs.end)(9)
        expect(0)(i)
    }

}