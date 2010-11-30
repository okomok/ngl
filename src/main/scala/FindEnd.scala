

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


private object FindEnd {
    def apply[A](v1: Seq[A], first1: Int, __last1: Int, v2: Seq[A], __first2: Int, __last2: Int, __pred: (A, A) => Boolean = EqualTo): Int = {
        var __first1 = first1

        if (__first2 == __last2) {
            return __last1
        }
        else {
            var __result = __last1
            while (true) {
                val __new_result = Search(v1, __first1, __last1, v2, __first2, __last2, __pred);
                if (__new_result == __last1) {
                    return __result
                }
                else {
                    __result = __new_result
                    __first1 = __new_result
                    __first1 += 1
                }
            }
            throw new Error("unreachable")
        }
    }
}
