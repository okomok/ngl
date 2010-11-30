

// Copyright Shunsuke Sogame 2010.
// Distributed under the terms of an MIT-style license.


/*
 *
 * Copyright (c) 1994
 * Hewlett-Packard Company
 *
 * Copyright (c) 1996,1997
 * Silicon Graphics Computer Systems, Inc.
 *
 * Copyright (c) 1997
 * Moscow Center for SPARC Technology
 *
 * Copyright (c) 1999
 * Boris Fomitchev
 *
 * This material is provided "as is", with absolutely no warranty expressed
 * or implied. Any use is at your own risk.
 *
 * Permission to use or copy this software for any purpose is hereby granted
 * without fee, provided the above notices are retained on all copies.
 * Permission to modify the code and to distribute modified code is granted,
 * provided the above notices are retained, and a notice that the code was
 * modified is included with the above copyright notice.
 *
 */


package com.github.okomok
package ngltest


import com.github.okomok.ngl


class BoundTest extends org.scalatest.junit.JUnit3Suite {

    def testUpperBound1 {
        val arr = new Array[Int](20)
        for (i <- 0 until 20) {
            arr(i) = i/4
        }
        val _arr = ngl.Seq.from(arr)
        val location = ngl.upper_bound(_arr, _arr.begin, _arr.end)(3) - _arr.begin
        expect(16)(location)
    }

   def testUpperBound2 {
        val str = Array("a", "a", "b", "b", "q", "w", "z")
        val _str = ngl.Seq.from(str)
        val location = ngl.upper_bound(_str, _str.begin, _str.end)("d") - _str.begin
        expect(4)(location)
    }

    def testLowerBound1 {
        val arr = new Array[Int](20)
        for (i <- 0 until 20) {
            arr(i) = i/4
        }
        val _arr = ngl.Seq.from(arr)
        val location = ngl.lower_bound(_arr, _arr.begin, _arr.end)(3) - _arr.begin
        expect(12)(location)
    }

   def testLowerBound2 {
        val str = Array("a", "a", "b", "b", "q", "w", "z")
        val _str = ngl.Seq.from(str)
        val location = ngl.lower_bound(_str, _str.begin, _str.end)("d") - _str.begin
        expect(4)(location)
    }
}