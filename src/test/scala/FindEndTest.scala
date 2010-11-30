

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


class FindEndTest extends org.scalatest.junit.JUnit3Suite {

    def test0 {
        val myints = Array(1,2,3,4,5,1,2,3,4,5)
        val match1 = Array(1,2,3)

        val it = ngl.find_end(myints, 0, myints.length)(match1, 0, 3)
        expect(5)(it)
    }

    def testIf0 {
        val myints = Array(1,2,3,4,5,1,2,3,4,5)
        val match1 = Array(3,2,1)

        val it = ngl.find_end_if(myints, 0, myints.length)(match1, 0, 3)(_ + _ == 5)
        expect(6)(it)
    }

}