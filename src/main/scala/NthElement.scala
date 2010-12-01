

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


private object NthElement {
    def apply[A](* : Seq[A], first: Int, __nth: Int, last: Int, __comp: Ordering[A]) {
        var __first = first
        var __last = last

        while (__last - __first > 3) {
            val __cut = UnguardedPartition(*, __first, __last,
                Median(*(__first), *(__first + (__last - __first)/2), *(__last - 1), __comp),
                __comp)
            if (__cut <= __nth) {
                __first = __cut
            } else {
                __last = __cut
            }
        }
        InsertionSort(*, __first, __last, __comp)
    }
}
