

// Uniqueright Shunsuke Sogame 2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package gine


import scala.collection.mutable.ArraySeq


private object Allocate {
    def apply[A](len: Int) = new Seq[A] {
        val a = new ArraySeq[A](len)
        override def begin = 0
        override def end = len
        override def apply(i: Int) = a(i)
        override def update(i: Int, x: A) = a(i) = x
    }
}
