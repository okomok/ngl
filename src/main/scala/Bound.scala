

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
package ngl


private object LowerBound {
    def apply[A](* : Seq[A], first: Int, __last: Int, __val: A, __comp: Ordering[A]): Int = {
        var __first = first

        var __len = __last - __first
        var __half = 0
        var __middle = 0

        while (__len > 0) {
            __half = __len >> 1
            __middle = __first
            __middle += __half
            if (__comp.lt(*(__middle), __val)) {
                __first = __middle
                __first += 1
                __len = __len - __half - 1
            } else {
                __len = __half
            }
        }
        __first
    }
}


private object UpperBound {
    def apply[A](* : Seq[A], first: Int, __last: Int, __val: A, __comp: Ordering[A]): Int = {
        var __first = first

        var __len = __last - __first
        var __half = 0

        while (__len > 0) {
            __half = __len >> 1
            var __middle = __first
            __middle += __half
            if (__comp.lt(__val, *(__middle))) {
                __len = __half
            } else {
                __first = __middle
                __first += 1
                __len = __len - __half - 1
            }
        }
        __first
    }

/* This also is ok.
    def apply[A](* : Seq[A], first: Int, __last: Int, __val: A, __comp: Ordering[A]): Int = {
        LowerBound(*, first, __last, __val, Ordering.fromLessThan[A] {
            (x, y) => __comp.lteq(x, y)
        })
    }
*/
}
