

// Copyright Shunsuke Sogame 2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package ngltest


import com.github.okomok.ngl


class FindTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial {
        val xs: ngl.Seq[Int] = ngl.Seq.from(Array(1,2,3,4,5))
        val i = ngl.find(xs, xs.begin, xs.end)(3)
        expect(2)(i)
    }

    def testNotFound {
        val xs: ngl.Seq[Int] = ngl.Seq.from(Array(1,2,3,4))
        val i = ngl.find(xs, xs.begin, xs.end)(9)
        expect(4)(i)
    }

    def testEmptyNotFound {
        val xs: ngl.Seq[Int] = ngl.Seq.from(Array[Int]())
        val i = ngl.find(xs, xs.begin, xs.end)(9)
        expect(0)(i)
    }

}


class FindIfTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial {
        val xs: ngl.Seq[Int] = ngl.Seq.from(Array(1,2,3,4,5))
        val i = ngl.find_if(xs, xs.begin, xs.end)(_ == 3)
        expect(2)(i)
    }

    def testNotFound {
        val xs: ngl.Seq[Int] = ngl.Seq.from(Array(1,2,3,4))
        val i = ngl.find_if(xs, xs.begin, xs.end)(_ == 9)
        expect(4)(i)
    }

    def testEmptyNotFound {
        val xs: ngl.Seq[Int] = ngl.Seq.from(Array[Int]())
        val i = ngl.find_if(xs, xs.begin, xs.end)(_ == 9)
        expect(0)(i)
    }

}