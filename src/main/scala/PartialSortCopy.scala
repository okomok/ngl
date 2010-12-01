

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


private object PartialSortCopy {
    def apply[A](v : Seq[A], first: Int, __last: Int, ^ : Seq[A], __result_first: Int, __result_last: Int, __comp: Ordering[A]): Int = {
        var __first = first

        if (__result_first == __result_last) {
            return __result_last
        }
        var __result_real_last = __result_first
        while (__first != __last && __result_real_last != __result_last) {
            ^(__result_real_last) = v(__first)
            __result_real_last += 1
            __first += 1
        }
        MakeHeap(^, __result_first, __result_real_last, __comp)
        while (__first != __last) {
            if (__comp.lt(v(__first), ^(__result_first))) {
                AdjustHeap(^, __result_first, 0, __result_real_last - __result_first, v(__first), __comp)
            }
            __first += 1
        }
        SortHeap(^, __result_first, __result_real_last, __comp)
        __result_real_last
    }
}
