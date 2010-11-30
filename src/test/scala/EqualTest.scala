

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


class EqualTest extends org.scalatest.junit.JUnit3Suite {

    def testEqual0 {
        val numbers1 = Array(1, 2, 3, 4, 5)
        val numbers2 = Array(1, 2, 4, 8, 16)
        val numbers3 = Array(1, 2)

        assert( !ngl.equal(numbers1, 0, 5)(numbers2, 0) )
        assert( ngl.equal(numbers3, 0, 2)(numbers1, 0) )
    }

    def testEqualIf0 {
        val numbers1 = new Array[Int](10)
        val numbers2 = new Array[Int](10)
        for (i <- 0 until 10) {
            numbers1(i) = i
            numbers2(i) = i * i
        }

        assert( ngl.equal_if(numbers1, 0, 5)(numbers2, 0)((a, b) => a * a == b) )
    }

    def testEqualIf1 {
        val numbers1 = new Array[Int](10)
        val numbers2 = new Array[String](10)
        for (i <- 0 until 10) {
            numbers1(i) = i
            numbers2(i) = (i * i).toString
        }

        assert( ngl.equal_if(numbers1, 0, 5)(numbers2, 0)((a, b) => (a * a).toString == b) )
    }
}