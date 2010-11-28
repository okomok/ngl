

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
package gine


private object Replace {
    def apply[A](* : Seq[A], first: Int, __last: Int, __old_value: Any, __new_value: A) {
        ReplaceIf(*, first, __last, (_: A) == __old_value, __new_value)
    }
}

private object ReplaceIf {
    def apply[A](* : Seq[A], first: Int, __last: Int, __pred: A => Boolean, __new_value: A) {
        var __first = first

        while (__first != __last) {
            if (__pred(*(__first))) {
                *(__first) = __new_value
            }
            __first += 1
        }
    }
}
