

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


private object SetUnion {
    def apply[A, B >: A](v1: Seq[A], first1: Int, __last1: Int, v2: Seq[A], first2: Int, __last2: Int, ^ : Seq[B], result: Int, __comp: Ordering[A]): Int = {
        var __first1 = first1
        var __first2 = first2
        var __result = result

        while (__first1 != __last1 && __first2 != __last2) {
            val way = __comp.compare(v1(__first1), v2(__first2))
            if (way < 0) {
                ^(__result) = v1(__first1)
                __first1 += 1
            } else if (way > 0) {
                ^(__result) = v2(__first2)
                __first2 += 1
            } else {
                ^(__result) = v1(__first1)
                __first1 += 1
                __first2 += 1
            }
            __result += 1
        }
        Copy(v2, __first2, __last2, ^, Copy(v1, __first1, __last1, ^, __result))
    }
}


private object SetIntersection {
    def apply[A, B >: A](v1: Seq[A], first1: Int, __last1: Int, v2: Seq[A], first2: Int, __last2: Int, ^ : Seq[B], result: Int, __comp: Ordering[A]): Int = {
        var __first1 = first1
        var __first2 = first2
        var __result = result

        while (__first1 != __last1 && __first2 != __last2) {
            val way = __comp.compare(v1(__first1), v2(__first2))
            if (way < 0) {
                __first1 += 1
            } else if (way > 0) {
                __first2 += 1
            } else {
                ^(__result) = v1(__first1)
                __first1 += 1
                __first2 += 1
                __result += 1
            }
        }
        __result
    }
}


private object SetDifference {
    def apply[A, B >: A](v1: Seq[A], first1: Int, __last1: Int, v2: Seq[A], first2: Int, __last2: Int, ^ : Seq[B], result: Int, __comp: Ordering[A]): Int = {
        var __first1 = first1
        var __first2 = first2
        var __result = result

        while (__first1 != __last1 && __first2 != __last2) {
            val way = __comp.compare(v1(__first1), v2(__first2))
            if (way < 0) {
                ^(__result) = v1(__first1)
                __first1 += 1
                __result += 1
            } else if (way > 0) {
                __first2 += 1
            } else {
                __first1 += 1
                __first2 += 1
            }
        }
        Copy(v1, __first1, __last1, ^, __result);
    }
}


private object SetSymmetricDifference {
    def apply[A, B >: A](v1: Seq[A], first1: Int, __last1: Int, v2: Seq[A], first2: Int, __last2: Int, ^ : Seq[B], result: Int, __comp: Ordering[A]): Int = {
        var __first1 = first1
        var __first2 = first2
        var __result = result

        while (__first1 != __last1 && __first2 != __last2) {
            val way = __comp.compare(v1(__first1), v2(__first2))
            if (way < 0) {
                ^(__result) = v1(__first1)
                __first1 += 1
                __result += 1
            } else if (way > 0) {
                ^(__result) = v2(__first2)
                __first2 += 1
                __result += 1
            }
            else {
                __first1 += 1
                __first2 += 1
            }
        }
        Copy(v2, __first2, __last2, ^, Copy(v1, __first1, __last1, ^, __result))
    }
}
