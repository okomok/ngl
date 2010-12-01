

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


private object StablePartition {
    def apply[A](* : Seq[A], first: Int, __last: Int, __pred: A => Boolean): Int = {
        var __first = first

        var break = false
        while (!break) {
            if (__first == __last) {
                return __first
            } else if (__pred(*(__first))) {
                __first += 1
            } else {
                break = true
            }
        }
        aux(*, __first, __last, __pred)
    }

    def aux[A](* : Seq[A], __first: Int, last: Int, __pred: A => Boolean): Int = {
        var __last = last

        var break = false
        __last -= 1
        while (!break) {
            if (__first == __last) {
                return __first
            } else if (!__pred(*(__last))) {
                __last -= 1
            }
            else {
                break = true
            }
        }
        __last += 1
        //Here we know that __pred(*--__last) is true
        aux_aux(*, __first, __last, __pred, true)
    }

    def aux_aux[A](* : Seq[A], __first: Int, __last: Int, __pred: A => Boolean, __pred_of_before_last: Boolean): Int = {
        inplace(*, __first, __last, __pred, __last - __first, false, __pred_of_before_last)
    }

    def inplace[A](* : Seq[A], __first: Int, __last: Int, __pred: A => Boolean, __len: Int, __pred_of_first: Boolean, __pred_of_before_last: Boolean): Int = {
        if (__len == 1) {
            return if (__pred_of_first && (__pred_of_before_last || __pred(*(__first)))) __last else __first
        }
        var __middle = __first
        val __half_len = __len / 2
        __middle += __half_len
        Rotate(*,
            inplace(*, __first, __middle, __pred, __half_len, __pred_of_first, false), __middle,
            inplace(*, __middle, __last, __pred, __len - __half_len, true, __pred_of_before_last) )
    }
}
