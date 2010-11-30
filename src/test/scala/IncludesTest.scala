

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


class IncludesTest extends org.scalatest.junit.JUnit3Suite {

    def testIncludes0 {
        val numbers1 = Array(1, 2, 3, 4, 5)
        val numbers3 = Array(4, 8)

        val r1 = ngl.includes(numbers1, 0, 5)(numbers3, 0, 2)
        expect(false)(r1)
    }

    def testIncludes1 {
        val v1 = new Array[Int](10)
        val v2 = new Array[Int](3)
        for (i <- 0 until 10) {
            v1(i) = i
        }

        val r1 = ngl.includes(v1, 0, 10)(v2, 0, 3)
        expect(false)(r1)

        for (i <- 0 until 3) {
            v2(i) = i + 3
        }

        val r2 = ngl.includes(v1, 0, 10)(v2, 0, 3)
        expect(true)(r2)
    }

}