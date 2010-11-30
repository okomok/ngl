

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


class SearchTest extends org.scalatest.junit.JUnit3Suite {

    def testSearch0 {
        val v1 = Array(1, 1, 2, 3, 5, 8)
        val v2 = Array(0, 1, 2, 3, 4, 5)
        val v3 = Array(3, 4)

        var location = ngl.search(v1, 0, 6)(v3, 0, 2)
        expect(6)(location)

        location = ngl.search(v2, 0, 6)(v3, 0, 2)
        expect(3)(location)
    }

    def testSearchIf0 {
        val v1 = Array(1, 1, 2, 3, 5, 8)
        val v2 = Array(0, 1, 2, 3, 4, 5)
        val v3 = Array(4, 3)

        var location = ngl.search_if(v1, 0, 6)(v3, 0, 2){ _ + _ == 7 }
        expect(6)(location)

        location = ngl.search_if(v2, 0, 6)(v3, 0, 2){ _ + _ == 7 }
        expect(3)(location)
    }

    val ints = Array(0, 1, 2, 3, 3, 4, 4, 4, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5)

    def testSearchN0 {
        val it = ngl.search_n(ints, 0, ints.length)(2, 2)
        expect(8)(it)
        expect(2)(ints(it))
        expect(2)(ints(it+1))
    }

    def testSearchN1 {
        val it = ngl.search_n(ints, 0, ints.length)(3, 3)
        expect(10)(it)
        expect(3)(ints(it))
        expect(3)(ints(it+1))
        expect(3)(ints(it+2))
    }

    def testSearchN2 {
        val it = ngl.search_n(ints, 0, ints.length)(4, 4)
        expect(13)(it)
        expect(4)(ints(it))
        expect(4)(ints(it+1))
        expect(4)(ints(it+2))
        expect(4)(ints(it+3))
    }

    def testSearchIfN1 {
        val it = ngl.search_n_if(ints, 0, ints.length)(3, 3)(_ + _ == 7)
        expect(5)(it)
        expect(4)(ints(it))
        expect(4)(ints(it+1))
        expect(4)(ints(it+2))
    }

}