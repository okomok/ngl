

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


class MergeTest extends org.scalatest.junit.JUnit3Suite {

    def test0 {
        val numbers1 = Array(1, 6, 13, 25, 101)
        val numbers2 = Array(-5, 26, 36, 46, 99)
        val _numbers1 = ngl.Seq.from(numbers1)
        val _numbers2 = ngl.Seq.from(numbers2)
        val result = new Array[Int](10)
        val _result = ngl.Seq.from(result)

        ngl.merge(_numbers1, _numbers1.begin, _numbers1.end)(_numbers2, _numbers2.begin, _numbers2.end)(_result, _result.begin)

        expect(-5)(result(0))
        expect(1)(result(1))
        expect(6)(result(2))
        expect(13)(result(3))
        expect(25)(result(4))
        expect(26)(result(5))
        expect(36)(result(6))
        expect(46)(result(7))
        expect(99)(result(8))
        expect(101)(result(9))
    }

}