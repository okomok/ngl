

// Copyright Shunsuke Sogame 2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package ngltest


import com.github.okomok.ngl


class AdjacentFindTest extends org.scalatest.junit.JUnit3Suite {

    def test0 {
        val xs = ngl.Seq(1,2,4,8,16)
        val ys = ngl.Seq(5,3,2,1,1)
        val i = ngl.adjacent_find(xs, xs.begin, xs.end)
        expect(xs.end)(i)
        val j = ngl.adjacent_find(ys, ys.begin, ys.end)
        expect(xs.begin + 3)(j)
    }

}