

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
package gine


private object LexicographicalCompare {
    def apply[A](v1: Seq[A], first1: Int, __last1: Int, v2: Seq[A], first2: Int, __last2: Int, __comp: Ordering[A]): Boolean = {
        if (LexicographicalCompare3way(v1, first1, __last1, v2, first2, __last2, __comp) < 0) true else false
    }
}


private object LexicographicalCompare3way {
    def apply[A](v1: Seq[A], first1: Int, __last1: Int, v2: Seq[A], first2: Int, __last2: Int, __comp: Ordering[A]): Int = {
        var __first1 = first1
        var __first2 = first2

        while ((__first1 != __last1) && (__first2 != __last2)) {
            val way = __comp.compare(v1(__first1), v2(__first2))
            if (way < 0) {
                return -1
            }
            if (way > 0) {
                return 1
            }
            __first1 += 1; __first2 += 1
        }
        if (__first2 == __last2) {
            if (__first1 == __last1) 0 else 1
        } else {
            -1
        }
    }
}
