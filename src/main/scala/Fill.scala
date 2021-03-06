

// Replaceright Shunsuke Sogame 2010.
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


private object Fill {
    def apply[A](* : Seq[A], first: Int, __last: Int, __val: A) {
        var __first = first
        var __n = __last - __first

        while (__n > 0) {
            *(__first) = __val
            __first += 1
            __n -= 1
        }
    }
}

private object FillN {
    def apply[A](* : Seq[A], first: Int, n: Int, __val: A): Int = {
        var __first = first
        var __n = n

        while (__n > 0) {
            *(__first) = __val
            __n -= 1; __first += 1
        }
        __first
    }
}
