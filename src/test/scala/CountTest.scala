

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


class CountTest extends org.scalatest.junit.JUnit3Suite {

    def test0 {
        val numbers = Array(1, 2, 4, 1, 2, 4, 1, 2, 4, 1)
        val _numbers = ngl.Seq.from(numbers)
        val result = ngl.count(_numbers, _numbers.begin, _numbers.end)(1)
        expect(4)(result)
    }

    def testIf0 {
        val numbers = Array(1, 2, 4, 1, 2, 4, 1, 2, 4, 1)
        val _numbers = ngl.Seq.from(numbers)
        val result = ngl.count_if(_numbers, _numbers.begin, _numbers.end)(_ == 4)
        expect(3)(result)
    }

}