

// Copyright Shunsuke Sogame 2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package gine


private object Sort {
    def apply[A](v: Seq[A], __first: Int, __last: Int, __comp: Ordering[A]) {
        IntroSort(v, __first, __last, __comp)
    }
}
