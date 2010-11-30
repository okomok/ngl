

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


class MismatchTest extends org.scalatest.junit.JUnit3Suite {

    def testMismatch0 {
        val numbers1 = Array(1, 2, 3, 4, 5)
        val numbers2 = Array(1, 2, 3, 4, 5)
        val numbers3 = Array(1, 2, 3, 2, 1)

        var result = ngl.mismatch(numbers1, 0, 5)(numbers2, 0)
        expect(5)(result._1)
        expect(5)(result._2)

        result = ngl.mismatch(numbers1, 0, 5)(numbers3, 0)
        expect(3)(result._1)
        expect(3)(result._2)
    }

    def testMismatchIf0 {
        val numbers1 = Array(1, 2, 3, 4, 5)
        val numbers2 = Array(1, 2, 3, 4, 5)
        val numbers3 = Array(1, 2, 3, 2, 1)

        var result = ngl.mismatch_if(numbers1, 0, 5)(numbers2, 0) { _ == _ }
        expect(5)(result._1)
        expect(5)(result._2)

        result = ngl.mismatch_if(numbers1, 0, 5)(numbers3, 0) { _ == _ }
        expect(3)(result._1)
        expect(3)(result._2)
    }

}