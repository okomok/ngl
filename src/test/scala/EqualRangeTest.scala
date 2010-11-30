

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


class EqualRangeTest extends org.scalatest.junit.JUnit3Suite {

    def testEqualRange0 {
        val numbers = Array(0, 0, 1, 1, 2, 2, 2, 2, 3, 3)
        val range = ngl.equal_range(numbers, 0, 10)(2)
        expect(4)(range._1)
        expect(8)(range._2)
    }

    def testEqualRange1 {
        val v = new Array[Int](10)
        for (i <- 0 until 10) {
            v(i) = i / 3
        }

        val range = ngl.equal_range(v, 0, 10)(2)
        expect(6)(range._1)
        expect(9)(range._2)

        var _1 = range._1
        var _2 = range._2
        while (_1 != _2) {
            expect(2)(v(_1))
            _1 += 1
        }

        val _range = ngl.equal_range(v, 0, 10)(4)
        assert(_range._1 == _range._2)
        expect(10)(_range._1)
    }

}