

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


class RemoveTest extends org.scalatest.junit.JUnit3Suite {

    def testRemove1 {
        val numbers = Array(1, 2, 3, 1, 2, 3)

        ngl.remove(numbers, 0, 6)(1)

        expect(2)(numbers(0))
        expect(3)(numbers(1))
        expect(2)(numbers(2))
        expect(3)(numbers(3))
        expect(2)(numbers(4))
        expect(3)(numbers(5))
    }

    def testRemoveIf1 {
        val numbers = Array(0, 0, 1, 1, 2, 2)

        ngl.remove_if(numbers, 0, 6) { x => (x % 2) != 0 }

        expect(0)(numbers(0))
        expect(0)(numbers(1))
        expect(2)(numbers(2))
        expect(2)(numbers(3))
        expect(2)(numbers(4))
        expect(2)(numbers(5))
    }


    def testRemoveCopy1 {
        val numbers = Array(1, 2, 3, 1, 2, 3)
        val result = Array(0, 0, 0, 0, 0, 0)

        ngl.remove_copy(numbers, 0, 6)(result, 0)(2)

        expect(1)(result(0))
        expect(3)(result(1))
        expect(1)(result(2))
        expect(3)(result(3))
        expect(0)(result(4))
        expect(0)(result(5))
    }

    def testRemoveCopyIf1 {
        val numbers = Array(1, 2, 3, 1, 2, 3)
        val result = Array(0, 0, 0, 0, 0, 0)

        ngl.remove_copy_if(numbers, 0, 6)(result, 0) { x => (x % 2) != 0 }

        expect(2)(result(0))
        expect(2)(result(1))
        expect(0)(result(2))
        expect(0)(result(3))
        expect(0)(result(4))
        expect(0)(result(5))
    }
}