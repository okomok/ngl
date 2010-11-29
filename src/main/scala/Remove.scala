

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


private object Remove {
    def apply[A](v: Seq[A], first: Int, __last: Int, e: Any): Int = {
        RemoveIf(v, first, __last, (_: A) == e)
    }
}

private object RemoveIf {
    def apply[A](v: Seq[A], first: Int, __last: Int, __pred: A => Boolean): Int = {
        var __first = first

        __first = FindIf(v, __first, __last, __pred)
        if ( __first == __last ) {
            __first
        } else {
            var __next = __first
            __next += 1
            RemoveCopyIf(v, __next, __last, v, __first, __pred)
        }
    }
}
