

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


class FindFirstOfTest extends org.scalatest.junit.JUnit3Suite {

    val intsl = Array(2, 1)

    def test0 {
        val intv = Array(0, 1, 2, 3)

        val first = ngl.find_first_of(intv, 0, 4)(intsl, 0, 2)
        assert(first != 4)
        expect(1)(intv(first))
    }

    def test1 {
        val intv = Array(3, 2, 1, 0)

        val first = ngl.find_first_of(intv, 0, 4)(intsl, 0, 2)
        assert(first != 4)
        expect(2)(intv(first))
    }

    def testIf0 {
        val intv = Array(0, 1, 2, 3)

        val first = ngl.find_first_of_if(intv, 0, 4)(intsl, 0, 2)(_ == _)
        assert(first != 4)
        expect(1)(intv(first))
    }

    def testIf1 {
        val intv = Array(3, 2, 1, 0)

        val first = ngl.find_first_of_if(intv, 0, 4)(intsl, 0, 2)(_ == _)
        assert(first != 4)
        expect(2)(intv(first))
    }
}